import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RomanConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите римское число: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Результат конвертации: " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int prev = 0;
        int next;

        for (int i = 0; i < s.length(); i++) {
            next = map.get(s.charAt(i));
            result = (next > prev) ? (result + next - 2 * prev) : (result + next);
            prev = next;
        }
        return result;
    }
}

   