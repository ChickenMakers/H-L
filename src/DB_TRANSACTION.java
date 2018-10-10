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
                    "jdbc:mysql://google/%s?cloudSqlInstance=%s"
                            + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=FALSE",
                    "chicken_logs",
                    "chickenmakers-218609:asia-east1:chicken-logs");
            connection = DriverManager.getConnection(jdbcUrl , MYAUTH.getAUTH_ID(), MYAUTH.getAUTH_PW());
            System.out.println("클라우드 SQL에 잘 연결되었습니다.");

        }
        catch(SQLException SQL_E){
            SQL_E.printStackTrace();
        }
        catch (Exception E){
            E.printStackTrace();
        }
        finally {
            return connection;
        }
    }
    public void DB_INSERT_QUERY(String chickName , int payment , int numOfClient , int orderNum , String dealingDate) throws  SQLException{

        Connection TEMP_CONNECTION = null;
        PreparedStatement TEMP_PREPARED_STATEMENT = null;
        Statement TEMP_STATEMENT = null;
        int result_integer = 0;

        String INSERT_SQL = "INSERT INTO chick_statistic ( chickenName , payment , client , orderNum , dealingDate)"
                +" VALUES ( ? , ? , ? , ? , ?);";

        try{
            TEMP_CONNECTION = getConnection();
            TEMP_PREPARED_STATEMENT = TEMP_CONNECTION.prepareStatement(INSERT_SQL);

            TEMP_PREPARED_STATEMENT.setString(1,chickName);
            TEMP_PREPARED_STATEMENT.setInt(2,payment);
            TEMP_PREPARED_STATEMENT.setInt(3,numOfClient);
            TEMP_PREPARED_STATEMENT.setInt(4,orderNum);
            TEMP_PREPARED_STATEMENT.setString(5,dealingDate);
            result_integer = TEMP_PREPARED_STATEMENT.executeUpdate();
            if (result_integer > 0) {
                System.out.println("[DB] DB에 "+chickName+"을 시킨 주문이 "+ result_integer +" row만큼 성공적으로 추가되었습니다.");
            }
        }
        catch (SQLException SQL_E){
            SQL_E.printStackTrace();
        }
        finally {

            if(TEMP_STATEMENT != null){
                TEMP_STATEMENT.close();
            }

            if (TEMP_PREPARED_STATEMENT != null) {
                TEMP_PREPARED_STATEMENT.close();
            }

            if (TEMP_CONNECTION != null) {
                TEMP_CONNECTION.close();
            }

        }
    }

}
