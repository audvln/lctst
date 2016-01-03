package lctst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lctst.model.MenuItem;
import lctst.repository.MenuItemRepository;

@RestController
@RequestMapping("/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<MenuItem> findMenuItems() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        menuItem.setId(null);
        return repo.saveAndFlush(menuItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public MenuItem updateMenuItem(@RequestBody MenuItem updatedMenuItem, @PathVariable Integer id) {
        updatedMenuItem.setId(id);
        return repo.saveAndFlush(updatedMenuItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMenuItem(@PathVariable Integer id) {
        repo.delete(id);
    }
}
