public class Server {

    private int lastGuiededSeat = -1;
    public Seats chickenSeats;
    public Counter counter;
    private Kitchen kitchen;
    private int issuedOrderNum = 0;
    Server(){
        chickenSeats = new Seats();
        counter = new Counter(this);
        kitchen = new Kitchen(this);
    }

    public int findFreeSeat(Clients targetClient){
        Clients[][] seatState = this.chickenSeats.getSeatState();
        int fullSeatCounter = 0;

        while (true){
            this.lastGuiededSeat = (++this.lastGuiededSeat % this.chickenSeats.getTableCount());
            int row = (this.lastGuiededSeat / this.chickenSeats.getN());
            int col = (this.lastGuiededSeat % this.chickenSeats.getN());

            if(this.chickenSeats.isNullElement(row, col)){
                System.out.println("[Server] "+ lastGuiededSeat+"번 테이블에 좌석이 할당되었습니다.");
                seatState[row][col] = targetClient;
                break;
            }
            fullSeatCounter++;
            if(fullSeatCounter == this.chickenSeats.getTableCount()+1){
                System.out.println("[Server] 죄송합니다! "+targetClient.teamName+"님 빈 좌석이 없습니다.");
                lastGuiededSeat = -1;
                break;
            }
        }
        return lastGuiededSeat;
    }
    public void takeOrder(String chickenName, int tableNum){
        issuedOrderNum = kitchen.getLastOrderNum();
        if (issuedOrderNum == -1) {
            issuedOrderNum = 1;
        }
        else {
            issuedOrderNum++;
        }
        kitchen.orderPush(chickenName, tableNum, issuedOrderNum);
        System.out.println("[Server] "+tableNum+"번 테이블에서 "+chickenName+" 을 주문하였습니다!");
    }

    public void startServing(TaskNode taskNode){
        Clients[][] seatState = chickenSeats.getSeatState();
        int tablenum = taskNode.tableNum;
        int N = chickenSeats.getN();
        seatState[tablenum / N][tablenum % N].getChicken(taskNode);
        System.out.println("[Server] "+taskNode.tableNum + "번 테이블 손님에게 " + taskNode.chickenName + "을 전달했습니다.");
    }

    public void cleanTable(int row , int col){
        this.chickenSeats.cleanTable(row,col);
        System.out.println("[Server] "+(row*this.chickenSeats.getN()+col)+"번 테이블을 정리하였습니다.");
    }
}