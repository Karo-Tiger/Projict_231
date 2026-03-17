package tiger.dao;
import org.springframework.stereotype.Repository;
import tiger.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CarDaoImp implements CarDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCar(Car car) {
        entityManager.persist(car);
    }

    @Override
    public void updateCar(Car car) {
        entityManager.merge(car);
    }

    @Override
    public void deleteCar(int id) {
        Car car = entityManager.find(Car.class, id);
        if (car != null) {
            entityManager.remove(car);
        }
    }

    @Override
    public Car getCar(Integer id) {
       return entityManager.find(Car.class, id);
    }

    @Override
    public List<Car> getCars() {
       return entityManager.createQuery("from Car", Car.class).getResultList();
    }
}