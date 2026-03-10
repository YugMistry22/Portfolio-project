/**
 * Enhanced interface for AnimeTracker.
 */
public interface AnimeTracker extends AnimeTrackerKernel {

    /**
     * Calculates the average rating of all anime.
     *
     * @return average rating
     * @ensures averageRating >= 0
     */
    double averageRating();

    /**
     * Returns the total number of watched episodes.
     *
     * @return total watched episodes
     * @ensures totalEpisodesWatched >= 0
     */
    int totalEpisodesWatched();

    /**
     * Returns the number of completed anime.
     *
     * @return number of completed anime
     * @ensures completedCount >= 0
     */
    int completedCount();

    /**
     * Checks if a specific anime is completed.
     *
     * @param title
     *            the anime title
     * @return true if completed
     */
    boolean isCompleted(String title);

    /**
     * Returns the highest rated anime title.
     *
     * @return highest rated anime
     */
    String highestRatedAnime();
}