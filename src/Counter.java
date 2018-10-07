public class Counter {
    private Server server;
    Counter(Server server){
        this.server = server;
    }
    public void getPaid(TaskNode taskInfo , int numOfClients){

        Clients [][] seatState = this.server.chickenSeats.getSeatState();
        int row = (taskInfo.tableNum / this.server.chickenSeats.getN());
        int col = (taskInfo.tableNum % this.server.chickenSeats.getN());
        System.out.println("[Counter] "+taskInfo.tableNum + "번 테이블 손님이 계산을 완료했습니다.");
        this.server.cleanTable(row,col);

    }
//    private void writeLog(TaskNode taskInfo , int numOfClients){
//
//    }
}
