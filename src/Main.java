import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();

        // Разбиваем число на цифры и заносим их в стек
        while (number > 0)
        {
            int n = number % 10; // Получаем последнюю цифру числа
            stack.push(n); // Добавляем цифру в стек
            number /= 10; // Удаляем последнюю цифру числа
        }
        int revers = 0;
        int multiplier = 1;

        // Извлекаем цифры из стека и формируем обратное число
        while (!stack.isEmpty()) {
            int digit = stack.pop(); // Извлекаем первую цифру из стека
            revers += digit * multiplier;
            multiplier *= 10; // Увеличиваем множитель для разрядов
        }// прикол в том, что занося число в стек,
        // мы на 1 позицию стека заносим последнюю цифру
        // и на след. предпоследнюю итд
        // тем самым занося число в стек мы уже формируем обратное ему

        System.out.println("Число с обратным порядком цифр: " + revers);
    }
}