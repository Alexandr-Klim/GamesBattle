public class Monster extends Character {
    public Monster(String name, int maxHP) {
        super(name, maxHP);
    }


    public Action chooseAction(Character enemy, java.util.Scanner scanner) {
        double roll = Math.random();
        double rollAttack = 0.6;
        double rollHeal = 0.85;

        if (roll < rollAttack) {
            return Action.ATTACK;
        } else if (roll < rollHeal) {
            return Action.HEAL;
        } else {
            return Action.SKIP;
        }
    }

    public void takeAction(Action action, Character enemy) {
        super.takeAction(action, enemy);
    }
}
