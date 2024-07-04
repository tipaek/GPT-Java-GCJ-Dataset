import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RP
 */
public class Solution {
    

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        // For each test case
        for (int i = 1; i <= t; ++i) {
            int numActivities = in.nextInt();
            List<Integer> beginTimes = new ArrayList();
            List<Integer> endTimes = new ArrayList();
            for(int j = 0; j<numActivities;j++) {
                beginTimes.add(in.nextInt());
                endTimes.add(in.nextInt());
            }
            System.out.println("Case #" + i + ": " + solve(beginTimes,endTimes));
        }

    }
    

    public static String solve(List<Integer> beginTimes,
            List<Integer> endTimes) {
        
        int dimension = beginTimes.size();
        
        String result = new String();
        
        result = result.concat("C");
        
        
        
        for(int i = 1;i<dimension;i++) {
            // if the next task begins after current ends, keep Cameron on it
            if(beginTimes.get(i) > endTimes.get(i-1)) {
                result = result.concat("C");
            }
            // if the next task begins before current ends, put Jamie on it
            if(beginTimes.get(i) < endTimes.get(i-1)) {
                result = result.concat("J");
            }
        }
        
        return result;
    }

}