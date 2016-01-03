package lctst.model;

public class VoteSummary {
    private final int restaurantId;
    private final String restaurantName;
    private final long votes;

    public VoteSummary(int restaurantId, String restaurantName, long votes) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.votes = votes;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public long getVotes() {
        return votes;
    }

}
