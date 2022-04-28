package psk.usecases;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@LogMethodInvocations
@Interceptor
public class LogMethodInvocationsImpl {
    @AroundInvoke
    public Object doSomeStuff(InvocationContext ctx) throws Exception {
        System.out.println("Method '" + ctx.getMethod().getName() +
                "' from class '" + ctx.getTarget().getClass().getName() + "' called");
        Object result = ctx.proceed();
        return result;
    }
}