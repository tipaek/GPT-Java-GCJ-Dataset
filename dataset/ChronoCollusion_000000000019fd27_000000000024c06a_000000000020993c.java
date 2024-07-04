import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int simX = 0;
            int simY = 0;

            HashMap<Integer, HashMap<Integer, Boolean>> xVal = new HashMap<Integer, HashMap<Integer, Boolean>>();
            HashMap<Integer, HashMap<Integer, Boolean>> yVal = new HashMap<Integer, HashMap<Integer, Boolean>>();

            for(int x = 0; x<n;x++) {
                for (int y=0; y<n; y++) {
                    int m = in.nextInt();
                    HashMap<Integer, Boolean> xvalues = xVal.containsKey(x)?xVal.get(x):new HashMap<Integer, Boolean>();
                    HashMap<Integer, Boolean> yvalues = xVal.containsKey(y)?yVal.get(y):new HashMap<Integer, Boolean>();

                    if(xvalues.containsKey(m)) {
                        simX++;
                    }else{
                        xvalues.put(m, true);
                    }

                    if(yvalues.containsKey(m)) {
                        simX++;
                    }else{
                        yvalues.put(m, true);
                    }
                }
            }

            System.out.println(String.format("Case #%s: %s %s %s", i,n,simX,simY));
        }
    }
}
  