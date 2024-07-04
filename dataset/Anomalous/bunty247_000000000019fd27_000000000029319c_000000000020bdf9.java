import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] jobs = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] jobDetails = bufferedReader.readLine().split(" ");
                jobs[i][0] = Integer.parseInt(jobDetails[0]);
                jobs[i][1] = Integer.parseInt(jobDetails[1]);
            }

            Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

            StringBuilder result = new StringBuilder();
            int endTimeCameron = 0, endTimeJamie = 0;
            boolean possible = true;

            for (int[] job : jobs) {
                if (job[0] >= endTimeCameron) {
                    result.append('C');
                    endTimeCameron = job[1];
                } else if (job[0] >= endTimeJamie) {
                    result.append('J');
                    endTimeJamie = job[1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}