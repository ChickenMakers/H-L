import java.util.Timer;
import java.util.TimerTask;

public class Clients {

    public int numOfClients;
    public String teamName;
    public int guiededTableNum = -1;
    private Server server = null;
    public String selectedMenu = null;

    void  Clients(int numOfClients, String teamName, Server server) {
        this.numOfClients = numOfClients;
        this.teamName = teamName;
        this.server = server;
        this.serverCall();
    }

    public void serverCall() {
        int delay = 0;
        this.guiededTableNum = this.server.findFreeSeat(this);
        if (this.guiededTableNum == -1) {
            return;
        }
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                this.callServerToOrder();
            }
        };
        delay = (int)(Math.floor(Math.random()*10000)+3000);
        timer.schedule(task, delay);
    }

    public void callServerToOrder() {
        this.selectedMenu  = this.selectMenu();
        Server.takeOrder(this.selectedMenu, this.guiededTableNum);
    }

    private String selectMenu() {
        return "hi";
    }

    public void getChicken(TaskNode) {
        int delay;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                counter.getpaid(TaskNode, this.numOfClients);
            }
        };
        delay = (int)(Math.floor(Math.random()*30000)+60000);
        timer.schedule(task, delay);
    }
}

