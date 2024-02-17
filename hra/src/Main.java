import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Map map = null;

        try {
            map = new Map();
        } catch (IOException e){
            System.out.println("File was not found");
        }

        System.out.println(map.toString());
    }
}