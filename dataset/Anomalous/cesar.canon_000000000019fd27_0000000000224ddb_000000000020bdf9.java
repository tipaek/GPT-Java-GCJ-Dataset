import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int cases = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < cases; i++) {
            boolean[] occupiedByC = new boolean[1440];
            boolean[] occupiedByJ = new boolean[1440];
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            int activities = Integer.parseInt(bf.readLine());
            
            for (int j = 0; j < activities; j++) {
                String[] intervals = bf.readLine().split(" ");
                int start = Integer.parseInt(intervals[0]);
                int end = Integer.parseInt(intervals[1]);
                
                boolean canAssignToC = true;
                boolean canAssignToJ = true;
                
                for (int k = start; k < end; k++) {
                    if (occupiedByC[k]) {
                        canAssignToC = false;
                    }
                    if (occupiedByJ[k]) {
                        canAssignToJ = false;
                    }
                }
                
                if (canAssignToC) {
                    for (int k = start; k < end; k++) {
                        occupiedByC[k] = true;
                    }
                    result.append("C");
                } else if (canAssignToJ) {
                    for (int k = start; k < end; k++) {
                        occupiedByJ[k] = true;
                    }
                    result.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}