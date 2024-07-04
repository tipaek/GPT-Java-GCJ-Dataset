import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); 
        
        for (int t = 1; t <= testCases; t++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];
            StringBuilder schedule = new StringBuilder();
            
            for (int i = 0; i < numTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }
            
            String result = "";
            boolean impossible = false;
            char[] assigned = new char[numTasks];
            Arrays.fill(assigned, ' ');

            for (int i = 0; i < numTasks; i++) {
                int start = tasks[i][0];
                int end = tasks[i][1];
                boolean assignedC = false;
                boolean assignedJ = false;
                
                for (int j = 0; j < i; j++) {
                    if (tasks[j][0] < end && tasks[j][1] > start) {
                        if (assigned[j] == 'C') assignedC = true;
                        if (assigned[j] == 'J') assignedJ = true;
                    }
                }
                
                if (!assignedC) {
                    assigned[i] = 'C';
                } else if (!assignedJ) {
                    assigned[i] = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    impossible = true;
                    break;
                }
            }
            
            if (!impossible) {
                for (char c : assigned) {
                    schedule.append(c);
                }
                result = schedule.toString();
            }
            
            System.out.println("Case #" + t + ": " + result);
        }
    }
}