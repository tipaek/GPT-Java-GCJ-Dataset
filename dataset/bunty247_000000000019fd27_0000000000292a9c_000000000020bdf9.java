package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ParentingPartneringReturns {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= num; testCase++) {

            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] jobs = new int[n][2];
            for (int i = 0; i < n; i++)
                jobs[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
            StringBuilder res = new StringBuilder("C");
            int endTimeC = jobs[0][1], endTimeJ = -1;

            for (int i = 1; i < n; i++) {

                if(endTimeJ <= jobs[i][0] && endTimeC > jobs[i][0]) {
                    res.append('J');
                    endTimeJ = jobs[i][1];
                }
                else if (endTimeC <= jobs[i][0]){
                    res.append('C');
                    endTimeC = jobs[i][1];
                }
                else {
                    res = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + res.toString());
        }
    }
}
