import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



public class Exercise2{

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
       
        // Get all countries
        Map<String, Optional<City>> mostPopulatedCitiesByContinent = countryDao.findAllCountries()
                .stream()

                //cities of each country
                .flatMap(country -> country.getCities().stream())

                //Group cities by continent
                .collect(Collectors.groupingBy(
                        city -> countryDao.findCountryByCode(city.getCountryCode()).getContinent(),

                        
                        // most populated city for each continent
                        Collectors.maxBy(Comparator.comparingInt(City::getPopulation))
                ));

        // Print the result
        mostPopulatedCitiesByContinent.forEach((continent, optionalCity) -> {
            System.out.print("Continent: " + continent + ", ");
            optionalCity.ifPresent(city -> System.out.println("Most Populated City: " + city.getName() + ", Population: " + city.getPopulation()));
        });
    }
}