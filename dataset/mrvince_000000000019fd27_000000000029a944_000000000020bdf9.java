import java.util.*;
import java.io.*;

public class Solution implements Comparable<Solution> {
    
    int starttime;
    int endtime;
    int jobNum;
    
    public Solution(int s, int e, int j) {
        starttime = s;
        endtime = e;
        jobNum = j;
    }
    
    public int compareTo(Solution other) {
        Integer one = new Integer(this.starttime);
        Integer two = new Integer(other.starttime);
        return one.compareTo(two);
    }
    
    public static String getCoverage(Solution[] times) {
        Arrays.sort(times);
        char[] builder = new char[times.length];
        

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
                builder[cameron.jobNum] = 'C';
            } else if (jamie == null) {
                jamie = times[i];
                builder[jamie.jobNum] = 'J';
            } else { // couldn't free anyone
                return null;
            }
        }

        return new String(builder);
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
                
                times[i] = new Solution(s,e,i);
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