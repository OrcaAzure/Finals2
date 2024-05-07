import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyProgramUtility {
    private List<Citizen> citizens;

    public MyProgramUtility() {
        citizens = new ArrayList<>();
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void loadDataFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Citizen citizen = new Citizen(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
                        data[5], Integer.parseInt(data[6]), data[7]);
                citizens.add(citizen);
            }
        }
    }

    public Map<Integer, Integer> getCitizensPerDistrict() {
        Map<Integer, Integer> citizensPerDistrict = new HashMap<>();
        for (Citizen citizen : citizens) {
            int districtNumber = citizen.getDistrictNumber();
            citizensPerDistrict.put(districtNumber, citizensPerDistrict.getOrDefault(districtNumber, 0) + 1);
        }
        return citizensPerDistrict;
    }
}
