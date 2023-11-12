package main.org.example.jdbc.dao.impl;

import main.org.example.jdbc.dao.abs.RoleDAO;
import main.org.example.servlets.model.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleDAOImpl implements RoleDAO {

    private static List<Role> roles = Arrays.asList(
            new Role(123, "Admin", "Admin role", null, null),
            new Role(123, "Manager", "Manager role", null, null),
            new Role(123, "General_User", "Admin role", null, null));


    @Override
    public boolean create(Role type) {
        return false;
    }

    @Override
    public Role findById(Integer key) {
        for (Role role : roles) {
            if (role.getId().equals(key))
                return role;
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer key) {
        return false;
    }

    @Override
    public boolean update(Role type) {
        return false;
    }

    @Override
    public Set<Role> all() {
        return new HashSet<>(roles);
    }

    @Override
    public Role findByName(String name) {
        for (Role role : roles) {
            if (role.getName().equalsIgnoreCase(name))
                return role;
        }
        return null;

    }
}
