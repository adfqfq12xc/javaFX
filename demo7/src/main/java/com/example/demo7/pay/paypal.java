package com.example.demo7.pay;

import com.example.demo7.DatabaseConnection;
import com.example.demo7.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class paypal implements paymant{
    @Override
    public void pay(int price, String name, User u) {
        int i = u.id;
        var con = DatabaseConnection.getConnection();
        String sql = "INSERT INTO public.paymant(\n" +
                "\t\"NameFood\", \"Price\", \"user_id\", \"Payby\")\n" +
                "\tVALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, name);   // Assuming column1 is for 'name'
            preparedStatement.setInt(2, price);  // Assuming column2 is for 'price'
            preparedStatement.setInt(3, i);         // Assuming column3 is for 'i'
            preparedStatement.setString(4, "Paypal");
             preparedStatement.executeUpdate();
            System.out.println("with paypal");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
