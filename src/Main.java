import java.util.Scanner;

public class Main{
    private static void print(String str) {
        System.out.println(str);
    }

    public static void main(String args[]){
        Client_controller client_controller = new Client_controller();
        int input_integer;
        String input_String;
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        print("If you mark how many people there are zero, the program will end.");
        while(true) {
            print("Enter How many people, teamName, client");
            System.out.print("How many? : ");
            input_integer = sc1.nextInt();
            System.out.print("TeamName? : ");
            input_String = sc2.nextLine();

            client_controller.EnterClient(input_integer, input_String);
            if (input_integer == 0) {break;}
        }
        print("program end;");
    }
}