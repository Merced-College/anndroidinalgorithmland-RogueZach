[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23372603)
# AnnDroidInAlgorithmLand

A sample project to practice sorting and searching.

**Group Members:** Zachary Amith + John Chiero

**Date:** March 31, 2026

Project setup completed successfully.

---

## Code Exploration

### Step 1 — Project Structure

**What types of files are located in the src folder?**
Java files (`.java`). These are the source code files that make up the game.

**What appears to be stored in the content folder?**
Images, sound files, and the leaderboard CSV file. These are the assets the game uses when it runs.

**What is the purpose of the uml folder?**
It has a diagram that shows how the classes in the project relate to each other.

**Why do software projects often separate code from content/assets?**
It keeps things organized. You can change images or sounds without touching the code, and vice versa.

### Step 2 — Main Program

**Which class contains the main() method?**
`Main.java`

**What does the program do when it first starts running?**
It opens a window and shows the main menu with background music playing.

**What objects or classes are created when the program begins?**
A `JFrame` (the window), an `AppRouter` (manages which screen is showing), and three panels: `MainMenuPanel`, `RabbitGamePanel`, and `LeaderboardPanel`.

### Step 3 — Program Execution

**Which class appears responsible for drawing graphics?**
`MainMenuPanel` draws the menu screen. `RabbitGamePanel` draws the game screen with the rabbit and score.

**Which class appears responsible for loading files or content?**
`Assets` loads images and audio. `LeaderboardRepository` loads the CSV file.

**How does the game update what appears on the screen?**
It uses timers that fire every second. One timer moves the rabbit to a new spot. Another counts down the clock. Each time they fire, the screen redraws.

### Step 4 — UML Diagram

**What does the UML diagram help you understand about the program?**
It shows which classes exist and how they connect to each other.

**Which class appears to be the central class in the system?**
`AppRouter`. It controls which screen the user sees and owns all three panels.

**Which classes depend on or interact with other classes?**
All three panels use `AppRouter` to switch screens and `Assets` to load files. `LeaderboardPanel` uses `LeaderboardRepository` to load data and `LeaderboardAlgorithms` to sort and search.

### Step 5 — Score System

**Where in the code are scores stored?**
In `ScoreEntry` objects inside an `ArrayList` in `LeaderboardPanel`. The data comes from `leaderboard.csv`.

**What data type is used to store scores?**
`int`

**Where would it make sense to implement sorting of scores?**
In `LeaderboardAlgorithms.java`. It already has empty methods that the leaderboard screen calls.

---

## Sorting

**In which class did your team add the sorting code?**
`LeaderboardAlgorithms.java`

**Why did you choose that location?**
It was set up for us with empty methods, and the leaderboard screen already calls those methods.

**What data structure is being sorted?**
An `ArrayList<ScoreEntry>`.

**Which sorting algorithm did your team choose?**
Selection sort for sorting by score, and insertion sort for sorting by username.

**How does your algorithm work in your own words?**
Selection sort goes through the list and finds the biggest score, then swaps it to the front. Then it finds the next biggest and puts it second, and so on until the whole list is sorted.

Insertion sort starts at the second item and works forward. For each item, it slides it backward past any items that come after it alphabetically, until it lands in the right spot.

**How did you verify that your sort was correct?**
We ran the program, loaded the CSV, clicked "Top 20" and checked that the highest scores were on top. Then we clicked "Sort by Username" and checked that names went from A to Z.

---

## Searching

**How does binary search work in your own words?**
It looks at the middle of the list. If that's the one we want, we're done. If what we want comes before the middle, we throw out the second half and search the first half. If it comes after, we throw out the first half. We keep cutting the list in half until we find it or run out of list.

**Why must the data be sorted before binary search can be used?**
Because the whole idea is to throw away half the list based on whether the target is bigger or smaller than the middle. If the list isn't sorted, that doesn't work.

**What variables did you use for low, high, and mid?**
- `low` — the start of the section we're searching
- `high` — the end of the section we're searching
- `mid` — the middle, calculated as `low + (high - low) / 2`

**What happens when the score is not found?**
The loop ends because `low` passes `high`, meaning there's nothing left to search. The method returns `-1` and the screen says "Not found."
