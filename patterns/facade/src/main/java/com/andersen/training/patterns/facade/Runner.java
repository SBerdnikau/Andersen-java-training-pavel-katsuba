package com.andersen.training.patterns.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *Interfaces Connection and PreparedStatement give methods for work with DB but hide realisation details.
 */
public class Runner {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(null);
        PreparedStatement ps = connection.prepareStatement(null);
    }
}
