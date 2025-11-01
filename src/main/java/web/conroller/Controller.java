package web.conroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Entity.User;
import web.dao.UserDao;

@org.springframework.stereotype.Controller
public class Controller {

    private final UserDao userDao;

    public Controller(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userDao.getAllUser());
        return "users";
    }

    @PostMapping("/")
    public String deleteUser(@RequestParam int id) {
        userDao.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String getEditPage(@RequestParam int id, Model model) {
        model.addAttribute("users", userDao.find(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user) {
        System.out.println(user.getId());
        userDao.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("users", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userDao.addUser(user);
        return "redirect:/";
    }

}
