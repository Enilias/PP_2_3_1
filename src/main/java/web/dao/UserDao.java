package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void save(User user);

    void delete(int id);

    User getUser(int id);

    public void update(int id, String name, String surname);
}
