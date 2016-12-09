/**
 * Created by jgarcias on 07/12/16.
 */
public interface UserDao {
    User findUser(String name);
    User findUser(String name, boolean fillRoll);
}
