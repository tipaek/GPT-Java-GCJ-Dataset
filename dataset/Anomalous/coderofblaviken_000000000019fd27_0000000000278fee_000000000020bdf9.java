import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int i = 1; i <= numTestCases; i++) {
            int N = scanner.nextInt();
            ArrayList<Activity> activities = new ArrayList<>(N);

            for (int j = 0; j < N; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            String result = findSchedule(N, activities);
            System.out.printf("Case #%d: %s\n", i, result);
        }
        scanner.close();
    }

    private static String findSchedule(int N, ArrayList<Activity> activities) {
        ArrayList<String> permutations = generatePermutations(N);
        for (String permutation : permutations) {
            if (isValidSchedule(permutation, activities)) {
                return permutation;
            }
        }
        return "IMPOSSIBLE";
    }

    private static ArrayList<String> generatePermutations(int N) {
        ArrayList<String> permutations = new ArrayList<>((int) Math.pow(2, N));
        for (int j = 0; j < (int) Math.pow(2, N); j++) {
            String binary = String.format("%" + N + "s", Integer.toBinaryString(j)).replace(" ", "0");
            StringBuilder permutation = new StringBuilder();
            for (int k = 0; k < binary.length(); k++) {
                permutation.append(binary.charAt(k) == '1' ? "J" : "C");
            }
            permutations.add(permutation.toString());
        }
        return permutations;
    }

    private static boolean isValidSchedule(String schedule, ArrayList<Activity> activities) {
        for (int j = 0; j < schedule.length(); j++) {
            char currentChar = schedule.charAt(j);
            Activity currentActivity = activities.get(j);
            for (int k = j + 1; k < schedule.length(); k++) {
                if (schedule.charAt(k) == currentChar && activities.get(k).overlapsWith(currentActivity)) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Activity {
    private final int start;
    private final int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlapsWith(Activity other) {
        return (other.start > this.start && other.start < this.end) || (this.start > other.start && this.start < other.end);
    }
}