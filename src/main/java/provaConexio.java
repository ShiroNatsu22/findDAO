/**
 * Created by jgarcias on 07/12/16.
 */    import java.sql.*;




    public class provaConexio {
        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://172.16.4.227/dwes";

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "test";

        public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            try{
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                //STEP 4: Execute a query
                System.out.println("Creating statement...");
                stmt = conn.createStatement();
                String sql;

                sql = "SELECT user.user_name,roles.role_name,roles.role_description,user.user_pass FROM user,roles,user_roles where user.user_name = user_roles.user_name && user_roles.role_name=roles.role_name";

                ResultSet rs = stmt.executeQuery(sql);

                //STEP 5: Extract data from result set
                while(rs.next()){

                    String uname = rs.getString("user.user_name");
                    String  rol = rs.getString("role_name");
                    String desc = rs.getString("role_description");

                    //Display values
                    System.out.println("User: " + uname);
                    System.out.println("rol: " + rol);
                    System.out.println(desc);


                }
                //STEP 6: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
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
                        stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
            System.out.println("Goodbye!");
        }//end main
    }//end FirstExample


