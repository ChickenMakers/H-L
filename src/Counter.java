public class Counter {
    public void getPaid(TaskNode taskInfo , int numOfClients){

        Clients [][] seatState = Seats.getSeatState();
        int row = (taskInfo.tableNum / 4);
        int col = (taskInfo.tableNum % 4);
        seatState[row][col] = null;

    }
    private void writeLog(TaskNode taskInfo , int numOfClients){
        //pass
    }
}
