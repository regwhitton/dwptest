package regwhitton.dwptest.restapi;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import regwhitton.dwptest.model.User;
import regwhitton.dwptest.service.londonusers.LondonUserService;

@RestController
public class LondonUserController {

    @Autowired
    private LondonUserService londonUserService;

    @GetMapping(path = "/londonusers", produces = {
            APPLICATION_STREAM_JSON_VALUE,
            APPLICATION_JSON_VALUE,
    })
    ResponseEntity<Flux<User>> londonUsers() {
        return ok().body(londonUserService.londonUsers());
    }
}
