package v3tomd.buitensportenapp.Utils;

import java.sql.*;

import v3tomd.buitensportenapp.Model.Activiteit;

/**
 * Created by Vidjinder on 29-3-2016.
 */
public class DatabaseConnector {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/buitensportenapp";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Gebruiker";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("idGebruiker");
                String naam = rs.getString("naam");
                String username = rs.getString("username");
                String password = rs.getString("password");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Naam: " + naam);
                System.out.print(", Username: " + username);
                System.out.println(", Password: " + password);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void addActiviteit(Activiteit activiteit){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO activiteit " +
                    "VALUES ("+activiteit.getMyID()+","+ activiteit.getTitel()+","+activiteit.getSportTypeString()+","
                    +activiteit.getDate()+","+activiteit.getMinLeeftijd()+","+activiteit.getMaxLeeftijd()+","+activiteit.getAantalDeelnemers()+","+activiteit.getLocatie()+")";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try


    }

}
