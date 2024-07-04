import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            boolean[] C = new boolean[60 * 24];
            boolean[] J = new boolean[60 * 24];
            int N = Integer.parseInt(br.readLine().trim());
            int[][] intervals = new int[N][2];
            boolean impossible = false;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().trim().split("\\s+");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            for (int i = 0; i < N; i++) {
                boolean conflictC = false;
                for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                    if (C[j]) {
                        conflictC = true;
                        break;
                    }
                }

                if (conflictC) {
                    boolean conflictJ = false;
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (J[j]) {
                            conflictJ = true;
                            break;
                        }
                    }

                    if (conflictJ) {
                        impossible = true;
                        break;
                    } else {
                        result.append("J");
                        for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                            J[j] = true;
                        }
                    }
                } else {
                    result.append("C");
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        C[j] = true;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }
}