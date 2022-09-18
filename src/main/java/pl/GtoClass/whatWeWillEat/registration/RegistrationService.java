package pl.GtoClass.whatWeWillEat.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.GtoClass.whatWeWillEat.appuser.AppUser;
import pl.GtoClass.whatWeWillEat.appuser.AppUserRole;
import pl.GtoClass.whatWeWillEat.appuser.AppUserService;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
       boolean isValidEmail = emailValidator.test(request.getEmail());

       if(!isValidEmail){
           throw new IllegalStateException("email not valid");
       }

        return appUserService.signUpUser(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
                ));
    }
}
