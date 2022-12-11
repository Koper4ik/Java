import java.util.*;

public class DZ1_calc {
    public static void main(String[] args) {
        Stack<Double> primer = new Stack<Double>();
        Scanner input = new Scanner(System.in, "cp866");
        System.out.println("Введите первое число: ");
        double num1 = input.nextDouble();
        primer.push(num1);
        double res;
        while (true) {
            System.out.println("Введите действие:\n" +
            "отмена - для отмены последней операции\n" +
            "выход - для выхода из программы");
            String oper = input.next();
            if (oper.equals("отмена")) {
                primer.pop();
                num1 = primer.peek();
                System.out.printf("Результат предыдущей операции: %f\n", primer.peek());
            } else if (oper.equals("выход")) {
                input.close();
                System.exit(1);
            } else {
                System.out.println("Введите второе число: ");
                double num2 = input.nextDouble();
                switch (oper){
                    case "+":
                        res = num1 + num2;
                        System.out.printf("%f %s %f = %f\n", num1, oper, num2, res);
                        primer.push(res); num1 = res;
                        break;
                    case "-":
                        res = num1 - num2;
                        System.out.printf("%f %s %f = %f\n", num1, oper, num2, res);
                        primer.push(res); num1 = res;
                        break;
                    case "*":
                        res = num1 * num2;
                        System.out.printf("%f %s %f = %f\n", num1, oper, num2, res);
                        primer.push(res); num1 = res;
                        break;
                    case "/":
                        res = num1 / num2;
                        System.out.printf("%f %s %f = %f\n", num1, oper, num2, res);
                        primer.push(res); num1 = res;
                        break;
                    default:
                        System.out.println("Неверно введены данные");
                        break;
                }
            }
        }
    }
}
