import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());

            for (int t = 0; t < testCases; t++) {
                int n = Integer.parseInt(scanner.nextLine());
                int[][] intervals = new int[n][2];
                boolean[] assigned = new boolean[n];
                char[] schedule = new char[n];
                boolean impossible = false;
                int cameronEnd = 0;
                int jamieEnd = 0;

                for (int i = 0; i < n; i++) {
                    String[] input = scanner.nextLine().split(" ");
                    intervals[i][0] = Integer.parseInt(input[0]);
                    intervals[i][1] = Integer.parseInt(input[1]);
                }

                for (int i = 0; i < n; i++) {
                    int earliestStart = Integer.MAX_VALUE;
                    int index = -1;

                    for (int j = 0; j < n; j++) {
                        if (!assigned[j] && intervals[j][0] < earliestStart) {
                            earliestStart = intervals[j][0];
                            index = j;
                        }
                    }

                    if (index == -1) break;

                    if (intervals[index][0] >= cameronEnd) {
                        cameronEnd = intervals[index][1];
                        schedule[index] = 'C';
                    } else if (intervals[index][0] >= jamieEnd) {
                        jamieEnd = intervals[index][1];
                        schedule[index] = 'J';
                    } else {
                        impossible = true;
                        break;
                    }

                    assigned[index] = true;
                }

                if (impossible) {
                    System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + (t + 1) + ": " + new String(schedule));
                }
            }
        }
    }
}