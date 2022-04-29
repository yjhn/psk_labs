package psk.rest;

import lombok.Getter;
import lombok.Setter;
import psk.jpa.entities.City;
import psk.jpa.entities.Store;
import psk.jpa.entities.StoreNetwork;
import psk.jpa.persistence.CitiesDAO;
import psk.jpa.persistence.StoreNetworksDAO;
import psk.jpa.persistence.StoresDAO;
import psk.rest.contracts.StoreDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@ApplicationScoped
@Path("/stores")
public class StoresController {
    @Inject
    @Setter
    @Getter
    private StoresDAO storesDAO;

    @Inject
    @Setter
    @Getter
    private CitiesDAO citiesDAO;

    @Inject
    @Setter
    @Getter
    private StoreNetworksDAO storeNetworksDAO;

    @Context
    private UriInfo uriInfo;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final int id) {
        Store store = storesDAO.findById(id);
        if (store == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        StoreDTO storeDto = new StoreDTO();
        storeDto.setId(store.getId());
        storeDto.setAddressInCity(store.getAddressInCity());
        storeDto.setCityId(store.getCity().getId());
        storeDto.setCityName(store.getCity().getName());
        storeDto.setCityCountryName(store.getCity().getCountryName());
        storeDto.setCityFullName(store.getCity().getFullCityName());
        storeDto.setStoreNetworkId(store.getStoreNetwork().getId());
        storeDto.setStoreNetworkName(store.getStoreNetwork().getName());

        return Response.ok(storeDto).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(@NotNull StoreDTO storeDto) {
        City c = citiesDAO.findById(storeDto.getCityId());
        if(c == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Store must have a valid cityId").build();
        }
        StoreNetwork n = storeNetworksDAO.findById(storeDto.getStoreNetworkId());
        if(n == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Store must have a valid storeNetworkId").build();
        }
        n.getCitiesWithStores().add(c);
        Store store = new Store();
        store.setAddressInCity(storeDto.getAddressInCity());
        store.setCity(c);
        store.setStoreNetwork(n);
        storesDAO.persist(store);

        return Response.created(uriInfo.getRequestUri().resolve(String.valueOf(store.getId()))).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final int storeId,
            @NotNull StoreDTO storeDto) {
        try {
            Store existingStore = storesDAO.findById(storeId);
            if (existingStore == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            City c = citiesDAO.findById(storeDto.getCityId());
            if(c == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Store must have a valid cityId").build();
            }
            StoreNetwork n = storeNetworksDAO.findById(storeDto.getStoreNetworkId());
            if(n == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Store must have a valid storeNetworkId").build();
            }
            n.getCitiesWithStores().add(c);
            existingStore.setAddressInCity(storeDto.getAddressInCity());
            existingStore.setCity(c);
            existingStore.setStoreNetwork(n);

            storesDAO.update(existingStore);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
