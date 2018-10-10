import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;

public class Counter {
    private Server server;
    private DB_TRANSACTION MYDB;
    Counter(Server server){
        this.server = server;
        this.MYDB = new DB_TRANSACTION();
    }
    public void getPaid(TaskNode taskInfo , int numOfClients){

        Clients [][] seatState = this.server.chickenSeats.getSeatState();
        int row = (taskInfo.tableNum / this.server.chickenSeats.getN());
        int col = (taskInfo.tableNum % this.server.chickenSeats.getN());
        System.out.println("[Counter] "+taskInfo.tableNum + "번 테이블 손님이 계산을 완료했습니다.");
        this.server.cleanTable(row,col);
        this.writeLog(taskInfo,numOfClients);

    }
    private void writeLog(TaskNode taskInfo , int numOfClients){
//        revenue_id, chickenName, payment, client, orderNum, dealingDate

        String ChickName = taskInfo.chickenName;
        int payment = getPrice(ChickName);
        int orderNum = taskInfo.orderNum;
        String dealingDate = getDate();
        try{
            this.MYDB.DB_INSERT_QUERY(ChickName , payment , numOfClients , orderNum , dealingDate);
        }
        catch (SQLException SQL_E){
            SQL_E.printStackTrace();
        }
    }

    private int getPrice(String chickName){
        Menus menus = new Menus();
        return menus.getPriceMap().get(chickName);
    }

    private String getDate() {
        Date date = new Date();
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        return currentTime;
    }

}
