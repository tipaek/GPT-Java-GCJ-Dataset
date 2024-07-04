import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            String y = "";
            int jam = 0;
            int cam = 0;
            int n = scan.nextInt();
            boolean poss = true;
            int[][] sced = new int[n][2];
            for (int j = 0; j < n; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                sced[j][0] = start;
                sced[j][1] = end;
            }
            Arrays.sort(sced, (a,b) -> Double.compare(a[0], b[0]));

            for (int j = 0; j < n; j++) {
                int start = sced[j][0];
                int end = sced[j][1];
                if (start >= cam) {
                    cam = end;
                    y += "C";
                } else if (start >= jam) {
                    jam = end;
                    y += "J";
                } else {
                    poss = false;
                }
            }
            if (!poss) y = "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + y);
        }
    }
}
