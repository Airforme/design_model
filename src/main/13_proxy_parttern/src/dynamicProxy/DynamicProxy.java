package dynamicProxy;

public class DynamicProxy {
    /**
     * 代理对象必须实现接口
     * @param args
     */
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        IUserDao proxy = (IUserDao)new ProxyFactory(target).getProxyInstance();
        proxy.save();
    }
}
