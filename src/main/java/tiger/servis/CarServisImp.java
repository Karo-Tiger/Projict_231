package tiger.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.CarDao;
import tiger.model.Car;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CarServisImp implements CarServis {

    @Autowired
    private CarDao carDao;
    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }
    @Transactional
    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }
    @Transactional
    @Override
    public void deleteCar(int id) {
        carDao.deleteCar(id);
    }
    @Transactional
    @Override
    public Car getCar(Integer id) {
        return carDao.getCar(id);
    }
    @Transactional
    @Override
    public List<Car> getCars() {
        return carDao.getCars();
    }
}
