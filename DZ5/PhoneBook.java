import java.util.*;

public class PhoneBook{
    public static void main(String[] args) {
        Map<String, StringBuilder> phoneBook = new HashMap<String, StringBuilder>();
        Scanner input = new Scanner(System.in, "cp866");
        while (true) {
            System.out.println("Введите команду:\n" +
            "add - ввести контакт\n" +
            "find - найти контакт\n" +
            "close - для выхода");
            String comand = new String();
            comand = input.next();
            switch (comand) {
                case "close":
                    input.close();
                    System.exit(1);
                case "add":
                    input.nextLine();
                    System.out.println("Введите имя и фамилию через пробел:");
                    String manName = input.nextLine();
                    System.out.println("Введите номер телефона:");
                    String tempPhNum = input.next();
                    StringBuilder phoneNumber = new StringBuilder();
                    phoneNumber.append(tempPhNum);

                    if (phoneBook.containsKey(manName)) {
                        StringBuilder temp = new StringBuilder();                
                        temp = phoneBook.get(manName);
                        temp.append(" " + phoneNumber);
                        phoneBook.put(manName, temp);
                    } else phoneBook.put(manName, phoneNumber);

                    break;

                case "find":
                    input.nextLine();
                    System.out.println("Введите имя и фамилию через пробел:");
                    String findCon = input.nextLine();

                    if (phoneBook.containsKey(findCon)) {
                        System.out.println(phoneBook.get(findCon));
                    } else System.out.println("Контакт не найден");

                    break;

                default:
                    System.out.println("НЕ верный ввод!");
                    break;
            }
            System.out.println(phoneBook);
        }
    }
}