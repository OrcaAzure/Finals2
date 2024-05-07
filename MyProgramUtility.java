
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyProgramUtility {
    private List<Citizen> citizens;

    public MyProgramUtility() {
        citizens = new ArrayList<>();
    }

    public void loadDataFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Citizen citizen = new Citizen(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
                        data[5], Integer.parseInt(data[6]), data[7]);
                citizens.add(citizen);
            }
        }
    }
}