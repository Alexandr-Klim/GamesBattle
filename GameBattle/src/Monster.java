public class Monster extends Character {
    public Monster(String name, int maxHP) {
        super(name, maxHP);
    }

    public void takeAction(Character enemy) {
        double roll = Math.random();

        if (roll < 0.6) {
            attack(enemy);
        } else if (roll < 0.85) {
            heal();
        } else {
            skip(enemy);
        }
    }
}
