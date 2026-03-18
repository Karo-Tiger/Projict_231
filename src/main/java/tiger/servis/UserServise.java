package tiger.servis;

import tiger.model.User;

import java.util.List;

public interface UserServise {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUser(Integer id);
    List<User> getUser();
}
