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
            while (fromTimeArr.size()>0) {
                int index = fromTimeArr.indexOf(Collections.min(fromTimeArr));    
                int fromTimeValue = fromTimeArr.remove(index);
                int toTimeValue = toTimeArr.remove(index);
                if (C <= fromTimeValue) {
                    C = toTimeValue;
                    text += "C";
                } else if (J <= fromTimeValue) {
                    J = toTimeValue;
                    text += "J";
                } else {
                    text = "IMPOSSIBLE";
                    break;
                }
                
            }
            System.out.println("Case #" + k + ": " + text);
        
        }
    }
}