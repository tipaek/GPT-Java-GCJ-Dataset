import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] m = new int[n][4];

            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                m[i][0] = Integer.parseInt(str.nextToken());
                m[i][1] = Integer.parseInt(str.nextToken());
                m[i][2] = i;
            }

            Arrays.sort(m, Comparator.comparingInt(entry -> entry[0]));

            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;
            m[0][3] = 1;
            cEnd = m[0][1];

            for (int i = 1; i < n; i++) {
                if (m[i][0] >= cEnd) {
                    cEnd = m[i][1];
                    m[i][3] = 1;
                } else if (m[i][0] >= jEnd) {
                    jEnd = m[i][1];
                    m[i][3] = 2;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                out.println("Case #" + tc + ": IMPOSSIBLE");
            } else {
                Arrays.sort(m, Comparator.comparingInt(entry -> entry[2]));
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(m[i][3] == 1 ? 'C' : 'J');
                }
                out.println("Case #" + tc + ": " + result);
            }
        }

        out.flush();
        out.close();
    }
}