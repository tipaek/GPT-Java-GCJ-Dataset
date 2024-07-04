import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int start, end, index;
        String assignedTo;

        public Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            Pair[] pairs = new Pair[n + 1];
            pairs[0] = new Pair(0, 0, -1);
            for (int j = 1; j <= n; j++) {
                pairs[j] = new Pair(scanner.nextInt(), scanner.nextInt(), j);
            }
            Arrays.sort(pairs, (p1, p2) -> {
                if (p1.start != p2.start) {
                    return Integer.compare(p1.start, p2.start);
                }
                return Integer.compare(p1.end, p2.end);
            });
            System.out.println(assignTasks(pairs));
        }
    }

    private static String assignTasks(Pair[] pairs) {
        StringBuilder result;
        int lastCamIndex = 0, lastJamIndex = 0;
        boolean impossible = false;
        int n = pairs.length;

        for (int j = 1; j < n; j++) {
            if (pairs[j].start >= pairs[lastCamIndex].end || pairs[j].end <= pairs[lastCamIndex].start) {
                pairs[j].assignedTo = "C";
                lastCamIndex = j;
            } else if (pairs[j].start >= pairs[lastJamIndex].end || pairs[j].end <= pairs[lastJamIndex].start) {
                pairs[j].assignedTo = "J";
                lastJamIndex = j;
            } else {
                impossible = true;
                break;
            }
        }

        if (impossible) {
            result = new StringBuilder("IMPOSSIBLE");
        } else {
            String[] assignments = new String[n];
            assignments[0] = "";
            for (int i = 1; i < n; i++) {
                assignments[pairs[i].index] = pairs[i].assignedTo;
            }
            result = new StringBuilder();
            for (String assignment : assignments) {
                result.append(assignment);
            }
        }
        return result.toString();
    }
}