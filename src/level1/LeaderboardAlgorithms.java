package level1;

import java.util.ArrayList;

/**
 * Sorting and binary search for the Leaderboard Terminal.
 */
public class LeaderboardAlgorithms {

    // selection sort - highest score first
    public static void sortByScoreDescending(ArrayList<ScoreEntry> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            // find the biggest score in the rest of the list
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getScore() > list.get(maxIndex).getScore()) {
                    maxIndex = j;
                }
            }

            // swap it into place
            if (maxIndex != i) {
                ScoreEntry temp = list.get(i);
                list.set(i, list.get(maxIndex));
                list.set(maxIndex, temp);
            }
        }
    }

    // insertion sort - usernames A to Z
    public static void sortByUsernameAscending(ArrayList<ScoreEntry> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            ScoreEntry key = list.get(i);
            int j = i - 1;

            // move entries that come after key to the right
            while (j >= 0 && list.get(j).getUsername().compareToIgnoreCase(key.getUsername()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }
    }

    // binary search - list needs to be sorted by username first
    // returns index if found, -1 if not
    public static int binarySearchByUsername(ArrayList<ScoreEntry> list, String username) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = username.compareToIgnoreCase(list.get(mid).getUsername());

            if (cmp == 0) {
                return mid;        // found it
            } else if (cmp < 0) {
                high = mid - 1;    // look left
            } else {
                low = mid + 1;     // look right
            }
        }

        return -1; // not in the list
    }
}
