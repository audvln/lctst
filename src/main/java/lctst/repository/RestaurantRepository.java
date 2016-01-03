package lctst.repository;

import lctst.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import lctst.model.VoteSummary;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("SELECT r FROM Restaurant r LEFT JOIN r.menuItemCollection v WHERE v.date=CURRENT_DATE OR v.date is NULL") 
    public List<Restaurant> findAllToday();

}
