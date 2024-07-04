import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Solution  {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= num; testCase++) {

            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] jobs = new int[n][2];
            for (int i = 0; i < n; i++)
                jobs[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            StringBuilder res = new StringBuilder("C");
            int startTimeC = jobs[0][0], endTimeC = jobs[0][1];
            int startTimeJ = Integer.MAX_VALUE, endTimeJ = -1;

            for (int i = 1; i < n; i++) {

                int currStartTime = jobs[i][0];
                int currEndTime = jobs[i][1];

                if(currStartTime >= endTimeC || (currStartTime < startTimeC && currEndTime <= startTimeC)) {
                    res.append('C');
                    endTimeC = currEndTime;
                    startTimeC = currStartTime;
                }
                else if (currStartTime >= endTimeJ || (currStartTime < startTimeJ && currEndTime <= startTimeJ)) {
                    res.append('J');
                    endTimeJ = currEndTime;
                    startTimeJ = currStartTime;
                }
                else
                    res = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + res.toString());
        }
    }
}
