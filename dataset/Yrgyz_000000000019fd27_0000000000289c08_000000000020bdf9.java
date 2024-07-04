import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int start, end;
        for (int i = 1; i <= t; ++i) {
            
            int[] c = new int[1441];
            int[] j = new int[1441];
            int n = in.nextInt();
            StringBuilder answer = new StringBuilder();
            boolean possible = true;
            while (n > 0) {
                start = in.nextInt();
                end = in.nextInt();
                n--;
                if (!possible) continue;
                boolean canC = true;
                for (int l = start; l < end; l++) {
                    if (c[l] != 0) {
                        canC = false;
                        break;
                    }
                }
                if (canC) {
                    answer.append("C");
                    for (int k = start; k < end; k++) {
                        c[k] = 1;
                    }
                    continue;
                }
                boolean canJ = true;
                for (int l = start; l < end; l++) {
                    if (j[l] != 0) {
                        canJ = false;
                        break;
                    }
                }
                if (canJ) {
                    answer.append("J");
                    for (int k = start; k < end; k++) {
                        j[k] = 1;
                    }
                    continue;
                }
                possible = false;
            }

            String result = possible ? answer.toString() : "IMPOSSIBLE";

            System.out.println("Case #" + i + ": " + result);
        }
    }
}