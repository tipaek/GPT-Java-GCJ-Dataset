import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int R = in.nextInt();
            int S = in.nextInt();

            int count = (R-1)*(S-1);
            System.out.println("Case #" + t + ": " + count);
            sort(R, S);
        }
    }

    public static void sort(int R, int S) {
        int sorted = 0;
        int C = R * S;
        for (int r = R; r > 1; r--) {
            sorted++;
            for (int s = S-1; s > 0; s--) {
                int b = r-1;
                int a = C - sorted - b;
                System.out.println(a + " " + b);
                sorted++;
            }
        }
    }
}
