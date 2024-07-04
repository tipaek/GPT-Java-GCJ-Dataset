package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int jobCount = Integer.parseInt(bufferedReader.readLine());
            int[][] jobs = new int[jobCount][2];

            for (int i = 0; i < jobCount; i++) {
                jobs[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            }

            Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

            StringBuilder schedule = new StringBuilder("C");
            int endC = jobs[0][1];
            int endJ = -1;

            boolean possible = true;

            for (int i = 1; i < jobCount; i++) {
                int start = jobs[i][0];
                int end = jobs[i][1];

                if (endJ <= start && endC > start) {
                    schedule.append('J');
                    endJ = end;
                } else if (endC <= start) {
                    schedule.append('C');
                    endC = end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + schedule.toString());
            }
        }
    }
}