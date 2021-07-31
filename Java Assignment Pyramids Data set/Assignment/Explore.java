package Assignment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Explore {
    public static void main(String[] args) {
        File pyramidInfo = new File("pyramids.csv");

        List<String> lines = new ArrayList<String>();

        try {
            lines = Files.readAllLines(pyramidInfo.toPath());
        } catch (IOException e) {

            System.out.println("Invalid File Path");

        }
        for (int lineInd = 0; lineInd < lines.size(); lineInd++) {
            String line = lines.get(lineInd);
            String[] fields = line.split(",");
            System.out.println(fields[7] + " Length " + fields[7].length());
            for (String i : fields) {

                System.out.print(i + " ; ");
            }

        }
    }

}
