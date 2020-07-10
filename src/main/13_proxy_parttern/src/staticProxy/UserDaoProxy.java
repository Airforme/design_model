package staticProxy;

public class UserDaoProxy implements IUserDao {

    private IUserDao dao;

    public UserDaoProxy(IUserDao dao) {
        this.dao = dao;
    }

    @Override
    public void save() {
        dao.save();
    }
}
