package staticProxy;

public class StaticClient13 {
    public static void main(String[] args) {
        IUserDao dao = new UserDaoProxy(new UserDao());
        dao.save();
    }
}
