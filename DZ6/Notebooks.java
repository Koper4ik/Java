import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class  {
    String model;
    Double diagonal;
    String typeMatrix;
    Double processorGigaGz;
    String typeProcessor;
    Integer capacityHardDrive;
    String typeHardDrive;
    Integer capacityRam;
    String typeRam;
    Integer capacityVideoCard;
    String typeVideoCard;
    String color;
    Integer price;

    public Notebooks(String model, Double diagonal, String typeMatrix, Double processorGigaGz, String typeProcessor,
        Integer capacityHardDrive, String typeHardDrive, Integer capacityRam, String typeRam, Integer capacityVideoCard, String typeVideoCard, String color, Integer price) {
        this.model = model;
        this.diagonal = diagonal;
        this.typeMatrix = typeMatrix;
        this.processorGigaGz = processorGigaGz;
        this.typeProcessor = typeProcessor;
        this.capacityHardDrive = capacityHardDrive;
        this.typeHardDrive = typeHardDrive;
        this.capacityRam = capacityRam;
        this.typeRam = typeRam;
        this.capacityVideoCard = capacityVideoCard;
        this.typeVideoCard = typeVideoCard;
        this.color = color;
        this.price = price;
        }
    
        @Override
        public String toString() {
            return String.format("%s, %.1f, %s, %.1f, %s, %d, %s, %d, %s, %d, %s, %s, %d", model, diagonal, typeMatrix, processorGigaGz, typeProcessor,
            capacityHardDrive, typeHardDrive, capacityRam, typeRam, capacityVideoCard, typeVideoCard, color, price);
        }

        public static Map addNotebookInDataBase (Map spisok, Notebooks nb, Integer newId) {
            ArrayList<String> newNb = new ArrayList<String>(Arrays.asList(nb.toString().split(", ")));
            Map<String, String> info = new LinkedHashMap<String, String>();
            String[] infoName = {"model", "diagonal", "typeMatrix", "processorGigaGz", "typeProcessor", "capacityHardDrive", "typeHardDrive", "capacityRam", "typeRam", "capacityVideoCard",
                "typeVideoCard", "color", "price"};
            Integer i = 0;
            for (String str : newNb) {
                info.put(infoName[i], str);
                i++;
            }
            spisok.put(newId, info);
            return spisok;
        }
}