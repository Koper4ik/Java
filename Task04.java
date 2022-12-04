import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите первое число с неизвестной цифрой, обозначьте ее знаком вопроса: ");
        String num1 = input.next();
        String[] number1 = num1.split("");
        System.out.println("Введите второе число с неизвестной цифрой, обозначьте ее знаком вопроса: ");
        String num2 = input.next();
        String[] number2 = num2.split("");
        System.out.println("Введите результат: ");
        int res = input.nextInt();
        input.close();
        int temp1 = 2;
        int temp2 = 2;
        for (int k = 0; k < number1.length; k++) {
            if (number1[k].equals("?")) temp1 = k;
        }
        for (int l = 0; l < number2.length; l++) {
            if (number2[l].equals("?")) temp2 = l;
        }
        boolean temp = false;
        for (int i = 0; i < 10; i++) {
            number1[temp1] = Integer.toString(i);
            String temp_number1 = String.join("", number1);
            for (int j = 0; j < 10; j++) {
                number2[temp2] = Integer.toString(j);
                String temp_number2 = String.join("", number2);
                int a = Integer.parseInt(temp_number1);
                int b = Integer.parseInt(temp_number2);
                if (a + b == res) {
                    temp = true;
                    System.out.printf("Решение %s + %s = %d это: %d + %d = %d", num1, num2, res, a, b, res);
                    // break;
                }
            }
            // if (temp == true) break;
        }
        if (temp == false) System.out.print("Решения нет");
    }
}