public class Hero extends Character {
    public Hero(String name, int maxHP) {
        super(name, maxHP);
    }


    public Action chooseAction(Character enemy, java.util.Scanner scanner) {
        System.out.println("\nХод героя: " + name);
        while (true) {
            System.out.println("1 — Атака\n2 — Лечение\n3 — Пропуск хода");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    return Action.ATTACK;
                case "2":
                    return Action.HEAL;
                case "3":
                    return Action.SKIP;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }

        }

    }

    public void takeAction(Action action, Character enemy) {
        super.takeAction(action, enemy);
    }
}
