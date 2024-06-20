/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GIGABYTE
 */
package ConnectDb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tab135
 */
public class ConnectDB {
    
    public static Connection getConnect(){
        try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                return  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BOOKS;encrypt=true;trustServerCertificate=true;characterEncoding=UTF-8","sa" ,"123456");
        }catch(Exception e){
                return null;
        }
        

}

}