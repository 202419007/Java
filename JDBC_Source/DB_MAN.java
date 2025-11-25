import java.sql.*;
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yang-yeeun
 */
public class DB_MAN {
    String strDriver = "org.sqlite.JDBC";
    String strURL = "jdbc:sqlite:/Users/yang-yeeun/Desktop/Java_Project/JDBC_Source/Automobile.db";
    
    Connection DB_con;
    Statement DB_stmt;
    ResultSet DB_rs;
    
    public void dbOpen()  throws IOException {
        HG_ErrorMessage();
        try {
            Class.forName(strDriver);
            DB_con = DriverManager.getConnection(strURL);
            DB_stmt = DB_con.createStatement();
            System.out.println("DB 연결 성공!");
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
            System.out.println("SQLException : " + e.toString());
            e.printStackTrace();
        }
    }
    
    public void dbClose() throws IOException {
        HG_ErrorMessage();
        try {
            DB_stmt.close();
            DB_con.close();
        } catch (SQLException e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }

    private void HG_ErrorMessage() throws UnsupportedEncodingException {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
}
