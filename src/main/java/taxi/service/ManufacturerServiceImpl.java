package taxi.service;

import taxi.dao.GenericDao;
import taxi.dao.ManufacturerDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Manufacturer;

@Service
public class ManufacturerServiceImpl extends GenericServiceImpl<Manufacturer>
        implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;
    @Override
    protected GenericDao<Manufacturer> getDao() {
        return manufacturerDao;
    }
}
