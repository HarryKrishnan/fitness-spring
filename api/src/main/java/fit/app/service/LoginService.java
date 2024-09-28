package fit.app.service;


import fit.app.entities.Login;
import fit.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;


    public String login(Login userDto)  {
        Login user =  userRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword());
        if(Objects.nonNull(user)){
            return "User Is Valid";
        }
        return "Operation Failed";

    }

    public String signUp(Login userDto)  {
        Login user = userRepository.save(userDto);
        if(Objects.nonNull(user)){
            emailService.sendEmail(user);
            return "Admin User Is Created";
        }
        return "Operation Failed";
    }


}
