import java.util.*;

import java.io.*;

class Solution {
    
    public static boolean[] cAval = new boolean [1440];
    public static boolean[] jAval = new boolean [1440];
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            Arrays.fill(cAval, true);
            Arrays.fill(jAval, true);
            int jobs = in.nextInt();
            
            String ans  = "";
            
            for (int j=0; j<jobs; j++) {
                int m = in.nextInt();
                int n = in.nextInt();
                String currentAssignment = assignSlot(m, n);
                if (currentAssignment.equals("IMPOSSIBLE")) {
                    ans = "IMPOSSIBLE";
                    break;
                }
                ans += currentAssignment;
            }           
            System.out.println("Case #" + i + ": " + ans);
        }
        return;
        
    }

    public static String assignSlot(int start, int end) {

        if (!notAvailable(cAval, start, end)) {
            Arrays.fill(cAval, start, end, false);
            return "C";
        }
        if (!notAvailable(jAval, start, end)) {
            Arrays.fill(jAval, start, end, false);
            return "J";
        }
        return "IMPOSSIBLE";

    }

    public static boolean notAvailable(boolean[] arr, int start, int end) {
        for (int i=start; i<end; i++) {
            if (!arr[i]) {
                return true;
            }
        }
        return false;
    }

}
