import java.util.Comparator;
import java.util.Optional;

public class Exercise5 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();

        Optional<City> mostPopulatedCapital = countryDao.findAllCountries().stream()
                .map(country -> cityDao.findCityById(country.getCapital()))
                .filter(city -> city != null) 
                .max(Comparator.comparingInt(City::getPopulation)); 

                  System.out.println("The most populated capital city is: " + mostPopulatedCapital.get().getName());

       
    }
}
