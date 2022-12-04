import java.util.Scanner;

public class Calc {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int a = getNumber();
        char operator = getOperator();
        int b = getNumber();
        int result = calculator(a, b, operator);
        System.out.print("Результат: " + result);

    }

    public static int getNumber() {
        System.out.print("Введите число: ");
        int num;
        if (input.hasNextInt()) {
            num = input.nextInt();
        } else {
            System.out.println("Ошибка ввода! Введите число!");
            input.next();
            num = getNumber();
        }
        return num;
    }

    public static char getOperator() {
        System.out.print("Введите действие:");
        char operator;
        if (input.hasNext()) {
            operator = input.next().charAt(0);
        } else {
            System.out.println("Вы совершили ошибку при вводе действия. Попробуйте снова");
            input.next();
            operator = getOperator();
        }
        return operator;
    }

    public static int calculator(int a, int b, char operator) {
        int result;
        if (operator == '+') {
            result = a + b;
        } else if (operator == '-') {
            result = a - b;
        } else if (operator == '*') {
            result = a * b;
        } else if (operator == '/') {
            result = a / b;
        } else {
            System.out.print("Не удалось определить действие. Попробуйте снова! +, - , *, /");
            result = calculator(a, b, operator);
        }

        return result;
    }
}