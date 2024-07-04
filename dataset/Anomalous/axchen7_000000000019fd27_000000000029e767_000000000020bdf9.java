import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int c = 1; c <= t; c++) {
            int n = scanner.nextInt();
            int[][] events = new int[n * 2][3]; // [time, index, type (start=0, end=1)]
            for (int i = 0; i < n; i++) {
                events[i * 2][0] = scanner.nextInt();
                events[i * 2][1] = i;
                events[i * 2][2] = 0;
                events[i * 2 + 1][0] = scanner.nextInt();
                events[i * 2 + 1][1] = i;
                events[i * 2 + 1][2] = 1;
            }
            Arrays.sort(events, (event1, event2) -> {
                if (event1[0] == event2[0]) return event2[2] - event1[2];
                return event1[0] - event2[0];
            });

            boolean[] assignments = new boolean[n]; // true=C, false=J
            boolean cFree = true;
            boolean jFree = true;
            boolean possible = true;

            for (int[] event : events) {
                int time = event[0];
                int index = event[1];
                int type = event[2];

                if (type == 0) { // start
                    if (cFree) {
                        cFree = false;
                        assignments[index] = true;
                    } else if (jFree) {
                        jFree = false;
                        assignments[index] = false;
                    } else {
                        possible = false;
                        break;
                    }
                } else { // end
                    if (assignments[index]) {
                        cFree = true;
                    } else {
                        jFree = true;
                    }
                }
            }
            System.out.print("Case #" + c + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (boolean assignment : assignments) {
                    result.append(assignment ? 'C' : 'J');
                }
                System.out.println(result);
            }
        }
    }
}