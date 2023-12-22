package org.example.repository;

import org.example.connection.ConnectionUtil;
import org.example.model.User;
import org.example.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class UserRepository {

    public UserRepository() throws SQLException, ClassNotFoundException {
    }

    public User get(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtil.getConnection();
        User user =  DBUtils.findUser(connection, id);
        ConnectionUtil.closeQuietly(connection);
        return user;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtil.getConnection();
        DBUtils.deleteUser(connection, id);
        ConnectionUtil.closeQuietly(connection);
    }

    public void update(User user) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtil.getConnection();
        DBUtils.updateUser(connection, user);
        ConnectionUtil.closeQuietly(connection);
    }

    public void create(User user) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtil.getConnection();
        DBUtils.insertUser(connection, user);
        ConnectionUtil.closeQuietly(connection);
    }
}
