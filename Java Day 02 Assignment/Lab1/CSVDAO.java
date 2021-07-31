package Lab1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CSVDAO {

    public List<City> readCityFromCSV(String filePath, String continentPath) {
        List<City> Citys = new ArrayList<City>();
        City c1;
        File CityInfo = new File(filePath);
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(CityInfo.toPath());
        } catch (IOException e) {
            System.out.println("Cannot Read file");
        }

        for (int lineInd = 1; lineInd < lines.size(); lineInd++) {
            String line = lines.get(lineInd);
            String[] fields = line.split(",");
            c1 = createCity(fields);

            Citys.add(c1);
        }
        Citys = setContinentOfCity(Citys, continentPath);
        return Citys;
    }

    public static List<City> setContinentOfCity(List<City> cities, String filePath) {

        File CityInfo = new File(filePath);
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(CityInfo.toPath());
        } catch (IOException e) {
            System.out.println("Cannot Read file");
        }

        for (int lineInd = 1; lineInd < lines.size(); lineInd++) {
            String line = lines.get(lineInd);
            String[] fields = line.split(",");
            for (City city : cities) {
                // System.out.println("ID " + city.getCountry_id() + " ISo3 " + fields[1]);
                if (fields[1].equals(city.getCountry_id().replaceAll("^\"|\"$", ""))) {
                    city.setContinent(fields[0]);
                }
            }

        }
        return cities;
    }

    public static City createCity(String[] data) {
        boolean capital = false;
        if ("primary".equals(data[8].replaceAll("^\"|\"$", "")))
            capital = true;

        City c = new City(data[0], data[1], data[4], data[6], data[10], data[9], capital);
        return c;

    }

    public List<Country> readCountryFromCSV(String filePath) {
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

        Country c = new Country(data[4], data[6]);
        return c;

    }
}
