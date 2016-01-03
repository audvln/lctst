package lctst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lctst.model.User;
import lctst.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repo;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findUsers() {
        return repo.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        user.setId(null);
        return repo.saveAndFlush(user);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User updatedUser, @PathVariable Integer id) {
        updatedUser.setId(id);
        return repo.saveAndFlush(updatedUser);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        repo.delete(id);
    }
}
