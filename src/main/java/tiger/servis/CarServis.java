package tiger.servis;

import tiger.model.Car;

import java.util.List;

public interface CarServis {
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int id);
    Car getCar(Integer id);
    List<Car> getCars();
}
