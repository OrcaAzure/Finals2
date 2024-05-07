import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MyProgramUtility {
    private List<Citizen> citizens;

    public MyProgramUtility() {
        citizens = new ArrayList<>();
    }

    public void loadDataFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].trim();
                }
                String districtNumberStr = data[6].replaceAll("[^\\d.]", "");
                int districtNumber = Integer.parseInt(districtNumberStr);
                Citizen citizen = new Citizen(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
                        data[5].equals("Resident") ? "Resident" : "Non-Resident", districtNumber, data[7]);
                citizens.add(citizen);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + filename);
        }
    }

    public List<Citizen> getCitizens() {
        return citizens;
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
