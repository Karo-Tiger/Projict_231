package tiger.servis;

import org.springframework.stereotype.Service;
import tiger.dao.UserDao;
import tiger.model.User;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserServisImpl implements UserServise {


    private final UserDao userDao;

    public UserServisImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
    @Transactional()
    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }
    @Transactional()
    @Override
    public List<User> getUser() {
        return userDao.getUser();
    }
}
