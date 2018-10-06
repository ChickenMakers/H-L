public class Server {

    private int lastGuiededSeat = -1;
    public Seats chickenSeats;
    Server(){
        chickenSeats = new Seats();
    }

    public int findFreeSeat(Clients targetClient){
        Clients [][] seatState = this.chickenSeats.getSeatState();
        int fullSeatCounter = 0;

        while (true){

            this.lastGuiededSeat = (++this.lastGuiededSeat % 16);
            int row = (this.lastGuiededSeat / 4);
            int col = (this.lastGuiededSeat % 4);

            if(seatState[row][col] == null){
                seatState[row][col] = targetClient;
                return lastGuiededSeat;
            }
            fullSeatCounter++;
            if(fullSeatCounter == this.chickenSeats.getTableCount()+1){
                System.out.println("죄송합니다! "+targetClient.teamName+"님 빈 좌석이 없습니다.");
                return -1;
            }
        }
    }
}