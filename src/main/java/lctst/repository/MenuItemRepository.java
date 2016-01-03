package lctst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lctst.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
