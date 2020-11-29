package fr.greta.java.generic.tools;

import java.sql.*;

public class JdbcTool {
    public static void close(ResultSet resultSet, Statement statement, Connection conn) {
        if(resultSet != null) {
        	close(resultSet);
        }
        if(statement != null) {
        	close(statement);
        }
        if(conn != null) {
        	close(conn);
        }
    }

    private static void close(ResultSet resultSet){
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void close(Statement statement){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
