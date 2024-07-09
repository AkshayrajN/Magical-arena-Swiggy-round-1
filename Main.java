
import java.util.Random;

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

        return Math.abs(random.nextInt()%7);
    }

    private void fight(player player1,player player2){
//        int count=20;
        while(player1.getHealth()>0 && player2.getHealth()>0 ){
            player attacker=selectAttacker();
            player defender=selectDefender();
            int attackerDice=getDiceValue();
            int defenderDice=getDiceValue();
            int attackDamage= attackerDice*attacker.getAttack();
            int defendingStrength=defenderDice*defender.getStrength();
            int totalDamage=Math.abs(attackDamage-defendingStrength);
            int currentHealth=defender.getHealth();
            int updateHealth=currentHealth-totalDamage;

            if(updateHealth<0) defender.setHealth(0);
            else defender.setHealth(updateHealth);

            System.out.printf("Player 1: dice %d, damage %d ,health%d%n", attackerDice, attackDamage,this.player1.getHealth());
            System.out.printf("Player 2: dice %d, defended %d, health %d%n", defenderDice, defendingStrength, currentHealth);
            System.out.printf("Total damage: %d%n", totalDamage);
            System.out.printf("Defender health after fight: %d%n", this.player2.getHealth());

        }

        if (this.player1.getHealth() > 0) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }


    }

    //setter
    void startFight(){
        fight(this.player1,this.player2);
    }


}

public class Main {
    // Create a new player with health, attack, and strength
    public static void main(String []args) {
        player player1 = new player(50, 6, 5);
        player player2= new player(100,5,10);
        player1.displayDetails();
        player2.displayDetails();
        arena field=new arena(player1,player2);
        field.startFight();




    }
}
