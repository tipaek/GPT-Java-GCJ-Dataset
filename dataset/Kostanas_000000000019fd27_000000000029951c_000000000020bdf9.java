import java.util.*;
import java.io.*;
public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            
            ArrayList<Integer> fromTimeArr = new ArrayList<Integer>();
            ArrayList<Integer> toTimeArr = new ArrayList<Integer>();
            String[] flowActivities = new String[n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    int time = in.nextInt();
                    if (j == 0) {
                        fromTimeArr.add(time);
                    } else {
                        toTimeArr.add(time);
                    }
                    
                }
            }
            
            int C = 0;
            int J = 0;
            String text = "";
            int count = n;
            while (count>0) {
                int index = fromTimeArr.indexOf(Collections.min(fromTimeArr));    
                int fromTimeValue = fromTimeArr.get(index);
                fromTimeArr.set(index, 100000);
                int toTimeValue = toTimeArr.get(index);
                if (C <= fromTimeValue) {
                    C = toTimeValue;
                    flowActivities[index] = "C";
                } else if (J <= fromTimeValue) {
                    J = toTimeValue;
                    flowActivities[index] = "J";
                } else {
                    text = "IMPOSSIBLE";
                    break;
                }
                count--;
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < flowActivities.length; i++) {
                sb.append(flowActivities[i]);
            }
            if (text != "IMPOSSIBLE") {
                text = sb.toString();    
            }
            
            
            System.out.println("Case #" + k + ": " + text);
        
        }
    }
}