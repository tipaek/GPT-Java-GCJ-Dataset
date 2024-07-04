

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String path = in.nextLine();
            boolean impos = true;
            int m;
            for (m = 1; m < path.length(); m++) {
                if (path.charAt(m) == 'N') {
                    Y++;
                }
                if (path.charAt(m) == 'S') {
                    Y--;
                }
                if (path.charAt(m) == 'E') {
                    X++;
                }
                if (path.charAt(m) == 'W') {
                    X--;
                }
                if (Math.abs(X) + Math.abs(Y) <= m) {
                    impos = false;
                    break;
                }
            }
            if (impos) {
                out.write(String.format("Case #%d: IMPOSSIBLE\n", t + 1));
            } else {
                out.write(String.format("Case #%d: %d\n", t + 1, m));
            }
        }
        out.close();
        in.close();
    }

}
