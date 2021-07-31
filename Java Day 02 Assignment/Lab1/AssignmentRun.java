package Lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignmentRun {

    public static void main(String[] args) {

        CSVDAO countryDAO = new CSVDAO();
        List<Country> countries = countryDAO.readCountryFromCSV("worldcities.csv");
        CSVDAO cityDAO = new CSVDAO();
        List<City> cities = cityDAO.readCityFromCSV("worldcities.csv", "countrycontinent1.csv");

        Map<String, List<City>> citiesOfCountry = createMapCitiesOfCountries(cities, countries);
        citiesOfCountry.forEach((k, v) -> System.out.println("ID " + k + "Cities : " + v));

    }

    public static Map<String, List<City>> createMapCitiesOfCountries(List<City> cities, List<Country> countries) {
        Map<String, List<City>> citiesOfCountry = new HashMap<>();
        Collections.sort(cities, Collections.reverseOrder());
        for (Country country : countries) {
            List<City> citylist = new ArrayList<City>();
            for (City city : cities) {
                if (city.getCountry().equals(country.getName())) {
                    citylist.add(city);
                    citiesOfCountry.put(country.getId(), citylist);
                }
            }
        }
        return citiesOfCountry;

    }
    /*
     * for (City i : cities) { for (int n=0; n<100; n+=){
     * 
     * System.out.println(,i); }}
     * 
     * for (Country country : countries) { List<City> citylist = new
     * ArrayList<City>();
     * 
     * for (City city : cities) {
     * 
     * if (city.getCountry().equals(country.getName())) { citylist.add(city);
     * citiesOfCountry.put(country.getId(), citylist); // System.out.println("key: "
     * + country.getName() + "; value: " + // city.getCountry()); } } }
     */
    /*
     * for (City city : cities) { // System.out.println(city); String s1 =
     * city.writerCSV(); // System.out.println(s1); String[] s2 = s1.split(",");
     * System.out.println(s2[0]); }
     */

}
