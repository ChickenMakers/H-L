public class TaskNode {

    public String chickenName;
    public int cookingTime;
    public int tableNum;
    public int orderNum;

    TaskNode() {
        this.chickenName = null;
        this.cookingTime = 0;
        this.tableNum = 0;
        this.orderNum = 0;
    }

    TaskNode(String chickenName , int cookingTime , int tableNum , int orderNum){
        this.chickenName = chickenName;
        this.cookingTime = cookingTime;
        this.tableNum = tableNum;
        this.orderNum = orderNum;
    }

}
