package br.com.juwer.login.registration;

import br.com.juwer.login.appuser.AppUser;
import br.com.juwer.login.appuser.AppUserRole;
import br.com.juwer.login.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail) {
            throw new IllegalStateException("Email not valid!");
        }

        return appUserService.signUpUser(new AppUser(
            request.getFirstName(),
            request.getLastname(),
            request.getEmail(),
            request.getPassword(),
            AppUserRole.USER
        ));
    }
}
