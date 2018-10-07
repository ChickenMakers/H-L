import java.sql.Connection;
import java.sql.Statement;

public class DB_TRANSACTION {
    protected Connection connection = null;
    protected Statement st = null;
    DB_TRANSACTION(){

        Class.forName("com.mysql.cj.jdbc.Driver");



    }
}
