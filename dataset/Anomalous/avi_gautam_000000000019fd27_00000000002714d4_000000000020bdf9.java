import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Read number of test cases

        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] timing = new int[N][2];

            in.nextLine(); // Consume the remaining newline
            for (int r = 0; r < N; r++) {
                String[] rowRead = in.nextLine().split(" ");
                timing[r][0] = Integer.parseInt(rowRead[0]);
                timing[r][1] = Integer.parseInt(rowRead[1]);
            }
            sortArray(timing);
            System.out.println("Case #" + i + ": " + scheduleActivities(timing, N));
        }
    }

    public static void sortArray(int[][] array) {
        Arrays.sort(array, Comparator.comparingInt(e -> e[0]));
    }

    public static String scheduleActivities(int[][] activities, int N) {
        int cEnd = 0, jEnd = 0, maxEndTimeIndex = 0;
        StringBuilder schedule = new StringBuilder();
        String currentPerson = "J";
        schedule.append(currentPerson);

        if (N == 2) {
            return "JJ";
        }

        for (int i = 0; i < N - 1; i++) {
            if (activities[maxEndTimeIndex][1] > activities[i + 1][0] && maxEndTimeIndex < N) {
                if (cEnd > activities[i + 1][0] && jEnd > activities[i + 1][0]) {
                    return "IMPOSSIBLE";
                } else if (cEnd <= activities[i + 1][0]) {
                    cEnd = activities[i + 1][1];
                    currentPerson = "C";
                } else {
                    jEnd = activities[i + 1][1];
                    currentPerson = "J";
                }
                jEnd = activities[maxEndTimeIndex][1];
            } else {
                currentPerson = "J";
            }

            if (activities[i][1] < activities[i + 1][1]) {
                maxEndTimeIndex = i + 1;
            }
            schedule.append(currentPerson);
        }
        return schedule.toString();
    }
}