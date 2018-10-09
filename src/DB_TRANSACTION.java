import java.sql.*;

public class DB_TRANSACTION {

    private DB_AUTH MYAUTH;

    DB_TRANSACTION(){
        MYAUTH = new DB_AUTH();
    }
    private Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = String.format(
                    "jdbc:mysql://google/%s?cloudSqlInstance=%s&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
                    "chicken_logs",
                    "chickenmakers-218609:asia-east1:chicken-logs");
            connection = DriverManager.getConnection(jdbcUrl , MYAUTH.getAUTH_ID(), MYAUTH.getATUH_PW());
        }
//        jdbc:mysql://google/<DATABASE_NAME>?cloudSqlInstance=<INSTANCE_CONNECTION_NAME>&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=<MYSQL_USER_NAME>&password=<MYSQL_USER_PASSWORD>&useSSL=false

        catch(SQLException SQL_E){
            SQL_E.printStackTrace();
        }
        catch (Exception E){
            E.printStackTrace();
        }
        return connection;
    }
    public void DB_INSERT_QUERY(String chickName , int payment , int numOfClient , int orderNum , Date dealingDate) throws  SQLException{

        Connection TEMP_CONNECTION = null;
        PreparedStatement TEMP_PREPARED_STATEMENT = null;

        String INSERT_SQL = "INSERT INTO chicken_statistic ( revenue_id , chickenName , payment , client , orderNum , dealingDate)"
                +" VALUES ( * , ? , ? , ? , ? , ?);";

        try{

            TEMP_CONNECTION = getConnection();
            TEMP_PREPARED_STATEMENT = TEMP_CONNECTION.prepareStatement(INSERT_SQL);

            TEMP_PREPARED_STATEMENT.setString(1,chickName);
            TEMP_PREPARED_STATEMENT.setInt(2,payment);
            TEMP_PREPARED_STATEMENT.setInt(3,numOfClient);
            TEMP_PREPARED_STATEMENT.setInt(4,orderNum);
            TEMP_PREPARED_STATEMENT.setDate(5,dealingDate);

        }
        catch (SQLException SQL_E){
            SQL_E.printStackTrace();
        }
        finally {

            if (TEMP_PREPARED_STATEMENT != null) {
                TEMP_PREPARED_STATEMENT.close();
            }

            if (TEMP_CONNECTION != null) {
                TEMP_CONNECTION.close();
            }

        }
    }

}
