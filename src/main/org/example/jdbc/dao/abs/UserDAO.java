package main.org.example.jdbc.dao.abs;

import main.org.example.servlets.model.Role;
import main.org.example.servlets.model.User;

import java.util.List;
import java.util.Set;

public interface UserDAO extends AbstractDAO<User, Integer> {

    User findByEmail(String email);

    Set<User> findByRole(Role role);

    void activate(User user);
}
