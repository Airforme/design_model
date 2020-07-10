package dynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象创建一个代理对象
     * @return
     */
    public Object getProxyInstance(){
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理方法执行前...");
        Object invoke = method.invoke(target, objects);
        System.out.println("代理方法执行后...");
        return invoke;

    }

    public static void main(String[] args) {
        ContentDao instance = (ContentDao)new CglibProxyFactory(new ContentDao()).getProxyInstance();
        instance.saveContent("Tome","Jerry");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ContentDao.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before method run...");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after method run...");
            return result;
        });
        ContentDao o = (ContentDao)enhancer.create();
        o.saveContent("Tome","Jerry");
    }
}
