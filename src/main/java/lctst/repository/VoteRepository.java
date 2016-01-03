package lctst.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import lctst.model.Vote;
import lctst.model.VoteSummary;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT NEW lctst.model.VoteSummary (r.id, r.name,COUNT(v)) FROM Restaurant r LEFT JOIN r.voteCollection v WHERE v.date=CURRENT_DATE GROUP BY r.id")
    public List<VoteSummary> findVoteResults();

}
