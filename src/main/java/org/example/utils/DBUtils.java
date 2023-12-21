package org.example.utils;

import org.example.model.Car;
import org.example.model.Girl;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static User findUser(Connection conn, int id) throws SQLException {

        String sql1 = "select u.name from users u where u.id = ?";
        String sql2 = "select g.id, g.name, g.age from girls g where user_id = ?";
        String sql3 = "select c.id, c.manufacturer, c.model from cars c where user_id = ?";

        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        PreparedStatement pstm2 = conn.prepareStatement(sql2);
        PreparedStatement pstm3 = conn.prepareStatement(sql3);
        pstm1.setInt(1, id);
        pstm2.setInt(1, id);
        pstm3.setInt(1, id);
        ResultSet rs1 = pstm1.executeQuery();
        ResultSet rs2 = pstm2.executeQuery();
        ResultSet rs3 = pstm3.executeQuery();

        if (rs1.next()) {
            String name = rs1.getString("name");
            User user = new User();
            user.setId(id);
            user.setName(name);
            List<Girl> girls = new ArrayList<>();
            while (rs2.next()) {
                Integer girlId = rs2.getInt("id");
                String girlName = rs2.getString("name");
                Integer girlAge = rs2.getInt("age");
                Girl girl = new Girl(girlId, girlName, girlAge, id);
                girls.add(girl);
            }
            user.setGirls(girls);
            List<Car> cars = new ArrayList<>();
            while (rs3.next()) {
                Integer carId = rs3.getInt("id");
                String carManufacturer = rs3.getString("manufacturer");
                String carModel = rs3.getString("model");
                Car car = new Car(carId, carManufacturer, carModel, id);
                cars.add(car);
            }
            user.setCars(cars);
            return user;
        }
        return null;
    }
    public static void deleteUser(Connection conn, int id) throws SQLException{
        String sql = "delete from users where id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.executeUpdate();
    }

    public static void updateUser(Connection conn, User user) throws SQLException{
        String sql = "update user set name = ? where id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, user.getName());
        pstm.setInt(2, user.getId());
        pstm.executeUpdate();
    }

    public static void insertUser(Connection conn, User u) throws SQLException{
        String sql = "insert into users(name) values (?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, u.getName());
    }
}
