package ind.lgh.provideruser.controller;

import ind.lgh.provideruser.domain.User;
import ind.lgh.provideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        User getOne = userRepository.getOne(id);
        return getOne;
    }
}
