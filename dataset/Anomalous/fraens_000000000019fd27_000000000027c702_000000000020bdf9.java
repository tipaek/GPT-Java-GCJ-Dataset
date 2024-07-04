import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static int[][] readInputActivities(Scanner scanner) {
        int numberOfActivities = scanner.nextInt();
        int[][] activities = new int[numberOfActivities][4];
        
        for (int i = 0; i < numberOfActivities; i++) {
            activities[i][0] = i; // Original index
            activities[i][3] = 0; // Default assignment (Cameron)
        }

        for (int i = 0; i < numberOfActivities; i++) {
            activities[i][1] = scanner.nextInt(); // Start time
            activities[i][2] = scanner.nextInt(); // End time
        }
        return activities;
    }

    public static int[][] assignActivities(int[][] activities, int numberOfActivities) {
        int endJamie = 0;
        int endCameron = activities[0][2];

        for (int i = 1; i < numberOfActivities; i++) {
            if (endCameron <= activities[i][1]) {
                endCameron = activities[i][2];
            } else if (endJamie <= activities[i][1]) {
                activities[i][3] = 1; // Assign to Jamie
                endJamie = activities[i][2];
            } else {
                return null; // Impossible to assign
            }
        }
        return activities;
    }

    public static int[][] sortActivities(int[][] activities, int column) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a[column]));
        return activities;
    }

    public static String activitiesToString(int[][] activities, int numberOfActivities) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numberOfActivities; i++) {
            result.append(activities[i][3] == 0 ? "C" : "J");
        }
        return result.toString();
    }

    public static List<int[][]> readAllTestCases(Scanner scanner) {
        List<int[][]> testCases = new ArrayList<>();
        int numberOfTestCases = scanner.nextInt();
        
        for (int i = 0; i < numberOfTestCases; i++) {
            testCases.add(readInputActivities(scanner));
        }
        return testCases;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<int[][]> testCases = readAllTestCases(scanner);
        int caseNumber = 1;

        for (int[][] activities : testCases) {
            String result = "Case #" + caseNumber + ": ";
            activities = sortActivities(activities, 1);
            activities = assignActivities(activities, activities.length);

            if (activities == null) {
                result += "IMPOSSIBLE";
            } else {
                activities = sortActivities(activities, 0);
                result += activitiesToString(activities, activities.length);
            }
            System.out.println(result);
            caseNumber++;
        }
    }
}