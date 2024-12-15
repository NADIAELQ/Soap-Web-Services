package ma.ensa.mysoapservice;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();
    @PostConstruct
    public void initData() {
        // initialize countries map
        Country france = new Country();
        Country spain = new Country();
        Country germany = new Country();
        Country morocco = new Country();

        france.setName("France");
        france.setPopulation(66991000);
        france.setCapital("Paris");
        france.setCurrency(Currency.EUR);

        spain.setName("Spain");
        spain.setPopulation(46704314);
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);

        germany.setName("Germany");
        germany.setPopulation(83166711);
        germany.setCapital("Berlin");
        germany.setCurrency(Currency.EUR);

        morocco.setName("Morocco");
        morocco.setPopulation(36000000);
        morocco.setCapital("Rabat");
        morocco.setCurrency(Currency.DH);

        countries.put(france.getName().toLowerCase(), france);
        countries.put(spain.getName().toLowerCase(), spain);
        countries.put(germany.getName().toLowerCase(), germany);
        countries.put(morocco.getName().toLowerCase(), morocco);
    }
    public Country findCountry(String name) {
        try {
            Thread.sleep(200); // simuler l’accés réseau
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return countries.get(name.toLowerCase());
    }

    public String addCountry(Country country) {
        countries.put(country.getName().toLowerCase(), country);
        return "Country added successfully";
    }

    public String updateCountry(Country country) {
        if (countries.containsKey(country.getName().toLowerCase())) {
            countries.put(country.getName().toLowerCase(), country);
            return "Country updated successfully";
        }
        return "Country not found";
    }

    public String deleteCountry(String name) {
        if (countries.remove(name.toLowerCase()) != null) {
            return "Country deleted successfully";
        }
        return "Country not found";
    }

    public Collection<Country> getAllCountries() {
        return countries.values();
    }
}