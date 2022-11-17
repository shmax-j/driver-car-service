package taxi.service;

import java.util.Objects;
import java.util.Optional;
import taxi.exception.AuthenticationException;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private DriverService driverService;

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> optionalDriver = driverService.findDriverByLogin(login);
        if (optionalDriver.isEmpty()
                || !Objects.equals(optionalDriver.get().getPassword(),
                password)) {
            throw new AuthenticationException("Bad credentials!");
        }
        return optionalDriver.get();
    }
}
