package main.org.example.jdbc.dao.abs;

import main.org.example.servlets.model.Role;

public interface RoleDAO extends AbstractDAO<Role, Integer>{
    Role findByName(String name);
}
