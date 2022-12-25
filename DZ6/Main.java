import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Map<Integer, LinkedHashMap<String, String>> database = new HashMap<Integer, LinkedHashMap<String, String>>();
        Integer id = 1;
        Notebooks notebook1 = new Notebooks("HP 250 G8", 15.6, "TN", 3.1, "Intel Core i3 1115250",
        256, "SSD", 8, "DDR4", 1, "Intel UHD Graphics", "темно-серебристый", 49890);
        Notebooks notebook2 = new Notebooks("HP 255 G8", 15.6, "TN", 2.6, "AMD Ryzen 5 3500U",
        256, "SSD", 8, "DDR4", 1, "AMD Radeon", "серебристый", 49890);
        Notebooks notebook3 = new Notebooks("MSI Modern 14 C12M-240XRU", 14.0, "TN", 1.3, " Intel Core i5 1235U",
        512, "SSD", 8, "DDR4", 2, "Intel Iris Xe graphics", "темно-серебристый", 49890);
        Notebooks notebook4 = new Notebooks("HP 240 G8", 14.0, "TN", 1.2, "Intel Core i3 1005G1",
        256, "SSD", 8, "DDR4", 1, "Intel UHD Graphics", "черный", 46780);
        Notebooks notebook5 = new Notebooks("Lenovo V15 G3 IAP", 15.6, "IPS", 1.2, "Intel Core i3 1215U",
        256, "SSD", 4, "DDR4", 1, "Intel UHD Graphics", "черный", 43890);
        Notebooks notebook6 = new Notebooks("ASUS Vivobook Pro 15 OLED K3500PC-L1315", 15.6, "IPS", 3.1, "Intel Core i5 11300H",
        512, "SSD", 16, "DDR4", 4, "NVIDIA GeForce RTX 3050", "синий", 99890);
        Notebooks.addNotebookInDataBase(database, notebook1, id);
        id++;
        Notebooks.addNotebookInDataBase(database, notebook2, id);
        id++;
        Notebooks.addNotebookInDataBase(database, notebook3, id);
        id++;
        Notebooks.addNotebookInDataBase(database, notebook4, id);
        id++;
        Notebooks.addNotebookInDataBase(database, notebook5, id);
        id++;
        Notebooks.addNotebookInDataBase(database, notebook6, id);
        System.out.println(database);
        System.out.println();

        searchNb(database);
    }

    public static void searchNb (Map spisok) {
        Double findDiag = 0.0;
        Double findProcGz = 0.0;
        Integer findHard = 0;
        Integer findOzu = 0;
        String findColor = "none";
        Integer findPrice = 0;
        Map searchCriterii = new HashMap<>();
        searchCriterii.put("diagonal", findDiag);
        searchCriterii.put("processorGigaGz", findProcGz);
        searchCriterii.put("capacityHardDrive", findHard);
        searchCriterii.put("capacityRam", findOzu);
        searchCriterii.put("color", findColor);
        searchCriterii.put("price", findPrice);
        Map searchCriteriiZero = new HashMap<>();
        searchCriteriiZero.putAll(searchCriterii);

        Scanner input = new Scanner(System.in, "cp866");

        while (true) {
            System.out.print("Критерии поиска: ");
            System.out.println(searchCriterii);
            System.out.println("Веберите критерий для поиска:\n" +
            "1 - диагональ (минимальное значение)\n" +
            "2 - частота процессора (минимальное значение)\n" +
            "3 - объем жесткого диска (минимальное значение)\n" +
            "4 - ОЗУ (минимальное значение)\n" +
            "5 - цвет\n" +
            "6 - цена (минимальное значение)\n" +
            "result - вывести список согласно фильтра\n" +
            "clear - сбросить фильтр\n" +
            "close - для выхода из поиска");
            String comand = input.next();
            switch (comand) {
                case "close":
                    input.close();
                    System.exit(1);
                case "1":
                    System.out.println("Введите диагональ");
                    findDiag = input.nextDouble();
                    searchCriterii.put("diagonal", findDiag);
                    break;
                case "2":
                    System.out.println("Введите частоту процессора");
                    findProcGz = input.nextDouble();
                    searchCriterii.put("processorGigaGz", findProcGz);
                    break;
                case "3":
                    System.out.println("Введите объем жесткого диска");
                    findHard = input.nextInt();
                    searchCriterii.put("capacityHardDrive", findHard);
                    break;
                case "4":
                    System.out.println("Введите объем ОЗУ");
                    findOzu = input.nextInt();
                    searchCriterii.put("capacityRam", findOzu);
                    break;
                case "5":
                    System.out.println("Введите цвет");
                    findColor = input.next();
                    searchCriterii.put("color", findColor);
                    break;
                case "6":
                    System.out.println("Введите цвет");
                    findPrice = input.nextInt();
                    searchCriterii.put("price", findPrice);
                    break;
                case "result":
                    boolean flag = false;
                    for (int index = 1; index <= spisok.size(); index++) {
                        if (Double.parseDouble(((String) ((Map)spisok.get(index)).get("diagonal")).replace(",",".")) >= findDiag || findDiag == 0.0)  {
                            if (Double.parseDouble(((String) ((Map)spisok.get(index)).get("processorGigaGz")).replace(",",".")) >= findProcGz || findProcGz == 0.0) {
                                if (Integer.parseInt(((String) ((Map)spisok.get(index)).get("capacityHardDrive"))) >= findHard || findHard == 0) {
                                    if (Integer.parseInt(((String) ((Map)spisok.get(index)).get("capacityRam"))) >= findOzu || findOzu == 0) {
                                        if ((((Map)spisok.get(index)).get("color").equals(findColor)) || findColor == "none") {
                                            if (Integer.parseInt(((String) ((Map)spisok.get(index)).get("price"))) >= findOzu || findOzu == 0) {
                                                System.out.println(spisok.get(index));
                                                flag = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!flag) {
                        System.out.println("Нет ноутбуков удовлетворяющих критериям");
                    }
                    break;
                case "clear": 
                    searchCriterii.putAll(searchCriteriiZero);
                    break;
                default:
                    System.out.println("Неверно введены данные");
                    break;
            }        
        }
    }
}