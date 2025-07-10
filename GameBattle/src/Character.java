public abstract class Character {

    protected String name;
    protected int hp;
    protected int maxHP;
    protected int attackPower;
    protected int heal;

    public enum Action {
        ATTACK,
        HEAL,
        SKIP

    }

    public abstract Action chooseAction(Character enemy, java.util.Scanner scanner);

    public void takeAction(Action action, Character enemy) {
        switch (action) {
            case ATTACK -> attack(enemy);
            case HEAL -> heal();
            case SKIP -> skip(enemy);
        }
    }


    public String getName() {
        return name;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {

        this.hp = Math.min(hp, maxHP);
    }


    public int getMaxHP() {
        return maxHP;
    }


    public Character(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.attackPower = maxHP / 5;
        this.heal = Math.max(1, maxHP / 10);

    }

    public void attack(Character target) {
        target.setHp(target.getHp() - attackPower);
        System.out.println(this.name + " атакует " + target.getName() + " и наносит ему " + attackPower + " ед. урона. ");
        System.out.println("У " + target.getName() + " осталось " + target.getHp() + "/" + target.getMaxHP() + " ед. здоровья.");

    }

    public void heal() {
        if (heal <= 0) {
            heal = 1;
        }
        this.setHp(this.hp + heal);
        System.out.println(this.name + " лечит себя на " + heal + " ед." + " и его здоровье = " + this.hp + "/" + this.maxHP + " ед.здоровья");

    }

    public void skip(Character target) {
        System.out.println(name + " передает ход " + target.getName());
    }

    public boolean isAlive() {
        return hp > 0;
    }

}

