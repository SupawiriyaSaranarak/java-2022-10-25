package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class Web {
    @Autowired
    UserRepository user;
    @RequestMapping("/list/users")
    Iterable<User> listUsers() {
        return user.findAll();
    }
}
