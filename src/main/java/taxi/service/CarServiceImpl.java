package taxi.service;

import java.util.List;
import taxi.dao.CarDao;
import taxi.dao.GenericDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Car;
import taxi.model.Driver;

@Service
public class CarServiceImpl extends GenericServiceImpl<Car>
        implements CarService {
    @Inject
    private CarDao carDao;

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        car.getDrivers().add(driver);
        carDao.update(car);
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        car.getDrivers().remove(driver);
        carDao.update(car);
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        return carDao.getAllByDriver(driverId);
    }

    @Override
    protected GenericDao<Car> getDao() {
        return carDao;
    }
}
