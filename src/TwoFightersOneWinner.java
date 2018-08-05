public class TwoFightersOneWinner {


    public static void main(String... args) {

        System.out.println(Kata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));

    }


}

class Kata {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!
        String nextAttacker = firstAttacker;
        while (fighter1.health > 0 && fighter2.health > 0) {
            if(fighter1.name.equals(nextAttacker)) {
                fighter2.health = fighter2.health- fighter1.damagePerAttack;
            }else{
                fighter1.health = fighter1.health - fighter2.damagePerAttack;
            }
            nextAttacker = nextAttacker == fighter1.name ? fighter2.name : fighter1.name;
        }
        return fighter1.health > fighter2.health ?  fighter1.name : fighter2.name;
    }
}

class Fighter {
    public String name;
    public int health, damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
}