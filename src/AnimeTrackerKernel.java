import components.standard.Standard;

/**
 * Kernel interface for AnimeTracker.
 */
public interface AnimeTrackerKernel extends Standard<AnimeTracker> {

    /**
     * Enumeration representing the status of an anime.
     */
    enum AnimeStatus {
        PLAN_TO_WATCH,
        WATCHING,
        COMPLETED,
        DROPPED
    }

    /**
     * Adds an anime to the tracker.
     *
     * @param title
     *            the title of the anime
     * @param totalEpisodes
     *            total number of episodes
     * @requires title is not empty and totalEpisodes > 0
     * @updates this
     * @ensures this contains an entry for title
     */
    void addAnime(String title, int totalEpisodes);

    /**
     * Removes an anime from the tracker.
     *
     * @param title
     *            the anime title
     * @requires this contains title
     * @updates this
     * @ensures this no longer contains title
     */
    void removeAnime(String title);

    /**
     * Checks if the tracker contains an anime.
     *
     * @param title
     *            the anime title
     * @return true if the anime exists
     * @ensures hasAnime = (title exists in this)
     */
    boolean hasAnime(String title);

    /**
     * Updates watched episodes for an anime.
     *
     * @param title
     *            the anime title
     * @param watchedEpisodes
     *            number of episodes watched
     * @requires this contains title
     * @updates this
     * @ensures watched episodes for title = watchedEpisodes
     */
    void updateProgress(String title, int watchedEpisodes);

    /**
     * Sets the rating of an anime.
     *
     * @param title
     *            the anime title
     * @param rating
     *            rating from 0-10
     * @requires this contains title
     * @updates this
     * @ensures rating of title = rating
     */
    void setRating(String title, int rating);

    /**
     * Returns the number of anime in the tracker.
     *
     * @return number of anime
     * @ensures size >= 0
     */
    int size();
}