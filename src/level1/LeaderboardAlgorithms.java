package level1;

import java.util.ArrayList;

/**
 * STUDENT TODO FILE
 *
 * You will implement sorting and binary search for the Leaderboard Terminal.
 */
public class LeaderboardAlgorithms {

    /**
     * Sort the list by score DESCENDING (highest score first).
     * Uses selection sort: on each pass, find the largest unsorted score
     * and swap it into position.
     */
    public static void sortByScoreDescending(ArrayList<ScoreEntry> list) {
        int n = list.size();

        // Each iteration places the next-highest score at index i
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i; // assume current position has the max

            // Scan the unsorted portion for a larger score
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getScore() > list.get(maxIndex).getScore()) {
                    maxIndex = j; // found a bigger score
                }
            }

            // Swap the found maximum into position i
            if (maxIndex != i) {
                ScoreEntry temp = list.get(i);
                list.set(i, list.get(maxIndex));
                list.set(maxIndex, temp);
            }
        }
    }

    /**
     * Sort the list by username ASCENDING (A -> Z).
     * Uses insertion sort: take each element and insert it into its
     * correct position among the already-sorted elements before it.
     */
    public static void sortByUsernameAscending(ArrayList<ScoreEntry> list) {
        int n = list.size();

        // Start at index 1; index 0 is trivially sorted
        for (int i = 1; i < n; i++) {
            ScoreEntry key = list.get(i);        // element to insert
            int j = i - 1;

            // Shift elements that come after 'key' alphabetically to the right
            while (j >= 0 && list.get(j).getUsername().compareToIgnoreCase(key.getUsername()) > 0) {
                list.set(j + 1, list.get(j));    // shift right
                j--;
            }

            // Drop 'key' into its correct sorted position
            list.set(j + 1, key);
        }
    }

    /**
     * Binary search for an EXACT username match.
     * Precondition: list must already be sorted by username ascending.
     *
     * Uses low, high, and mid to repeatedly halve the search range.
     * Compares the middle element's username to the target:
     *   - if equal, we found it
     *   - if target comes before mid alphabetically, search the left half
     *   - if target comes after mid alphabetically, search the right half
     *
     * @return index of the matching entry, or -1 if not found
     */
    public static int binarySearchByUsername(ArrayList<ScoreEntry> list, String username) {
        int low = 0;                    // start of search range
        int high = list.size() - 1;     // end of search range

        while (low <= high) {
            int mid = low + (high - low) / 2;  // midpoint (avoids overflow)

            // Compare target username with the mid element's username
            int cmp = username.compareToIgnoreCase(list.get(mid).getUsername());

            if (cmp == 0) {
                return mid;             // exact match found
            } else if (cmp < 0) {
                high = mid - 1;         // target is in the left half
            } else {
                low = mid + 1;          // target is in the right half
            }
        }

        return -1; // not found
    }
}
