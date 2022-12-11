import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_dz1 {
    private static Logger LOGGER = Logger.getLogger(java_dz1.class.getName());
    private static Handler fh;

    public static void main(String[] args) throws IOException {
        fh = new FileHandler("C:\\Users\\Пользователь\\Desktop\\javadz02\\log.txt");
        LOGGER.addHandler(fh);
        writer();
    }

    public static ArrayList<String> getFiles() {
        File file = new File("C:\\Users\\Пользователь\\Desktop\\java_dz1");
        ArrayList<String> names;
        try {
            names = new ArrayList<String>(Arrays.asList(file.list()));
            return names;
        } catch (NullPointerException nullPointerException) {
            LOGGER.log(Level.WARNING, "Путь к файлу не найден");
        }
        return null;
    }

    public static void writer() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Task.txt")) {
            try {
                ArrayList<String> files = getFiles();

                for (String file : files) {
                    file += "\n";
                    fileOutputStream.write(file.getBytes());
                }
            } catch (NullPointerException nullPointerException) {
                LOGGER.log(Level.WARNING, "Предидущий метод вернуд NULL");
            }
        }
    }
}
