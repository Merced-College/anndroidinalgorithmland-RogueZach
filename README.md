[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23372385)
# AnnDroidInAlgotihmLand
a sample project to practice sorting and searching

🎵 Download Required Audio File

This project uses an audio file that is too large to store directly in the GitHub repository.
Please download the file from Google Drive before running the program.

Download the audio file here:

➡️ Download the required audio file from Google Drive

Instructions

Open the Google Drive folder using the link above.

Download the ZIP file that contains the audio file.

Extract (unzip) the file on your computer.

Place the extracted audio file into the project folder named content.

Download all of the whole content folder, and put this in your project.


# GROUP MEMBERS
**John Chiero** + **Zachary Amith**

## Code Exploration
Part 2 Questions:
1.  Which class contains the main() method?
--> The class that contains the main() method is Main.java

2.  What does the program do when it first starts running?
--> It opens a window and shows the main menu. Background music starts playing right away.

3.  What objects or classes are created when the program begins?
--> A JFrame (the window), an AppRouter (handles switching between screens), and three panels: MainMenuPanel, RabbitGamePanel, and LeaderboardPanel.

4.  Which class appears responsible for drawing graphics?
--> MainMenuPanel draws the menu screen. RabbitGamePanel draws the game with the rabbit and the score.

5.  Which class appears responsible for loading files or content?
--> Assets loads images and audio files. LeaderboardRepository loads the CSV file.

6.  How does the game update what appears on the screen?
--> It uses timers that go off every second. One timer moves the rabbit to a random spot. Another one counts down the clock. Every time they go off the screen redraws.

7.  What does the UML diagram help you understand about the program?
--> It shows what classes are in the project and how they connect to each other.

8.  Which class appears to be the central class in the system?
--> AppRouter. It controls which screen shows up and it owns all three panels.

9.  Which classes depend on or interact with other classes?
--> All three panels use AppRouter to switch screens and Assets to load files. LeaderboardPanel also uses LeaderboardRepository to load data and LeaderboardAlgorithms to sort and search.

10. Where in the code are scores stored?
--> In ScoreEntry objects inside an ArrayList in LeaderboardPanel. The data comes from leaderboard.csv.

11. What data type is used to store scores?
--> int

12. Where would it make sense to implement sorting of scores?
--> In LeaderboardAlgorithms.java. It already has empty methods that the leaderboard screen calls.

Part 3 Questions:
1. In which class did your team add the sorting code?
--> LeaderboardAlgorithms.java

2. Why did you choose that location?
--> It already had empty methods set up for us and the leaderboard screen was already calling them.

3. What data structure is being sorted?
--> An ArrayList of ScoreEntry objects.

4. Which sorting algorithm did your team choose?
--> Selection sort for sorting by score and insertion sort for sorting by username.

5. How does your algorithm work in your own words?
--> Selection sort looks through the whole list and finds the biggest score then swaps it to the front. Then it looks through the rest and finds the next biggest and puts it second. It keeps doing that until everything is in order.

--> Insertion sort starts at the second item and goes forward. It takes each item and slides it back past anything that comes after it alphabetically until it lands in the right spot.


6. How did you verify that your sort was correct?
--> We ran the program, loaded the CSV, clicked Top 20 and made sure the highest scores were on top. Then we clicked Sort by Username and made sure the names went A to Z.


Part 4 Questions:
1. How does binary search work in your own words?
--> How binary search works is by first looking at the middle of a list. If this value is the desired value, then it is done and the index is returned. However, if it is not, then it is checked to see if the value is too low or too high. If low, then the right half is searched. If high, then the left half is search. This is repeated until the value has either been found, in which the index is returned, or if there are no more elements to seach through.

2. Why must the data be sorted before binary search can be used?
--> Since binary search checks to see if the value being searched for is greater than or less than the value at the index, the data has to be sorted. Otherwise, a greater value could be to the left, and a lesser value could be to the right.

3. What variables did you use for low, high, and mid?
--> low is the start of the section we're looking in. high is the end. mid the middle and we calculate it as ((l) + (h - l) / 2)

4. What happens when the score is not found?
--> The loop stops because low passes high so theres nothing left to check. The method returns -1 and the screen shows "Not found."
