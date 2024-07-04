import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[][] intervals = new int[n][3];
            char[] assignedChars = new char[n];

            // Read the first interval
            String[] firstInterval = br.readLine().trim().split(" ");
            intervals[0][0] = Integer.parseInt(firstInterval[0]);
            intervals[0][1] = Integer.parseInt(firstInterval[1]);
            intervals[0][2] = 0;

            // Read and sort the rest of the intervals
            for (int i = 1; i < n; i++) {
                String[] interval = br.readLine().trim().split(" ");
                intervals[i][0] = Integer.parseInt(interval[0]);
                intervals[i][1] = Integer.parseInt(interval[1]);
                intervals[i][2] = i;

                // Insertion sort to maintain sorted order
                int keyStart = intervals[i][0];
                int keyEnd = intervals[i][1];
                int keyPos = intervals[i][2];
                int j = i - 1;

                while (j >= 0 && intervals[j][0] > keyStart) {
                    intervals[j + 1][0] = intervals[j][0];
                    intervals[j + 1][1] = intervals[j][1];
                    intervals[j + 1][2] = intervals[j][2];
                    j--;
                }
                intervals[j + 1][0] = keyStart;
                intervals[j + 1][1] = keyEnd;
                intervals[j + 1][2] = keyPos;
            }

            int posC = 0;
            int posJ = -1;
            assignedChars[intervals[0][2]] = 'C';
            boolean isPossible = true;

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= intervals[posC][1]) {
                    assignedChars[intervals[i][2]] = 'C';
                    posC = i;
                } else if (posJ == -1 || intervals[i][0] >= intervals[posJ][1]) {
                    assignedChars[intervals[i][2]] = 'J';
                    posJ = i;
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + testCase + ": ");
            if (isPossible) {
                System.out.println(new String(assignedChars));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}