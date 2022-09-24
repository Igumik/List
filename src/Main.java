import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] operations = {"добавить", "показать", "удалить", "найти"};
        System.out.println("Операции: ");
        for (int i = 0; i < operations.length; i++) {
            System.out.println((i + 1) + ". " + operations[i]);
        }
        List<String> basket = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("Выберите операцию:");
            String input = scanner.nextLine();
            if ("1".equals(input)) {
                System.out.println("Какую покупку хотите добавить?");
                input = scanner.nextLine();
                basket.add(input);
                System.out.println("Итого в списке покупок: " + basket.size());
            } else if ("2".equals(input)) {
                System.out.println("Список покупок:");
                for (int i = 0; i < basket.size(); i++) {
                    System.out.println((i + 1) + ". " + basket.get(i));
                }
            } else if ("3".equals(input)) {
                try {
                    System.out.println("Список покупок:");
                    for (int i = 0; i < basket.size(); i++) {
                        System.out.println((i + 1) + ". " + basket.get(i));
                    }
                    System.out.println("Какую покупку хотите удалить? Введите номер или название");
                    input = scanner.nextLine();
                    int product = Integer.parseInt(input) - 1;
                    System.out.println("Покупка " + basket.get(product) + " удалена, список покупок:");
                    basket.remove(product);
                } catch (NumberFormatException e) {
                    System.out.println("Покупка " + input + " удалена, список покупок:");
                    basket.remove(input);
                }
                for (int i = 0; i < basket.size(); i++) {
                    System.out.println((i + 1) + ". " + basket.get(i));
                }
            } else if ("4".equals(input)) {
                System.out.println("Введите текст для поиска:");
                input = scanner.nextLine();
                System.out.println("Найдено:");
                for (int i = 0; i < basket.size(); i++) {
                    String itemLower = basket.get(i).toLowerCase();
                    String queryLower = input.toLowerCase();
                    if (itemLower.contains(queryLower)) {
                        System.out.println((i + 1) + ". " + basket.get(i));
                    }
                }
            }
        }
    }
}
