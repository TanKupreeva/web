package main.org.example.jdbc.dao.impl;

import main.org.example.jdbc.dao.abs.AbstractDAO;
import main.org.example.jdbc.dao.abs.DogDAO;
import main.org.example.servlets.model.Dog;
import main.org.example.servlets.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class DogDAOImpl implements DogDAO {

    @Override
    public boolean create(Dog type) {
        return false;
    }

    @Override
    public Dog findById(Integer id) {
        Connection conn = DBUtils.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM offices where id  = " + id);
            if (rs.next()) {
                System.out.println("Dog with ID = " + id + " found!");
                Dog dog = new Dog();
                dog.setId(id);
                dog.setAge(rs.getInt("age"));
                dog.setName(rs.getString("name"));
                dog.setBreed(rs.getString("breed"));
                return dog;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer key) {
        return false;
    }

    @Override
    public boolean update(Dog type) {
        return false;
    }

    @Override
    public Set<Dog> all() {
        return null;
    }
}
