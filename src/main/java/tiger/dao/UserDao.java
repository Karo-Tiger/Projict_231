package tiger.dao;

import tiger.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUser(Integer id);
    List<User> getUser();
}
