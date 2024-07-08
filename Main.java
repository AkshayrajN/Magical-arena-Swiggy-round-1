
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
    private player selectDefender(player player1,player player2){
        if(player1.getHealth()>player2.getHealth()){
            return player1;
        }
        return player2;
    }
    private player selectAttacker(player player1,player player2){
        if(player1.getHealth()<player2.getHealth()){
            return player1;
        }
        return player2;
    }
    private int getDiceValue(){
        int r= (int)random.nextInt()%7;
        return r;
    }




}

public class Main {
    // Create a new player with health, attack, and strength
    public static void main(String []args) {
//        player player1 = new player(75, 30, 50);
//        player1.displayDetails();



    }
}
