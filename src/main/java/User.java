import java.util.List;

/**
 * Created by jgarcias on 07/12/16.
 */
public class User {
    private String name;
    private List<Rol> getAllUser;

    public User(String name, String pass) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
