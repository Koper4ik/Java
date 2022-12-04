import java.util.stream.IntStream;

/* Вывести все простые числа от 1 до 1000*/

public class Task02 {
    public static void main(String[] args) {
        int[] array = IntStream.rangeClosed(1, 1000).toArray();
        for (int i = 2; i < array.length; i++) {
            Boolean numberPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    numberPrime = false;
                }
            }
            if (numberPrime) {
                System.out.printf("%d,", i);
            }
        }
    }
}