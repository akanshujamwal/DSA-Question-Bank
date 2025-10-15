// Tournament Winner
// There's an algorithms tournament taking place in which teams of programmers compete against each other to solve algorithmic problems as fast as possible. Teams compete in a round robin, where each team faces off against all other teams. Only two teams compete against each other at a time, and for each competition, one team is designated the home team, while the other team is the away team. In each competition there's always one winner and one loser; there are no ties. A team receives 3 points if it wins and 0 points if it loses. The winner of the tournament is the team that receives the most amount of points.

// Given an array of pairs representing the teams that have competed against each other and an array containing the results of each competition, write a function that returns the winner of the tournament. The input arrays are named competitions and results, respectively. The competitions array has elements in the form of [homeTeam, awayTeam], where each team is a string of at most 30 characters representing the name of the team. The results array contains information about the winner of each corresponding competition in the competitions array. Specifically, results[i] denotes the winner of competitions[i], where a 1 in the results array means that the home team in the corresponding competition won and a 0 means that the away team won.

// It's guaranteed that exactly one team will win the tournament and that each team will compete against all other teams exactly once. It's also guaranteed that the tournament will always have at least two teams.

// Sample Input
// competitions = [
//   ["HTML", "C#"],
//   ["C#", "Python"],
//   ["Python", "HTML"],
// ]
// results = [0, 0, 1]
// Sample Output
// "Python"

import java.util.*;

class Program {
    // A win is worth 3 points.
    public static final int POINTS_FOR_WIN = 3;
    // In the results array, 1 means the home team won.
    public static final int HOME_TEAM_WON = 1;

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Use a HashMap to store team scores. The key is the team name (String),
        // and the value is their score (Integer).
        Map<String, Integer> scores = new HashMap<>();

        // This string will always hold the name of the team with the highest score so
        // far.
        String currentBestTeam = "";
        // Initialize the map with an entry for the best team to avoid errors on the
        // first check.
        scores.put(currentBestTeam, 0);

        // Loop through all the competitions.
        for (int i = 0; i < competitions.size(); i++) {
            // Get the current competition and its result.
            ArrayList<String> competition = competitions.get(i);
            int result = results.get(i);

            // Extract the names of the home and away teams.
            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            // Determine the winning team for this match.
            // If result is 1, home team won; otherwise, away team won.
            String winningTeam = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;

            // Update the winner's score.
            // 'getOrDefault' safely gets the current score or 0 if the team isn't in the
            // map yet.
            int newScore = scores.getOrDefault(winningTeam, 0) + POINTS_FOR_WIN;
            scores.put(winningTeam, newScore);

            // Check if this winner is now the new best team.
            if (newScore > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }

        return currentBestTeam;
    }
}
