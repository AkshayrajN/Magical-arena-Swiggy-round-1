
 class Player {
    private int health;
    private int attack;
    private int strength;

    // Constructor
    public Player(int health, int attack, int strength) {
        this.health = health;
        this.attack = attack;
        this.strength = strength;
    }

    // Getters
    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getStrength() {
        return strength;
    }

    // Setters
    public void setHealth(int health) {
        this.health = health;
    }

    // Method to display player details for verification
    public void displayDetails() {
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Strength: " + strength);
    }
}

public class Main {
    // Create a new player with health, attack, and strength
    public static void main(String []args) {
        Player player1 = new Player(75, 30, 50);
        player1.displayDetails();
    }
}
