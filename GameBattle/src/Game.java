import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите имя героя: ");
        String heroName = scanner.nextLine();
        System.out.print("Введите количество максимального здоровья героя: ");
        int heroMaxHp = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите имя монстра: ");
        String monsterName = scanner.nextLine();
        System.out.print("Введите количество максимального здоровья героя: ");
        int monsterMaxHp = Integer.parseInt(scanner.nextLine());

        Hero hero = new Hero(heroName, heroMaxHp);
        Monster monster = new Monster(monsterName, monsterMaxHp);

        System.out.println("\nБитва начинается! " + hero.getName() + " против " + monster.getName());

        while (hero.isAlive() && monster.isAlive()) {
            hero.chooseAction(monster, scanner);
            if (!monster.isAlive()) break;

            monster.takeAction(hero);
        }

        if (hero.isAlive()) {
            System.out.println("\n " + hero.getName() + " победил!");
        } else {
            System.out.println("\n " + monster.getName() + " уничтожил героя!");
        }

        scanner.close();
        System.out.println("Игра завершена.");

    }
}
