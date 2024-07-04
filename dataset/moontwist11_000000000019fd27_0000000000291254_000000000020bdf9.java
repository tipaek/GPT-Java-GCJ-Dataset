import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = Integer.parseInt(input.nextLine());
        
        for(int i = 0; i < numTests; i++) {
            int n = Integer.parseInt(input.nextLine());
            
            //Get arrays of start and end times
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] index = new int[n]; //Will keep track of original index of everything
            for(int j = 0; j < n; j++) {
                String[] line = input.nextLine().split(" ");
                startTimes[j] = Integer.parseInt(line[0]);
                endTimes[j] = Integer.parseInt(line[1]);
                index[j] = j;
            }
            
            //Sort both arrays according to start times
            for(int j = 0; j < n; j++) {
                int min = startTimes[j];
                int minIndex = j;
                for(int k = j+1; k < n; k++) {
                    if(startTimes[k] < min) {
                        min = startTimes[k];
                        minIndex = k;
                    } else if(startTimes[k] == min && endTimes[k] < endTimes[minIndex]) {
                        min = startTimes[k];
                        minIndex = k;
                    }
                }
                
                //Swap
                int tmp = startTimes[j];
                startTimes[j] = startTimes[minIndex];
                startTimes[minIndex] = tmp;
                
                tmp = endTimes[j];
                endTimes[j] = endTimes[minIndex];
                endTimes[minIndex] = tmp;
                
                tmp = index[j];
                index[j] = index[minIndex];
                index[minIndex] = tmp;
            }
            
            String sol = solve(startTimes, endTimes, n);
            if(!sol.equals("IMPOSSIBLE")) {
                //Sort our string
                char[] c = new char[n];
                for(int j = 0; j < n; j++) {
                    c[index[j]] = sol.charAt(j);
                }
                sol = new String(c);
            }
            
            System.out.print("Case #" + (i+1) + ": ");
            System.out.print(sol);
            System.out.println();
        }
    }
    
    //Solve given both startTimes and endTimes are sorted
    public static String solve(int[] startTimes, int[] endTimes, int n) {
        String sol = "";
        
        boolean cAssigned = false;
        int lastCEnd = 0;
        boolean jAssigned = false;
        int lastJEnd = 0;
        
        for(int i = 0; i < n; i++) {
            if(lastCEnd <= startTimes[i]) cAssigned = false;
            if(lastJEnd <= startTimes[i]) jAssigned = false;
            
            if(!cAssigned) {
                cAssigned = true;
                lastCEnd = endTimes[i];
                sol += "C";
                continue;
            } 
            if(!jAssigned) {
                jAssigned = true;
                lastJEnd = endTimes[i];
                sol += "J";
                continue;
            }
            
            return "IMPOSSIBLE";
        }
        return sol;
    }
}