package regwhitton.dwptest.service.londonusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import regwhitton.dwptest.model.User;

@Service
public class LondonUserService {

    private static final String LONDON = "London";

    private static final Location LONDON_LOCATION = new Location(51.507222D, -0.1275D);

    private static final Double MILES_50 = 50D;

    @Autowired
    private BpdtsClient bpdtsClient;

    @Autowired
    private DistanceCalculator distanceCalculator;

    public Flux<User> londonUsers() {
        // Onward service appears to return users associated with Londons other
        // that London, UK. See assumptions in Readme.md
        Flux<User> livingInLondon = bpdtsClient.usersByCity(LONDON);
        Flux<User> currentlyWithin50Miles = bpdtsClient.allUsers()
            .filter(this::isWithin50MilesOfLondon);

        return livingInLondon.mergeWith(currentlyWithin50Miles)
            .distinct(User::getId);
    }

    private boolean isWithin50MilesOfLondon(User user) {
        // Assuming the Latitude and Longitude given by the onward service
        // is the user's current position.  See assumptions in Readme.md
        Location userLocation = new Location(user.getLatitude(), user.getLongitude());
        Double distance = distanceCalculator.milesBetween(LONDON_LOCATION, userLocation);
        return distance.compareTo(MILES_50) < 0;
    }
}
