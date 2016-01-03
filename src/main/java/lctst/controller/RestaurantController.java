package lctst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lctst.model.Restaurant;
import lctst.repository.RestaurantRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> findRestaurants() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = "q")
    public List findRestaurants(@RequestParam("q") String query) {
        if (query.equals("today")) {
            return repo.findAllToday();
        } else {
            throw new RuntimeException("Unknown query '" + query + "'");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        restaurant.setId(null);
        return repo.saveAndFlush(restaurant);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Restaurant updateRestaurant(@RequestBody Restaurant updatedRestaurant, @PathVariable Integer id) {
        updatedRestaurant.setId(id);
        return repo.saveAndFlush(updatedRestaurant);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRestaurant(@PathVariable Integer id) {
        repo.delete(id);
    }
}
