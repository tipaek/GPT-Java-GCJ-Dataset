import javafx.util.Pair;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int n = 0; n < t; n++) {
            solveProblem(scanner, n + 1);
        }
    }

    public static void solveProblem(Scanner scanner, int caseNumber) {
        int numActivities = scanner.nextInt();
        TreeMap<Integer, Pair<Integer, Integer>> activities = new TreeMap<>();
        char[] schedule = new char[numActivities];
        boolean isPossible = true;

        for (int i = 0; i < numActivities; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            activities.put(startTime, new Pair<>(endTime, i));
        }

        int cEndTime = 0;
        int jEndTime = 0;

        for (Map.Entry<Integer, Pair<Integer, Integer>> entry : activities.entrySet()) {
            int startTime = entry.getKey();
            int endTime = entry.getValue().getKey();
            int index = entry.getValue().getValue();

            if (startTime >= cEndTime) {
                schedule[index] = 'C';
                cEndTime = endTime;
            } else if (startTime >= jEndTime) {
                schedule[index] = 'J';
                jEndTime = endTime;
            } else {
                isPossible = false;
                break;
            }
        }

        String result = isPossible ? new String(schedule) : "IMPOSSIBLE";
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}