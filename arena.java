import java.util.Random;

public class arena {
    private player player1;
    private player player2;
    //creating a random object

    Random random=new Random();
    //constructor
    arena(player player1,player player2){
        this.player1=player1;
        this.player2=player2;
    }
    /*This function selects a player has to be a defender
      by choosing a player who has the highest health
    */
    private player selectDefender(){
        if(this.player1.getHealth()>this.player2.getHealth()){
            return this.player1;
        }
        return this.player2;
    }
    /*This function selects a player has to be a defender
   by choosing a player who has the lowest health
 */
    private player selectAttacker(){
        if(this.player1.getHealth()<this.player2.getHealth()){
            return this.player1;
        }
        return this.player2;
    }
    //Function to roll a dice
    private int getDiceValue(){

        return Math.abs(random.nextInt()%6)+1;
    }

    //Function to display the statistics of the attacker and defender before the attack
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
        int round=0;
        while(player1.getHealth()>0 && player2.getHealth()>0 ){
            round++;
            player attacker=selectAttacker();
            player defender=selectDefender();
            int attackerDice=getDiceValue();
            int defenderDice=getDiceValue();

            //calculating the attack from attacker
            int attackValue= attackerDice*attacker.getAttack();

            //calculating the defence from defender
            int defendingStrength=defenderDice*defender.getStrength();

            //Function call to display the statistics before the attack
            displayStats(attacker,defender,round,attackValue,defendingStrength);

            /*This condition is important because if the attack value is less than the defence value there will be
            no damage to defender if this is not implemented due to math error,health of the defender increases */
            if(attackValue<defendingStrength){
                continue;
            }
            //calculating the damage caused to defender
            int totalDamage=attackValue-defendingStrength;
            int currentHealth=defender.getHealth();
            int updateHealth=currentHealth-totalDamage;

            //if health goes below 0 game needs to be stopped
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
        System.out.println("==========================");
        System.out.println("|                        |");

        //Checking who has Won the game by checking the health of both players
        if (this.player1.getHealth() > 0) {

            System.out.println("|\tPlayer 1 wins!       |");
        } else {
            System.out.println("|\tPlayer 2 wins!       |");
        }
        System.out.println("|                        |");
        System.out.println("==========================");


    }

    //setter
    void startFight(){
        fight(this.player1,this.player2);
    }


}
