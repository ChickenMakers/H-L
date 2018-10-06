public class Counter {
    private Server server;
    Counter(Server server){
        this.server = server;
    }
    public void getPaid(TaskNode taskInfo , int numOfClients){

        Clients [][] seatState = this.server.chickenSeats.getSeatState();
        //this.server.cleanTable(row,col);

    }
    private void writeLog(TaskNode taskInfo , int numOfClients){
        //pass
    }
}
