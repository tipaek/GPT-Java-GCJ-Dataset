import java.util.*;

import java.io.*;
import java.lang.*;

public class Solution {
    public static String cTimeStr = "";
    public static String jTimeStr = "";
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            //Arrays.fill(cAval, Boolean.TRUE);
            int jobs = in.nextInt();
            cTimeStr = new String(new char[1440]).replace("\0", "0");
            jTimeStr = new String(new char[1440]).replace("\0", "0");
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
        
    }

    public static String assignSlot(int start, int end) {
    
        
        if ( !cTimeStr.substring(start, end).contains("1") ) {
            StringBuffer buf = new StringBuffer(cTimeStr);
            String replaceString = new String(new char[end-start]).replace("\0", "1");
        
            buf.replace(start, end, replaceString);
            cTimeStr = buf.toString();
            return "C";
        }
        if (!jTimeStr.substring(start, end).contains("1")) {
            StringBuffer buf = new StringBuffer(jTimeStr);
            String replaceString = new String(new char[end-start]).replace("\0", "1");
            buf.replace(start, end, replaceString);
            jTimeStr = buf.toString();
            return "J";
        }
        
        return "IMPOSSIBLE";
    }
}
