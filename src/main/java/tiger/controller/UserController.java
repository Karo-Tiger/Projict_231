package tiger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tiger.model.User;
import tiger.servis.UserServise;

import java.util.List;
@Controller
@RequestMapping("/gai")
public class UserController {

    private final UserServise userServis;

    public UserController(UserServise userServis) {
        this.userServis = userServis;
    }

    @GetMapping()
    public String spisok(Model model) {
        List<User> user = userServis.getUser();
        model.addAttribute("users", user);
        return "car";
    }

    @GetMapping("/car")
    public String carId(@RequestParam("id") Integer id, Model model) {
        User user = userServis.getUser(id);
        model.addAttribute("users", user);
        return "car1";
    }

    @GetMapping("/new")
    public String newcar(Model model) {
        model.addAttribute("car", new User());
        return "car2";
    }

    @PostMapping("/newe")
    public String newcar2(@ModelAttribute("car") User user) {
        userServis.addUser(user);
        return "redirect:/gai";
    }

    @GetMapping("/edit")
    public String editcar(Model model,@RequestParam("id") Integer id) {
        User user = userServis.getUser(id);
        model.addAttribute("car", user);
        return "car3";
    }
    @PostMapping("/update")
    public String updatecar(@RequestParam("id") int id,@ModelAttribute("car")User user) {
        user.setId(id);
        userServis.updateUser(user);
        return "redirect:/gai";
    }

    @PostMapping("/delete")
    public String deletca(@RequestParam("id") int id) {
        userServis.deleteUser(id);
        return "redirect:/gai";

    }
}
