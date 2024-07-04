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
                if (c[start] == 0 && c[end-1] == 0) {
                    answer.append("C");
                    for (int k = start; k < end; k++) {
                        c[k] = 1;
                    }
                } else if (j[start] == 0 && j[end-1] == 0) {
                    answer.append("J");
                    for (int k = start; k < end; k++) {
                        j[k] = 1;
                    }
                } else {
                    possible = false;
                }
            }

            String result = possible ? answer.toString() : "IMPOSSIBLE";

            System.out.println("Case #" + i + ": " + result);
        }
    }
}
    