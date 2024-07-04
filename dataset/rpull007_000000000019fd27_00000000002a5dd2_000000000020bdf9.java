
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
            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();
            for(int j = 0; j<numActivities;j++) {
                startTimes.add(in.nextInt());
                endTimes.add(in.nextInt());
            }
            System.out.println("Case #" + i + ": " + solve(startTimes,endTimes));
        }

    }
    

    public static String solve(List<Integer> startTimes,
            List<Integer> endTimes) {
        String result = "";
        
        int dim = startTimes.size();
        
        int camAvailableAtTime = 0;
        int jamAvailableAtTime = 0;
        
        
        for(int i = 0; i<dim; i++) {
            // If it's the first task, assign Cameron
            if(i == 0) {
                result = result.concat("C");
                camAvailableAtTime = endTimes.get(i);
                continue;
            }
            // Can we assign Cameron again?
            if(startTimes.get(i) >= camAvailableAtTime ) {
                result = result.concat("C");
                camAvailableAtTime = endTimes.get(i);
            } else if(startTimes.get(i) >= jamAvailableAtTime) {
                result = result.concat("J");
                jamAvailableAtTime = endTimes.get(i);
                        
            } else if (startTimes.get(i) < jamAvailableAtTime && 
                    startTimes.get(i) < camAvailableAtTime) {
                result = "IMPOSSIBLE";
                break;
            }
                
        }

        return result;
    }

}