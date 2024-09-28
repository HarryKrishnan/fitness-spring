package fit.app.service;

import fit.app.dto.ProfileRequest;
import fit.app.entities.Login;
import fit.app.entities.Profile;
import fit.app.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private LoginService loginService;

    public String registerUser(ProfileRequest profile) {

        Profile profileSaved = profileRepository.save(new Profile(profile) );
        if(profileSaved!=null){
            Login login = new Login();
            login.setEmail(profile.getEmail());
            login.setPassword(profile.getPassWord());
            loginService.signUp(login);
            return "Profile Created";
        }
        return "Operation Failed";
    }
}
