import java.util.Scanner;

/*Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)*/
public class Task01 {
    public static void main(String[] args) {
        System.out.print("Вветите число: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += array[i];
        }
        System.out.print(t);
    }
}