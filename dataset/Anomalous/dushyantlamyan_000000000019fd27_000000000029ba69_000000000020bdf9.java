import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            char[] assignments = new char[n];
            Arrays.fill(assignments, ' ');
            
            for (int j = 0; j < n; j++) {
                boolean assigned = false;
                for (int k = 0; k < j; k++) {
                    if (intervals[j][0] >= intervals[k][1] || intervals[j][1] <= intervals[k][0]) {
                        continue;
                    }
                    
                    if (assignments[k] == 'C') {
                        if (assignments[j] == ' ') {
                            assignments[j] = 'J';
                        } else if (assignments[j] == 'C') {
                            possible = false;
                            break;
                        }
                    } else if (assignments[k] == 'J') {
                        if (assignments[j] == ' ') {
                            assignments[j] = 'C';
                        } else if (assignments[j] == 'J') {
                            possible = false;
                            break;
                        }
                    }
                    assigned = true;
                }
                
                if (!assigned && assignments[j] == ' ') {
                    assignments[j] = 'C';
                }
                
                if (!possible) {
                    break;
                }
            }
            
            if (possible) {
                for (char c : assignments) {
                    schedule.append(c);
                }
                System.out.println("Case #" + i + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}