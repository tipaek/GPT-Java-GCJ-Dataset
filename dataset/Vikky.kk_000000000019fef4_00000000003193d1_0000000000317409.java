import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int t_i = 1; t_i <= test; ++t_i) {
            int X = 0, Y = 0, M_SIZE;
            String sans = "IMPOSSIBLE", tour;
            StringTokenizer token = new StringTokenizer(br.readLine());
            X = Integer.parseInt(token.nextToken());
            Y = Integer.parseInt(token.nextToken());
            tour = token.nextToken();
            M_SIZE = tour.length();
            for (int i = 0; i < M_SIZE; ++i) {
                switch (tour.charAt(i)) {
                    case 'S':
                        Y--;
                        break;
                    case 'N':
                        Y++;
                        break;
                    case 'E':
                        X++;
                        break;
                    case 'W':
                        X--;
                        break;
                }
                if (Math.abs(X) + Math.abs(Y) <= i + 1) {
                    sans = "" + (i + 1);
                    break;
                }
            }

            sb.append("Case #" + t_i + ": " + sans + "\n");
        }

        System.out.print(sb.toString());
    }
}
