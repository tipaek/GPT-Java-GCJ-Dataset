import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        Solution sol = new Solution();
        
        for (int i = 0; i < cases; i++) {
            String output = "";
            int taskCount = sc.nextInt();
            int[][] tasks = new int[taskCount][2];
            
            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = sc.nextInt();
                tasks[j][1] = sc.nextInt();
            }
            
            HashMap<Integer, String> assignments = new HashMap<>();
            for (int k = 0; k < taskCount; k++) {
                assignments.put(k, "C");
            }
            
            int earliestStart = tasks[0][0];
            int earliestTask = 0;
            for (int j = 1; j < taskCount; j++) {
                if (earliestStart > tasks[j][0]) {
                    earliestStart = tasks[j][0];
                    earliestTask = j;
                }
            }
            
            boolean impossible = false;
            for (int j = 1; j < taskCount; j++) {
                int[] currentTask = tasks[j];
                for (int k = 0; k < j; k++) {
                    int[] previousTask = tasks[k];
                    if (sol.isOverlap(currentTask, previousTask) && assignments.get(k).equals(assignments.get(j)) && !impossible) {
                        assignments.put(j, sol.switchAssignment(assignments.get(j)));
                        for (int l = 0; l < j; l++) {
                            int[] checkTask = tasks[l];
                            if (sol.isOverlap(checkTask, currentTask) && assignments.get(j).equals(assignments.get(l))) {
                                impossible = true;
                                assignments.put(0, "IMPOSSIBLE");
                            }
                        }
                    }
                }
            }
            
            if (!assignments.get(earliestTask).equals("IMPOSSIBLE")) {
                if (assignments.get(earliestTask).equals("J")) {
                    for (int j = 0; j < taskCount; j++) {
                        assignments.put(j, sol.switchAssignment(assignments.get(j)));
                    }
                }
            }
            
            for (int k = 0; k < taskCount; k++) {
                if (!assignments.get(0).equals("IMPOSSIBLE")) {
                    output += assignments.get(k);
                } else {
                    output = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
        sc.close();
    }
    
    public String switchAssignment(String assignment) {
        return assignment.equals("C") ? "J" : "C";
    }
    
    public boolean isOverlap(int[] a, int[] b) {
        return !(a[1] <= b[0] || b[1] <= a[0]);
    }
}