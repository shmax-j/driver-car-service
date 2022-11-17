package taxi.service;

import java.util.List;
import taxi.dao.GenericDao;

public abstract class GenericServiceImpl<T> implements GenericService<T> {

    @Override
    public T create(T element) {
        return getDao().create(element);
    }

    @Override
    public T get(Long id) {
        return getDao().get(id).get();
    }

    @Override
    public List<T> getAll() {
        return getDao().getAll();
    }

    @Override
    public T update(T element) {
        return getDao().update(element);
    }

    @Override
    public boolean delete(Long id) {
        return getDao().delete(id);
    }

    protected abstract GenericDao<T> getDao();
}
