import java.util.Timer;
import java.util.TimerTask;

public class Clients {

    public int numOfClients;
    public String teamName;
    public int guiededTableNum = -1;
    private Server server;
    public String selectedMenu = "";

    Clients(int numOfClients, String teamName, Server server) {
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
                callServerToOrder();
            }
        };
        delay = (int)(Math.floor(Math.random()*10000)+3000);
        timer.schedule(task, delay);
    }

    public void callServerToOrder() {
        this.selectedMenu  = this.selectMenu();
        server.takeOrder(this.selectedMenu, this.guiededTableNum);
    }

    private String selectMenu() {
        Menus menus = new Menus();
        int randomNum = (int)(Math.random()* menus.getCountOfMenu()) + 1;
        return menus.getMenuMap().get(randomNum);
    }

    public void getChicken(TaskNode taskInfo) {
        int delay;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                server.counter.getPaid(taskInfo,numOfClients);
            }
        };
        delay = (int)(Math.floor(Math.random()*1000)+1000);
        timer.schedule(task, delay);
    }
}

