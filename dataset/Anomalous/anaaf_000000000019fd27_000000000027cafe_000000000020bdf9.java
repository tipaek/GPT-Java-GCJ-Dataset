import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 

        for (int k = 1; k <= t; k++) {
            int activities = in.nextInt();
            int[][] slots = new int[activities][2];
            StringBuilder outputStr = new StringBuilder();
            
            for (int i = 0; i < activities; i++) {
                slots[i][0] = in.nextInt();
                slots[i][1] = in.nextInt();
            }

            int[] cEnd = new int[1];
            int[] jEnd = new int[1];
            boolean possible = true;

            for (int i = 0; i < activities; i++) {
                int start = slots[i][0];
                int end = slots[i][1];

                if (start >= cEnd[0]) {
                    cEnd[0] = end;
                    outputStr.append('C');
                } else if (start >= jEnd[0]) {
                    jEnd[0] = end;
                    outputStr.append('J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + k + ": " + outputStr.toString());
            }
        }
    }
}