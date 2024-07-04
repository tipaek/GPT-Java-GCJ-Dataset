import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            int E = in.nextInt();
            int N = in.nextInt();
            String P = in.next();
            int result = -1;

            int d = Math.abs(E) + Math.abs(N);
            if (d == 0) {
                System.out.println("Case #" + tc + ": 0");
                continue;
            }

            for (int i=0; i<P.length(); i++) {
                if (P.charAt(i) == 'S') N--;
                else if (P.charAt(i) == 'N') N++;
                else if (P.charAt(i) == 'E') E++;
                else if (P.charAt(i) == 'W') E--;

                d = Math.abs(E) + Math.abs(N);
                if (d <= i + 1) {
                    result = i + 1;
                    break;
                }
            }

            if (result == -1) System.out.println("Case #" + tc + ": IMPOSSIBLE");
            else System.out.println("Case #" + tc + ": " + result);
        }
    }
}