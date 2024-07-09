import java.util.Scanner;

public class Main {
    // making the parameters as static variables for reusability
    static int health = 0;
    static int attack=0;
    static int strength=0;

    public static void main(String []args) {

        player player1;
        player player2;

        //Taking the user inputs for the players attributes
        System.out.println("Enter the Details of Player:1");
        takeInputs();
        player1=new player(health,attack,strength);
        player1.displayDetails();

        System.out.println("Enter the Details of Player:2");
        takeInputs();
        player2= new player(health,attack,strength);
        player2.displayDetails();

        //creating an arena object
        arena field=new arena(player1,player2);
        //Function call to start fight
        field.startFight();

    }

    private static void takeInputs() {
        //creating Scanner object for user inputs
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter health: ");
        health=sc.nextInt();
        System.out.println("Enter attack: ");
        attack=sc.nextInt();
        System.out.println("Enter strength: ");
        strength=sc.nextInt();
    }
}
