import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] jobs = new int[n][2];

            for (int i = 0; i < n; i++) {
                jobs[i] = Arrays.stream(reader.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            }

            StringBuilder result = new StringBuilder("C");
            int cStart = jobs[0][0], cEnd = jobs[0][1];
            int jStart = Integer.MAX_VALUE, jEnd = -1;

            boolean possible = true;

            for (int i = 1; i < n; i++) {
                int start = jobs[i][0];
                int end = jobs[i][1];

                if (start >= cEnd || (start < cStart && end <= cStart)) {
                    result.append('C');
                    cStart = start;
                    cEnd = end;
                } else if (start >= jEnd || (start < jStart && end <= jStart)) {
                    result.append('J');
                    jStart = start;
                    jEnd = end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + result.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}