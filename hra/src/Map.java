import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Map {

    private String nameOfLocation;
    private int numberOfLocation;
    HashMap<Integer, String> hashMap = new HashMap<>();

    public void generateMap(){
        try (BufferedReader reader = new BufferedReader(new FileReader("map.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                nameOfLocation = String.valueOf(line.matches("([A-Z]{1}[a-z]*) ([0-9]+\\,){3}[0-9]+"));
                numberOfLocation = Integer.parseInt(String.valueOf(line.matches("^[0-9]{1,2}")));
                hashMap.put(numberOfLocation, nameOfLocation);
            }
        } catch (IOException e) {
            System.out.println("Map is not loading");
        }
    }

    public HashMap<Integer, String> getHashMap() {
        return hashMap;
    }
}