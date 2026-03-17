package tiger.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tiger.model.Car;
import tiger.servis.CarServis;

import java.util.List;

@Controller
@RequestMapping("/gai")
public class CarControl {
    @Autowired
    private CarServis carServis;

    @GetMapping()
    public String spisok(Model model) {
        List<Car> cars = carServis.getCars();
        model.addAttribute("cars", cars);
        return "car";
    }

    @GetMapping("/car")
    public String carId(@RequestParam("id") Integer id, Model model) {
        Car car = carServis.getCar(id);
        model.addAttribute("car", car);
        return "car1";
    }

    @GetMapping("/new")
    public String newcar(Model model) {
        model.addAttribute("car", new Car());
        return "car2";
    }

    @PostMapping("/newe")
    public String newcar2(@ModelAttribute("car") Car car) {
        carServis.addCar(car);
        return "redirect:/gai";
    }

    @GetMapping("/edit")
    public String editcar(Model model,@RequestParam("id") Integer id) {
        Car car = carServis.getCar(id);
        model.addAttribute("car", car);
        return "car3";
    }
    @PostMapping("/update")
    public String updatecar(@RequestParam("id") int id,@ModelAttribute("car")Car car) {
        car.setId(id);
        carServis.updateCar(car);
        return "redirect:/gai";
    }

    @PostMapping("/delete")
    public String deletca(@RequestParam("id") int id) {
        carServis.deleteCar(id);
        return "redirect:/gai";

    }

}

