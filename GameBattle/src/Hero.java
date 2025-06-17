public class Hero extends Character {
    public Hero(String name, int maxHP) {
        super(name, maxHP);
    }

    public void chooseAction(Character enemy, java.util.Scanner scanner) {
        System.out.println("\nХод героя: " + name);
        while (true) {
            System.out.println("1 — Атака\n2 — Лечение\n3 — Пропуск хода");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    attack(enemy);
                    return;
                case "2":
                    heal();
                    return;
                case "3":
                    skip(enemy);
                    return;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }
}
