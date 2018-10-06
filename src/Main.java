import java.util.Timer;
import java.util.TimerTask;

public class Main{
    public static void main(String args[]){

        Timer myTimer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("나 실행됨 스케줄 중");
            }
        };
        System.out.print("타이머 실행 테스트 스케줄 전");

        myTimer.schedule(myTask,3000);
        // 안녕하세요 ^^ ㅎㅇㅎㅇ
        System.out.print("타이머 실행 테스트 스케줄 후");


    }
}