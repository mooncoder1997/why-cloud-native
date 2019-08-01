package why.scaffold.security.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import why.scaffold.security.core.entity.User;
import why.scaffold.security.core.repository.UserRepository;

/**
 * @className: UserController
 * @description:
 * @version: v1.0
 * @date: 2019/8/1 14:09
 * @author: Wang, Haoyue
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }

    @GetMapping
    public Object getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public Object create(@RequestBody User user) {
        user.setUserPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
