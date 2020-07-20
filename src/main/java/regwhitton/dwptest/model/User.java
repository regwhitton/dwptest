package regwhitton.dwptest.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
    Long id;
    String firstName;
    String lastName;
    String email;
    String ipAddress;
    Double latitude;
    Double longitude;
}
