import java.util.LinkedList;
import java.util.TimerTask;
import java.util.Timer;

public class Kitchen {
    OrderQueue OQ = new OrderQueue();
    private boolean isCooking = false;
    private Server server = null;

    Kitchen(Server server) {
        this.server = server;
    }
    public void orderPush(String chickName, int tableNum, int orderNum) {
        int cooktime = this.getCookingTime(chickName);
        TaskNode push_node = new TaskNode(chickName, cooktime, tableNum, orderNum);
        OQ.push(push_node);
        if (! this.isCooking)  //this.isCooking == false
        {
            this.startCooking();
        }
    }

    private void startCooking() {
        this.isCooking = true;
        TaskNode pop_node = OQ.pop();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                this.endCooking(pop_node);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, pop_node.cookingTime);
    }

    private void endCooking(TaskNode node) {
        this.server.startServing(node);

        if (!OQ.isEmpty()) // Queue.isEmpty() == false
        {
            this.startCooking();
        }
        else {
            this.isCooking = false;
        }
    }
    private int getCookingTime(String ChickName) {
        int cookTime;
        Menus menus = new Menus();
        cookTime = menus.getCookingTimeMap().get(chickName);
        return cookTime;
    }
}

public class OrderQueue {
    private LinkedList<TaskNode> linkedList = new LinkedList<>();
    public void push(TaskNode node) {
        linkedList.addLast(TaskNode node);
    }

    public TaskNode pop() {
        return linkedList.pop();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public TaskNode getLast() {
        return linkedList.getLast();
    }

    public TaskNode getFirst() {
        return linkedList.getFirst();
    }

//    push, pop, isEmpty, getLast, getFirst
}