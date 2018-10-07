public class Counter {
    private Server server;
    Counter(Server server){
        this.server = server;
    }
    public void getPaid(TaskNode taskInfo , int numOfClients){

        Clients [][] seatState = this.server.chickenSeats.getSeatState();
        int row = (taskInfo.tableNum / this.server.chickenSeats.getN());
        int col = (taskInfo.tableNum % this.server.chickenSeats.getN());
        this.server.cleanTable(row,col);

    }
//    private void writeLog(TaskNode taskInfo , int numOfClients){
//
//    }
}
