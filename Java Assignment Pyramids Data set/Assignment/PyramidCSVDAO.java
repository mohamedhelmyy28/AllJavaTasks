package Assignment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO {

    public List<Pyramid> readFromCSV(String filePath) {
        List<Pyramid> pyramids = new ArrayList<Pyramid>();
        Pyramid p1;
        File pyramidInfo = new File(filePath);
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(pyramidInfo.toPath());
        } catch (IOException e) {
            System.out.println("Cannot Read file");
        }
        int count = 0;
        double sum = 0;
        double average = 0;
        for (int lineInd = 1; lineInd < lines.size(); lineInd++) {
            String line = lines.get(lineInd);
            String[] fields = line.split(",");
            if (fields[7].length() > 0) {
                p1 = createPyramid(fields);
                sum = sum + Double.parseDouble(fields[7]);
                count++;
                average = Math.round(sum / count);
            } else {
                fields[7] = String.valueOf(average);
                p1 = createPyramid(fields);
            }

            pyramids.add(p1);
        }
        return pyramids;
    }

    public static Pyramid createPyramid(String[] data) {
        double height = Double.parseDouble(data[7]);
        Pyramid p = new Pyramid(data[0], data[2], data[4], height);
        return p;

    }
}
