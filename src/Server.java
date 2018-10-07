public class Server {

    private int lastGuiededSeat = -1;
    public Seats chickenSeats;
    public Counter counter;
    Server(){
        chickenSeats = new Seats();
        counter = new Counter(this);
    }

    public int findFreeSeat(Clients targetClient){
        Clients [][] seatState = this.chickenSeats.getSeatState();
        int fullSeatCounter = 0;

        while (true){

            this.lastGuiededSeat = (++this.lastGuiededSeat % this.chickenSeats.getTableCount());
            int row = (this.lastGuiededSeat / this.chickenSeats.getN());
            int col = (this.lastGuiededSeat % this.chickenSeats.getN());

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
    public void cleanTable(int row , int col){
        this.chickenSeats.cleanTable(row,col);
        System.out.println((row*this.chickenSeats.getN())+(col)+"번 테이블을 정리하였습니다.");
    }
}