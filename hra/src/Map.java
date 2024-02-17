import java.io.*;
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
                int west = 0;
                int north = 0;
                int east = 0;
                int south = 0;

                for (int i = 0; i < 4;i++){
                    switch (i){
                        case 0:
                            west = loadDirections(line)[i];
                        case 1:
                            north = loadDirections(line)[i];
                        case 2:
                            east = loadDirections(line)[i];
                        case 3:
                            south = loadDirections(line)[i];
                    }
                }
                numberOfLocation++;
                hashMap.put(numberOfLocation, new Location(west, north, east, south, loadName(line)));
            }
    }

    public int[] loadDirections(String line){

        /*
        String direction;
        int temp;
        int[] a = new int[4];
        direction = String.valueOf(line.matches("([0-9]+\\,){3}[0-9]+"));
        direction.replaceAll(",", "");

        for (int i = 0; i < a.length;i++){
            temp = direction.charAt(i);
            a[i] = temp;
        }
        return a;

         */



        Pattern pattern = Pattern.compile("([0-9]+,){3}[0-9]+");
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        String[] a_temp = matcher.group().split(",");
        int[] a_cardinal_directions = new int[4];
        for (int i = 0; i < a_temp.length; i++){
            a_cardinal_directions[i] = Integer.parseInt(a_temp[i]);
        }
        return a_cardinal_directions;



    }

    public String loadName(String line){
        Pattern pattern = Pattern.compile("[A-Z]{1}[a-z]*");
        Matcher matcher = pattern.matcher(line);
        String nameOfLocation;

        matcher.find();
        nameOfLocation = matcher.group();

        return nameOfLocation;
    }

    @Override
    public String toString() {
        return "Map{" +
                "hashMap=" + hashMap +
                '}';
    }
}