Chicken Maker
=============

1.Analysis
----------

### (1) 주방
1. [주방]은 [홀서빙]으로부터 [손님]의 주문을 전달받습니다.
2. [주방]은 각각의 메뉴를 동시에 조리 할 수 없고 조리시간은 메뉴에 따라 다릅니다.
3. [주방]은 요리를 마치고 나면 완성된 요리를 [홀서빙]에게 서빙을 지시하고 전달받았던 조리 지시를 확인하여 다음의 조리를 시작합니다.

### (2) 좌석
1. [좌석]은 4 X 4 이차원 매트릭스의 형태로 설정되고 각각의 매트릭스 원소들은 한 테이블을 나타냅니다. 한 테이블당 최대 4명까지 앉을 수 있습니다.
2. [좌석]에 손님이 앉으려면 [홀서빙]이 안내하는 위치로 가야합니다.
3. [좌석]에서 [손님]이 일어나는 경우는 [좌석]에서 [손님]이 일정시간을 식사한 후 입니다.
4. [좌석]자체는 자신의 자리가 비었다는 것을 누구에게 알릴 수 없습니다.

### (3) 홀서빙
1. [홀서빙]은 [손님]이 왔을 경우 인원수를 묻습니다.
2. [홀서빙]은 [손님]의 응답에 [좌석]을 먼저 안내합니다.
3. [홀서빙]은 [손님]이 [좌석]에 앉았을 때 주문을 받고 [카운터]로 전달합니다.
4. [홀서빙]은 받은 주문을 [주방]에 전달합니다.
5. [홀서빙]은 [주방]에서 완성된 요리를 [손님]에게 전달합니다.

### (4) 카운터
1. [카운터]는 [홀서빙]으로 부터 주문을 전달받습니다.
2. [카운터]는 [손님]으로부터 식사에 대한 계산을 진행합니다.
3. [카운터]는 [손님]과의 계산에 대한 내용을 기록합니다.
4. [카운터]는 [손님]과의 계산과 기록을 마치면 [좌석]을 업데이트 합니다.

### (5) 손님
1. [손님]은 무작위의 인원수로 식당에 입장합니다.
2. [손님]은 [홀서빙]으로부터 안내를 받고 인원수를 응답합니다.
3. [손님]은 일정한 시간 이후 [홀서빙]에게 주문을 합니다.
4. [손님]은 [홀서빙]으로부터 받은 요리를 일정 시간동안 식사합니다.
5. [손님]은 식사를 마치면 카운터에서 계산을 합니다.

## 2. Design

### (1) Kitchen
1. Order Queue (FIFO) , Node
2. this.orderPush( String chickName , int tableNum , int orderNum)
~~~
    // 각 요리메뉴에 대한 조리시간을 가져옵니다.
    this.getCookingTime(chickName) -> Integer
    Queue.push({
            orderNum : Interger,
            chickName : String,
            cookingTime : Integer,
            tableNum : Integer
    })
    if(this.isCooking == false){
       startCooking();
       
    }
    
~~~
3. this.startCooking()
~~~
    this.isCooking = true;
    TaskNode = Queue.pop();
    TimerTask Task = new TimerTask()
    {
        run(){
            // Do with TaskNode...
            endCooking(TaskNode);
        }
    }
    Timer.schedule( Task , Task.cookingTime );
    
~~~

4.this.endCooking(TaskNode)
~~~
    server.startServing(TaskNode);
    if(Queue.isEmpty() == false){
        this.startCooking();
    }
    else{
        this.isCooking = false;
    }
~~~

### (2) Seats

#### Initialize : 4 X 4 2D Array

1.Array Elements are Clients.  
2.If value of array element is null. There is no client in table else, the Table is not empty and value is client class object.
 
### (3) Clients
1. constructor(int numOfClients,String teamName)
~~~
    int this.numOfClients = numOfClients;
    int this.teamName = teamName;
    int this.guiededTableNum = null;
    this.serverCall();
~~~
2. this.serverCall()
~~~
    // 손님은 서버를 호출하여 좌석을 안내받습니다.
    int this.guiededTableNum = Server.findFreeSeat(this);
    Timer.schedule(orderTask,Math.floor(Math.random()*10000)+3000);   
~~~
3. this.callServerToOrder()
~~~
    String this.selectedMenu = this.selectMenu();
    Server.takeOrder(this.selectedMenu , this.guiededTableNum);
~~~

4. this.getChicken(TaskNode)
~~~
    Timer.schedule(eatTask,Math.floor(Math.random()*30000)+60000);
    eatTask(){
        Counter.getPaid(TaskNode,this.numOfClient);
    }
~~~
### (4) Server

1. this.findFreeSeat(Client targetClient)
~~~
    constructor(){
    int this.lastGuiededSeat = 0;
    }
    
    Client [][] seatState = Seat.getSeatState();
    int fullSeatCounter = 0;
    
    while(true){
        this.lastGuiededSeat = (++this.lastGuiededSeat % seats.getTableCount());
        int row = (this.lastGuiededSeat / 4);
        int col = (this.lastGuiededSeat % 4)
        
        if(seatState[row][col] == null){
            seatState[row][col] = targetClient;
            return lastGuiededSeat;
        }
        fullSeatCounter++;
        if(fullSeatCounter == seats.getTableCount()+1){
            System.out.println("죄송합니다! "+teamName+"님 빈 좌석이 없습니다.");
            break;
        }
    }
    
    // 실제 Position은 (lastGuiededSeat / 4) 의 몫과 나머지
~~~

2. this.takeOrder(String chickenName , int tableNum)
~~~
    TaskNode = Queue.getLast();
    int issuedOrderNum = TaskNode.orderNum + 1;
    Kitchen.orderPush(chickenName , tableNum , issuedOrderNum);
~~~
3. this.startServing(TaskNode)
~~~
    Client [][] seatState = Seat.getSeatState();
    int row = (TaskNode.tableNum / 4);
    int col = (TaskNode.tableNum % 4);
   seatState[row][col].getChicken(TaskNode);
~~~

### (5) Counter 
1.this.getPaid(TaskNode ,int numOfClients)
~~~
    int row = (TaskNode.tableNum / 4);
    int col = (TaskNode.tableNum % 4);
    seatState[row][col] = null;
    
    this.writeLog(TaskNode , numOfClients);
~~~
2. this.writeLog(TaskNode , int numOfClients)
~~~
    // DB.connection()...
    // Insert Some Data...
~~~
