import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            int numActivities = Integer.parseInt(reader.readLine());
            int[][] activities = new int[numActivities][3];
            char[] schedule = new char[numActivities];

            for (int i = 0; i < numActivities; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                activities[i][0] = Integer.parseInt(tokenizer.nextToken());
                activities[i][1] = Integer.parseInt(tokenizer.nextToken());
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int cEnd = 0;
            int jEnd = 0;
            boolean possible = true;

            for (int i = 0; i < numActivities; i++) {
                if (activities[i][0] >= cEnd) {
                    cEnd = activities[i][1];
                    schedule[activities[i][2]] = 'C';
                } else if (activities[i][0] >= jEnd) {
                    jEnd = activities[i][1];
                    schedule[activities[i][2]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (char c : schedule) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}