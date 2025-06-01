import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);

    static class Character {

        private String name;
        private int hp;
        private int maxHP;
        private int attackPower;
        private int heal;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {

            this.hp = Math.min(hp, maxHP);
        }

        public int getAttackPower() {
            return attackPower;
        }

        public void setAttackPower(int attackPower) {
            this.attackPower = attackPower;
        }

        public int getMaxHP() {
            return maxHP;
        }

        public void setMaxHP(int maxHP) {
            this.maxHP = maxHP;
        }

        public int getHeal() {

            return heal;
        }

        public void setHeal(int heal) {
            this.heal = heal;
        }

        public Character(String name, int maxHP, int hp) {
            setName(name);
            setMaxHP(maxHP);
            setHp(hp);
        }

        public void attack(Character target) {
            attackPower = this.maxHP / 5;
            target.setHp(target.hp - attackPower);
            System.out.println(this.name + " атакует " + target.name + " и наносит ему " + attackPower + " ед. урона. ");
            System.out.println("У " + target.name + " осталось " + target.getHp() + "/" + target.maxHP + " ед. здоровья.");

        }

        public void heal() {
            heal = this.maxHP / 10;
            if (heal <= 0) {
                heal = 1;
            }
            this.setHp(this.hp + heal);
            System.out.println(this.name + " лечит себя на " + heal + " ед." + " и его здоровье = " + this.hp + "/" + this.maxHP + " ед.здоровья");

        }

        public void skip(Character target) {
            System.out.println(this.name + " передает ход " + target.name);
        }

    }

    public static void main(String[] args) {

//       System.out.print("Сколько персонажей будет сражаться? ");
//        int count = Integer.parseInt(scanner.nextLine());

        int count = 2;
        Character[] characters = new Character[count];
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                System.out.print("Ввод данных для вашего героя: ");
            } else {
                System.out.println("\nВвод данных для монстра" + (i + 1));
            }

            System.out.print("Введите имя: ");
            String name = scanner.nextLine();

            int maxHP;
            while (true) {
                System.out.print("Введите параметры максимального здоровья: ");
                String input = scanner.nextLine();
                if (input.matches("\\d+")) {
                    maxHP = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Ошибка: введите число.");
                }
            }
            int hp;
            while (true) {
                System.out.print("Введите параметры текущего здоровья: ");
                String input = scanner.nextLine();
                if (input.matches("\\d+")) {
                    hp = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Ошибка: введите число.");
                }
            }

            characters[i] = new Character(name, maxHP, hp);

        }
        Character hero = characters[0];
        Character monster = characters[1];

        System.out.println("\n" + hero.name + " начинает свой путь сражений");
        System.out.println(hero.name + " сразу же рвется в бой. Его  противник:  " + monster.name);

        System.out.println("Битва началась");
        boolean fight = true;

        while (fight) {
            System.out.println("Ход героя: " + hero.name);
            System.out.println(hero.name + " каковы ваши действия? \n 1 - Атака \n 2 - Лечение \n 3 - Пропуск хода ");

            String input = scanner.next();

            switch (input) {
                case "1" -> {
                    hero.attack(monster);
                    if (monster.hp <= 0) {
                        System.out.println(hero.name + " победил персонажа " + monster.name + ". Здоровье героя " + hero.hp + "/" + hero.maxHP + " ед." );
                        fight = false;
                    }
                }
                case "2" -> hero.heal();
                case "3" -> hero.skip(monster);
            }

            System.out.println("\nХод монстра: " + monster.name);
            if (Math.random() < 0.6) {
                monster.attack(hero);
                if (hero.hp <= 0) {
                    System.out.println(monster.name + " победил персонажа " + hero.name + ". Здоровье монстра " + monster.hp + "/" + monster.maxHP + " ед.");
                    break;
                }
            } else if (Math.random() >= 0.6 || Math.random() <= 0.85) {
                monster.heal();
            } else
                monster.skip(hero);
        }


        System.out.println("Игра завершена");


    }

}




