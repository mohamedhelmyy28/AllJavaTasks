package Lab3;

import Lab1.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityOperations {
    public static void main(String[] args) {

        CityCSVDAO cityDAO = new CityCSVDAO();
        List<City> cities = cityDAO.readFromCSV("cities.csv");

    }

    public Map<String,Object> highestPopulationCountry(List<City> cities) {
        
        return cities.stream().collect(Collectors.groupingBy(City::getCountry),(Comparator Collectors.maxBy(City::getPopulation)));
    }

    public Map<String,Object> highestPopulationContinent(List<City> cities) {
        
        return cities.stream().collect(Collectors.groupingBy(City::getContinent,(Comparator Collectors.maxBy(City::getPopulation)));
    }

    public Map<String,Object> highestPopulationCapital(List<City> cities) {
        
        return cities.stream().collect(Collectors.groupingBy(City::isCapital,(Comparator Collectors.maxBy(City::getPopulation)));
    }
}
