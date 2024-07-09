
import java.util.Random;
import java.util.Scanner;
class arena {
    private player player1;
    private player player2;
    Random random= new Random();
    //constructor
    arena(player player1,player player2){
        this.player1=player1;
        this.player2=player2;
    }
    private player selectDefender(){
        if(this.player1.getHealth()>this.player2.getHealth()){
            return this.player1;
        }
        return this.player2;
    }
    private player selectAttacker(){
        if(this.player1.getHealth()<this.player2.getHealth()){
            return this.player1;
        }
        return this.player2;
    }
    private int getDiceValue(){

        return Math.abs(random.nextInt()%6)+1;
    }
    private void displayStats(player attacker,player defender,int round,int attackValue,int defendingStrength){

        System.out.printf("%n+-------------------Round %d---------------------- %n",round);
        System.out.println("Stats:");
        System.out.printf("\t Attacker: damage %d ,health %d %n", attackValue,attacker.getHealth());
        System.out.printf("\t Defender: defence %d, health %d%n", defendingStrength, defender.getHealth());
        if(attackValue<defendingStrength){
            System.out.printf("No Damage! Defence is greater than attack %n");
        }
        if(attackValue==defendingStrength){
            System.out.printf("No Damage! Defence is equal attack %n");
        }
    }

    private void fight(player player1,player player2){
//        int count=20;
        int round=0;
        while(player1.getHealth()>0 && player2.getHealth()>0 ){
            round++;
            player attacker=selectAttacker();
            player defender=selectDefender();
            int attackerDice=getDiceValue();
            int defenderDice=getDiceValue();
            int attackValue= attackerDice*attacker.getAttack();
            int defendingStrength=defenderDice*defender.getStrength();
            displayStats(attacker,defender,round,attackValue,defendingStrength);
            if(attackValue<defendingStrength){
                continue;
            }
            int totalDamage=attackValue-defendingStrength;
            int currentHealth=defender.getHealth();
            int updateHealth=currentHealth-totalDamage;

            if(updateHealth<0) {
                defender.setHealth(0);
            }
            else {
                defender.setHealth(updateHealth);
            }

            System.out.printf("\tTotal damage: %d%n", totalDamage);
            System.out.printf("\tDefender health after fight: %d%n", defender.getHealth());
//            System.out.println("+------------------------------------------------");

        }
        System.out.println("====================");
        System.out.println("|                  |");
        if (this.player1.getHealth() > 0) {

            System.out.println("|\tPlayer 1 wins! |");
        } else {
            System.out.println("|\tPlayer 2 wins! |");
        }
        System.out.println("|                  |");
        System.out.println("====================");

    }

    //setter
    void startFight(){
        fight(this.player1,this.player2);
    }


}

public class Main {
    // Create a new player with health, attack, and strength
    public static void main(String []args) {
        Scanner sc= new Scanner(System.in);
        int health,attack,strength;
        player player1;
        player player2;

        System.out.println("Enter the Details of Player:1");
        System.out.println("Enter health: ");
        health=sc.nextInt();
        System.out.println("Enter attack: ");
        attack=sc.nextInt();
        System.out.println("Enter strength: ");
        strength=sc.nextInt();
        player1=new player(health,attack,strength);
        player1.displayDetails();

        System.out.println("Enter the Details of Player:2");
        System.out.println("Enter health: ");
        health=sc.nextInt();
        System.out.println("Enter attack: ");
        attack=sc.nextInt();
        System.out.println("Enter strength: ");
        strength=sc.nextInt();
        player2= new player(100,5,20);
        player2.displayDetails();
        arena field=new arena(player1,player2);
        field.startFight();




    }
}
