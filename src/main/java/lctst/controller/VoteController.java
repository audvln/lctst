package lctst.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import lctst.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lctst.model.Vote;
import lctst.repository.UserRepository;
import lctst.repository.VoteRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteRepository repo;
    @Autowired
    private UserRepository repoUser;

    @RequestMapping(method = RequestMethod.GET, params = "q")
    public List findRestaurants(@RequestParam("q") String query) {
        if (query.equals("summary")) {
            return repo.findVoteResults();
        } else {
            throw new RuntimeException("Unknown query '" + query + "'");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Vote> findVotes() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Vote addVote(@RequestBody lctst.dto.Vote vote) {
        return updateVote(vote);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Vote updateVote(@RequestBody lctst.dto.Vote vote) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = repoUser.findByName(auth.getName());
        if (user == null) {
            return null;
        }

        if (LocalDateTime.now().getHour() >= 11) {
            return user.getVote();
        }

        Vote updatedVote = new Vote();
        updatedVote.setDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        updatedVote.setUserid(user.getId());
        updatedVote.setRestaurant(vote.getRestaurantId());
        return repo.saveAndFlush(updatedVote);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteVote(@PathVariable Integer id) {
        repo.delete(id);
    }
}
