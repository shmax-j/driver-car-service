package taxi.service;

import java.util.Optional;
import taxi.dao.DriverDao;
import taxi.dao.GenericDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;

@Service
public class DriverServiceImpl extends GenericServiceImpl<Driver>
        implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    protected GenericDao<Driver> getDao() {
        return driverDao;
    }

    @Override
    public Optional<Driver> findDriverByLogin(String login) {
        return driverDao.findDriverByLogin(login);
    }
}
