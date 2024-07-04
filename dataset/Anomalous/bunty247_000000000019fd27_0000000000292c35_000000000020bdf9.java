package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class ParentingPartneringReturns {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= num; testCase++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] jobs = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] input = bufferedReader.readLine().split(" ");
                jobs[i][0] = Integer.parseInt(input[0]);
                jobs[i][1] = Integer.parseInt(input[1]);
            }

            Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

            StringBuilder result = new StringBuilder("C");
            int endTimeC = jobs[0][1], endTimeJ = -1;
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                if (endTimeJ <= jobs[i][0] && endTimeC > jobs[i][0]) {
                    result.append('J');
                    endTimeJ = jobs[i][1];
                } else if (endTimeC <= jobs[i][0]) {
                    result.append('C');
                    endTimeC = jobs[i][1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }
}