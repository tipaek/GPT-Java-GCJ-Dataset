import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                String[] times = reader.readLine().split("\\s+");
                startTimes[i] = Integer.parseInt(times[0]);
                endTimes[i] = Integer.parseInt(times[1]);
                assignments[i] = '\0';
            }

            boolean possible = true;
            for (int i = 0; i < n && possible; i++) {
                assignments[i] = 'C';
                for (int j = 0; j < i; j++) {
                    if (assignments[j] == 'C' && overlap(startTimes[j], endTimes[j], startTimes[i], endTimes[i])) {
                        assignments[i] = 'J';
                        break;
                    }
                }

                if (assignments[i] == 'J') {
                    for (int j = 0; j < i; j++) {
                        if (assignments[j] == 'J' && overlap(startTimes[j], endTimes[j], startTimes[i], endTimes[i])) {
                            possible = false;
                            break;
                        }
                    }
                }
            }

            if (possible) {
                System.out.print("Case #" + t + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean overlap(int start1, int end1, int start2, int end2) {
        return (start1 < start2 && end1 > start2) || (start2 < start1 && end2 > start1);
    }
}