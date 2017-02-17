package com.baeldung.cglib.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonServiceProxyTest {
    @Test
    public void testService() {
        //given
        PersonService personService = new PersonService();

        //when
        String res = personService.sayHello("Tom");

        //then
        assertEquals(res, "Hello Tom");
    }

    @Test
    public void testFixedValue() throws Exception {
        //given
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello cglib!");
        PersonService proxy = (PersonService) enhancer.create();

        //when
        String res = proxy.sayHello(null);

        //then
        assertEquals("Hello cglib!", res);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        //given
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello cglib!";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });

        //when
        PersonService proxy = (PersonService) enhancer.create();

        //then
        assertEquals("Hello cglib!", proxy.sayHello(null));

        int lengthOfName = proxy.lengthOfName("Mary");
        assertEquals(4, lengthOfName);
    }

}