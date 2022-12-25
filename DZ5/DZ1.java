import java.util.*;


public class DZ1 {
    public static void main(String[] args) {
        List<String> spisok = List.of("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
            "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
            "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов");

        Map<String, Integer> spisokImen = new HashMap<String, Integer>(); 
        for (String strElem : spisok) { 
            String[] tempArr = strElem.split(" ");
            if (spisokImen.containsKey(tempArr[0])) {
                spisokImen.put(tempArr[0], spisokImen.get(tempArr[0]) + 1);
            } else {
                spisokImen.put(tempArr[0], 1);
            }
        }

        for (var item : spisokImen.entrySet()) { 
            System.out.printf("Имя: %s, встречается %d раз(а)\n", item.getKey(), item.getValue());
        }

        List<String> tempListName = new ArrayList<String>(); 
        int tempNumber = 1;
        while(tempNumber < spisok.size()) {
            for (Map.Entry<String, Integer> item : spisokImen.entrySet()) {
                if (item.getValue() == tempNumber) tempListName.add(0, item.getKey());
            }
            tempNumber++;
        }
        System.out.println("Отсортированный список имен по возрастанию количества букв: ");
        System.out.println(tempListName);
        
        System.out.println("Отсортированный список по убыванию популярности имен: ");
        for (String str : tempListName) { 
            for (String strElem : spisok) {
                String[] tempArr = strElem.split(" ");
                if (str.equals(tempArr[0])) System.out.println(strElem);
            }
        }
    }
}