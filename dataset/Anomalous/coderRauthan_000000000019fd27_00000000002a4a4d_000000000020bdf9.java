import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int tasks = scanner.nextInt();
            StringBuilder ans = new StringBuilder();

            String[] tasksList = new String[tasks];
            Set<Integer> cMinutes = new HashSet<>();
            Set<Integer> jMinutes = new HashSet<>();
            Set<Integer> startingAndEndingC = new HashSet<>();
            Set<Integer> startingAndEndingJ = new HashSet<>();

            for (int j = 0; j < tasks; j++) {
                int startingTime = scanner.nextInt();
                int endingTime = scanner.nextInt();
                tasksList[j] = startingTime + "-" + endingTime;
            }

            boolean possible = true;

            for (String task : tasksList) {
                String[] times = task.split("-");
                int startingTime = Integer.parseInt(times[0]);
                int endingTime = Integer.parseInt(times[1]);

                if (assignTask(startingTime, endingTime, cMinutes, startingAndEndingC)) {
                    ans.append("C");
                } else if (assignTask(startingTime, endingTime, jMinutes, startingAndEndingJ)) {
                    ans.append("J");
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + ans.toString());
            }
        }
    }

    private static boolean assignTask(int startingTime, int endTime, Set<Integer> minutesSet, Set<Integer> startEndSet) {
        for (int i = startingTime; i <= endTime; i++) {
            if (minutesSet.contains(i)) {
                return false;
            }
        }

        if (startEndSet.contains(startingTime) && startEndSet.contains(endTime)) {
            return false;
        }

        startEndSet.add(startingTime);
        startEndSet.add(endTime);

        for (int i = startingTime + 1; i < endTime; i++) {
            minutesSet.add(i);
        }
        return true;
    }
}