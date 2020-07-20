package regwhitton.dwptest.service.londonusers;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import regwhitton.dwptest.model.User;

@Service
public class LondonUserService {

    public Flux<User> londonUsers() {
        return twoUsers();
    }

    private Flux<User> twoUsers() {
        return Flux.fromArray(new User[] {
                User.builder()
                    .id(007L)
                    .firstName("James")
                    .lastName("Bond")
                    .email("james.bond@sis.gov.uk")
                    .ipAddress("104.18.6.144")
                    .latitude(51.487222)
                    .longitude(-0.124167)
                    .build(),
                User.builder()
                    .id(8L)
                    .firstName("Jane")
                    .lastName("Bond")
                    .email("jane.bond@sis.gov.uk")
                    .ipAddress("104.18.6.144")
                    .latitude(51.487222)
                    .longitude(-0.124167)
                    .build()
        });
    }
}
