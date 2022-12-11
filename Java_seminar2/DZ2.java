import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DZ2{
    private static Logger LOGGER = Logger.getLogger(DZ2.class.getName());
    private static Handler fh;

    public static void main(String[] args) throws IOException {
        fh = new FileHandler("C:\\Users\\Пользователь\\Desktop\\javadz02\\log.txt");
        LOGGER.addHandler(fh);
        writer();
    }

    /**
     * @return
     */
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
