package staticProxy;

public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("已经保存用户数据");
    }
}
