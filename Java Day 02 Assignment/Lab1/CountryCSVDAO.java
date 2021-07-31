package Lab1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CountryCSVDAO {

    public List<Country> readFromCSV(String filePath) {
        List<Country> Countrys = new ArrayList<Country>();
        Country c1;
        File CountryInfo = new File(filePath);
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(CountryInfo.toPath());
        } catch (IOException e) {
            System.out.println("Cannot Read file");
        }

        for (int lineInd = 1; lineInd < lines.size(); lineInd++) {
            String line = lines.get(lineInd);
            String[] fields = line.split(",");

            c1 = createCountry(fields);

            Countrys.add(c1);
        }
        return Countrys;
    }

    public static Country createCountry(String[] data) {

        int d3 = Integer.parseInt(data[3]);
        Country c = new Country(data[0], data[1], data[2], d3);
        return c;

    }
}
