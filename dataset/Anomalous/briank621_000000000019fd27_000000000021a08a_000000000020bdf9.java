import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(reader.readLine());
            int[] schedule = new int[2441];
            int[] assignment = new int[n + 1];

            boolean isPossible = true;

            for (int i = 1; i <= n; i++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                for (int j = start; j < end; j++) {
                    if (schedule[j] == -1) {
                        isPossible = false;
                    } else if (schedule[j] != 0) {
                        if (assignment[schedule[j]] == 0) {
                            assignment[i] = 1;
                        } else {
                            assignment[i] = 0;
                        }
                        schedule[j] = -1;
                    } else {
                        schedule[j] = i;
                    }
                }
            }

            if (!isPossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    result.append(assignment[i] == 0 ? "C" : "J");
                }
                System.out.printf("Case #%d: %s\n", caseNumber, result.toString());
            }
        }

        reader.close();
    }
}