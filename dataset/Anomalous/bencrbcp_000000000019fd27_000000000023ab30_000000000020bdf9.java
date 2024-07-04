import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int x = 0; x < cases; x++) {
            int tasks = Integer.parseInt(br.readLine());
            ArrayList<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < tasks; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                intervals.add(new int[]{start, end});
            }

            intervals.sort((a, b) -> a[0] - b[0]);

            ArrayList<int[]> cIntervals = new ArrayList<>();
            ArrayList<int[]> jIntervals = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            boolean possible = true;

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];

                if (cIntervals.isEmpty() || start >= cIntervals.get(cIntervals.size() - 1)[1]) {
                    cIntervals.add(interval);
                    result.append("C");
                } else if (jIntervals.isEmpty() || start >= jIntervals.get(jIntervals.size() - 1)[1]) {
                    jIntervals.add(interval);
                    result.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("CASE #" + (x + 1) + ": " + result.toString());
            } else {
                System.out.println("CASE #" + (x + 1) + ": IMPOSSIBLE");
            }
        }
    }
}