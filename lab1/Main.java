import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // lab1, var 2
        // Ввести n строк с консоли. Упорядочить и вывести строки 
        // в порядке возрастания их длин, 
        // а также (второй приоритет) значений этих их длин.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Переходим на следующую строку после чтения числа

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        // Сортировка строк по длине и значениям длины
        Arrays.sort(strings, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        // Вывод отсортированных строк
        System.out.println("Строки, отсортированные по длине и значениям длины:");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}