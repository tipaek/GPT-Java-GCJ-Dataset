import java.util.*;
import java.io.*;

public class Solution implements Comparable<Solution> {
    
    int starttime;
    int endtime;
    
    public Solution(int s, int e) {
        starttime = s;
        endtime = e;
    }
    
    public int compareTo(Solution other) {
        Integer one = new Integer(this.starttime);
        Integer two = new Integer(other.starttime);
        return one.compareTo(two);
    }
    
    // Assuming I can read in all of the input (leave that for last)

    // n = number of activities to cover
    public static String getCoverage(Solution[] times) {
        Arrays.sort(times);

        String builder = "";

        Solution cameron = null;
        Solution jamie = null;

        for(int i = 0; i < times.length; i++) {
            // Check to see if we can free up any availability
            if(cameron != null && cameron.endtime <= times[i].starttime) {
                cameron = null;
            }
                
            if (jamie != null && jamie.endtime <= times[i].starttime) {
                jamie = null;
            }
            
            if(cameron == null) {
                cameron = times[i];
                builder = builder + "C";
            } else if (jamie == null) {
                jamie = times[i];
                builder = builder + "J";
            } else { // couldn't free anyone
                return null;
            }
        }

        return builder;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        
        for (int x = 1; x <= testCases; x++) {
            String answer = "Case #" + x + ": ";
            
            // Create the intervals
            int n = in.nextInt();
            Solution[] times = new Solution[n];
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                
                times[i] = new Solution(s,e);
            }
            
            String result = getCoverage(times);
            
            if (result == null)
                answer = answer + "IMPOSSIBLE";
            else
                answer = answer + result;
            
            System.out.println(answer);
        }
        
        in.close();
    }
}