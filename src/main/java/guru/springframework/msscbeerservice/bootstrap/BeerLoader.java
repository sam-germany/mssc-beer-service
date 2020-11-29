package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by jt on 2019-05-17.
 */
//@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //using data.sql file now
        //   loadBeerObjects();
    }
    private void loadBeerObjects() {
        Beer b1 = Beer.builder()
                               .beerName("Mango Bobs")
                               .beerStyle("IPA")
                               .minOnHand(12)
                               .quantityToBrew(200)
                               .price(new BigDecimal("12.95"))
                               .upc(BEER_1_UPC)
                               .build();

        Beer b2 = Beer.builder()
                               .beerName("Galaxy Cat")
                               .beerStyle("PALE_ALE")
                               .minOnHand(12)
                               .quantityToBrew(200)
                               .price(new BigDecimal("12.95"))
                               .upc(BEER_2_UPC)
                               .build();

        Beer b3 = Beer.builder()
                               .beerName("Pinball Porter")
                               .beerStyle("PALE_ALE")
                               .minOnHand(12)
                               .quantityToBrew(200)
                               .price(new BigDecimal("12.95"))
                               .upc(BEER_3_UPC)
                               .build();

        beerRepository.save(b1);
        beerRepository.save(b2);
        beerRepository.save(b3);
    }
}


/*
  //      System.out.println("Loaded Beers--------- :  " + beerRepository.count());

beerRepository.count()   <<-- as per documentation this .count() method return the number of
                        entities available, it means how many objects are created with this entity class
e.g
----   in our case if we have 12 record inserted for Beer Class  it means count() = 12


 */


