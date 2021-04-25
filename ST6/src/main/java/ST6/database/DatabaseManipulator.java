package ST6.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManipulator {
        
    // tjekker forbindelsen til "com.mysql.cj.jdbc.Driver"
    // med detaljerne indtasteti DatabaseDetails
    public static Connection getConnection(){
        
        Connection conn = null;
        
        // Try to load the Driver. This is done for compatibility reasons
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Try to get the connection up and running
            try {
                conn = DriverManager.getConnection(DatabaseDetails.host, DatabaseDetails.username, DatabaseDetails.password);
                System.out.println("Connection til databasen er oprettet :-) ");
            }
            catch (SQLException sqlex) {
                System.out.println("Connection Error: " + sqlex.getMessage());
            }
            
        }
        catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        
        // Return the connection object
        return conn;
    }

    //metoden kalder sin søstermetode med to input
    public static void executeQueryWithResultSet(Queryable queryable){
        executeQueryWithResultSet(queryable.returnSqlQuery(), queryable);
    }
    
    // opretter forbindelse til databasen og henter data med de overskrevne metoder fra interfacet
    public static void executeQueryWithResultSet(String sqlStatement, Queryable queryable){
        Connection conn = getConnection();
       
        Statement stmt = null;
        ResultSet rs = null;
        
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlStatement);   
                queryable.processResultSet(rs);         
                queryable.returnSqlQuery();
            } catch (SQLException sqlex) {
                System.out.println(sqlex.getMessage());
            }
            finally {
                try {
                    rs.close();                         // lukker forbindelsen til databasen igen
                } catch (SQLException sqlex) {
                    System.out.println(sqlex.getMessage());
                }
            }
        }
    }
}
