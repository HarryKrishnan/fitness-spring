package fit.app;

import fit.app.dto.ProfileRequest;
import fit.app.entities.Login;
import fit.app.entities.Profile;
import fit.app.service.FitService;
import fit.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private FitService fitService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    @CrossOrigin("*")
    public ResponseEntity<String> Register(@RequestBody ProfileRequest profile) {
        return ResponseEntity.ok(fitService.registerUser(profile));
    }
    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<String> Login(@RequestBody Login login)  {
        return ResponseEntity.ok(loginService.login(login));
    }
}
