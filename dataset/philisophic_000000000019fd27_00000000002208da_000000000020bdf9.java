import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();

            int[][] times = new int[N][3];
            for (int i = 0; i < N; i++) {
                times[i][0] = in.nextInt();
                times[i][1] = in.nextInt();
                times[i][2] = i;
            }
            Arrays.sort(times, (a, b) -> a[0] - b[0]);

            boolean possible = true;
            int camEndTime = -1;
            int jamEndTime = -1;
            char[] solution = new char[N];

            for (int i = 0; i < N && possible; i++) {
                int start = times[i][0];
                int end = times[i][1];
                int index = times[i][2];
                
                if (start >= camEndTime) {
                    camEndTime = end;
                    solution[index] = 'C';
                } else if (start >= jamEndTime) {
                    jamEndTime = end;
                    solution[index] = 'J';
                } else {
                    possible = false;
                }
            }

            String output = "Case " + testCase + ": ";
            if (possible) {
                output += String.valueOf(solution);
            } else {
                output += "IMPOSSIBLE";
            }
            System.out.println(output);
        }

        in.close();
    }
}