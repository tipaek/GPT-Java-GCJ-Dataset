package CodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CJ20_ParetingPartneringReturns {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        outerLoop: for (int tt = 1; tt <= t; tt++) {
            int n = Integer.parseInt(br.readLine());

            int[][] schedule = new int[n][4];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                schedule[i][0] = Integer.parseInt(input[0]);
                schedule[i][1] = Integer.parseInt(input[1]);
                schedule[i][2] = i;
            }

            Arrays.sort(schedule, (a, b) -> Integer.compare(a[0], b[0]));

            int cameronEnd = 0;
            int jamieEnd = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int start = schedule[i][0];
                int end = schedule[i][1];

                if (cameronEnd <= start) {
                    schedule[i][3] = 0;
                    cameronEnd = end;
                } else if (jamieEnd <= start) {
                    schedule[i][3] = 1;
                    jamieEnd = end;
                } else {
                    bw.write("Case #" + tt + ": IMPOSSIBLE\n");
                    continue outerLoop;
                }
            }

            Arrays.sort(schedule, (a, b) -> Integer.compare(a[2], b[2]));

            for (int i = 0; i < n; i++) {
                result.append(schedule[i][3] == 0 ? 'C' : 'J');
            }

            bw.write("Case #" + tt + ": " + result.toString() + "\n");
        }

        bw.flush();
    }
}