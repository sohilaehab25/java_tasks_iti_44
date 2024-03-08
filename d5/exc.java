import java.util.Comparator;
import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.stream.Collectors;

class Exercise1 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();

        //list of countries
        List<Country> countries = countryDao.findAllCountries();

        //highest populated city 
        countries.forEach(country -> {
            List<City> cities = country.getCities();
            if (!cities.isEmpty()) { 
                City maxCity = cities.stream()
                        .max(Comparator.comparingInt(City::getPopulation))
                        .orElse(null); 
                if (maxCity != null) { 
                    System.out.println("Country: " + country.getName() +
                            ", Highest Populated City: " + maxCity.getName());
                } else {
                    System.out.println("Country: " + country.getName() + ", No cities found.");
                }
            } else {
                System.out.println("Country: " + country.getName() + ", No cities found.");
            }
        });
    }
}
