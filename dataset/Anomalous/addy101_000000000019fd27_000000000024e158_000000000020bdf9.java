import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        for (int x = 0; x < t; x++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] parts = br.readLine().trim().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int endC = 0, endJ = 0;
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int[] interval : intervals) {
                if (endC <= interval[0]) {
                    endC = interval[1];
                    result.append('C');
                } else if (endJ <= interval[0]) {
                    endJ = interval[1];
                    result.append('J');
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.print("Case #" + (x + 1) + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }
}