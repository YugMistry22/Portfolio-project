import java.util.HashMap;
import java.util.Map;

public class AnimeTracker {

    // Representation (field)
    private Map<String, AnimeEntry> tracker;

    // Internal class to represent an anime
    private static class AnimeEntry {
        String title;
        int totalEpisodes;
        int watchedEpisodes;
        int rating;

        AnimeEntry(String title, int totalEpisodes) {
            this.title = title;
            this.totalEpisodes = totalEpisodes;
            this.watchedEpisodes = 0;
            this.rating = 0;
        }
    }

    // Constructor
    public AnimeTracker() {
        this.tracker = new HashMap<>();
    }

    // Add anime
    public void addAnime(String title, int totalEpisodes) {
        tracker.put(title, new AnimeEntry(title, totalEpisodes));
    }

    // Update progress
    public void updateProgress(String title, int watched) {
        if (tracker.containsKey(title)) {
            tracker.get(title).watchedEpisodes = watched;
        }
    }

    // Set rating
    public void setRating(String title, int rating) {
        if (tracker.containsKey(title)) {
            tracker.get(title).rating = rating;
        }
    }

    // Compute average rating
    public double averageRating() {
        int total = 0;
        int count = 0;

        for (AnimeEntry entry : tracker.values()) {
            if (entry.rating > 0) {
                total += entry.rating;
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return (double) total / count;
    }

    // Compute total episodes watched
    public int totalEpisodesWatched() {
        int total = 0;
        for (AnimeEntry entry : tracker.values()) {
            total += entry.watchedEpisodes;
        }
        return total;
    }

    // Remove anime
    public void removeAnime(String title) {
        tracker.remove(title);
    }

    // Main method to prove concept
    public static void main(String[] args) {
        AnimeTracker tracker = new AnimeTracker();

        tracker.addAnime("Attack on Titan", 75);
        tracker.addAnime("Jujutsu Kaisen", 24);
        tracker.addAnime("Demon Slayer", 26);

        tracker.updateProgress("Attack on Titan", 50);
        tracker.updateProgress("Jujutsu Kaisen", 24);

        tracker.setRating("Attack on Titan", 9);
        tracker.setRating("Jujutsu Kaisen", 8);

        System.out.println("Average Rating: " + tracker.averageRating());
        System.out.println("Total Episodes Watched: " + tracker.totalEpisodesWatched());

        tracker.removeAnime("Demon Slayer");

        System.out.println("Proof of concept complete.");
    }
}

