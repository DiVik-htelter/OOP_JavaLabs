import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main { // лаба 2, вар 13
// Создать запрос для вывода только правильно написанных выражений со скобками (количество открытых и закрытых скобок должно быть одинаково).
// – пример правильных выражений: (3 + 5) – 9 × 4.
// – пример неправильных выражений: ((3 + 5) – 9 × 4. 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражения (для завершения введите 'exit'): ");
        List<String> s = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit"))
                break;
            s.add(input);
        }
        System.out.println("Правильно написанные выражения со скобками:");
        for (String i : s)
        {
            List<String> exp = f(i);
            for (String j : exp)
                System.out.println(j);

        }
    }

    public static List<String> f(String s) {
        List<String> correctS = new ArrayList<>();
        int open = 0;
        int close = 0;
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(')
                open++;
             else if (ch == ')')
                close++; // подсчет скобок
            
            if (open == close) {
                // Найдено правильно написанное выражение
                correctS.add(s.substring(index, i + 1));
                index = i + 1;
            }
        }
        return correctS;
    }
}