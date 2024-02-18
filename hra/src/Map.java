import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Map {

    HashMap<Integer, Location> hashMap;
    private BufferedReader reader;

    public Map() throws IOException {
        reader = new BufferedReader(new FileReader("map.txt"));
        hashMap =  new HashMap<>();
        generateMap();
    }

    public void generateMap() throws IOException {
            String line;
            int numberOfLocation = 0;

            while((line = reader.readLine()) != null){
                int west = loadDirections(line)[0];
                int north = loadDirections(line)[1];
                int east = loadDirections(line)[2];
                int south = loadDirections(line)[3];

                numberOfLocation++;
                hashMap.put(numberOfLocation, new Location(west, north, east, south, loadName(line)));

                switch (hashMap.get(numberOfLocation).getName()){
                    case "Forest":
                        hashMap.get(numberOfLocation).setItem(new Heal("apple", 4));
                        break;
                    case "Gate":
                        hashMap.get(numberOfLocation).setNpc(new Npc("Watchman", 6, 2));
                        break;
                    case "Hallway":
                        hashMap.get(numberOfLocation).setItem(new Weapon("dagger", 4));
                        break;
                    case "Guard":
                        hashMap.get(numberOfLocation).setNpc(new Npc("Royal Guard", 12, 4));
                        break;
                    case "Armory":
                        hashMap.get(numberOfLocation).setItem(new Weapon("sword", 6));
                        break;
                    case "Boss":
                        hashMap.get(numberOfLocation).setNpc(new Npc("King", 20, 6));
                        break;
                }
            }
    }
    public String loadName(String line){
        Pattern pattern = Pattern.compile("[A-Z]{1}[a-z]*");
        Matcher matcher = pattern.matcher(line);
        String nameOfLocation;

        matcher.find();
        nameOfLocation = matcher.group();

        return nameOfLocation;
    }

    public int[] loadDirections(String line){
        Pattern pattern = Pattern.compile("([0-9]+,){3}[0-9]+");
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        String[] temp = matcher.group().split(",");
        int[] directions = new int[4];
        for (int i = 0; i < temp.length; i++){
            directions[i] = Integer.parseInt(temp[i]);
        }
        return directions;
    }

    @Override
    public String toString() {
        return "Map{" +
                "hashMap=" + hashMap +
                '}';
    }
}