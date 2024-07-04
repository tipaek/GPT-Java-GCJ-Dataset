import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        ArrayList<String> results = new ArrayList<>();
        
        for (int i = 0; i < cases; i++) {
            int taskCount = sc.nextInt();
            int[][] tasks = new int[taskCount][2];
            
            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = sc.nextInt();
                tasks[j][1] = sc.nextInt();
            }
            
            String result = assignTasks(tasks);
            results.add(result);
        }
        
        sc.close();
        
        for (int i = 0; i < cases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
    
    private static String assignTasks(int[][] tasks) {
        int taskCount = tasks.length;
        HashMap<Integer, String> assignments = new HashMap<>();
        
        for (int i = 0; i < taskCount; i++) {
            assignments.put(i, "C");
        }
        
        int minStartTime = tasks[0][0];
        int minIndex = 0;
        
        for (int i = 1; i < taskCount; i++) {
            if (tasks[i][0] < minStartTime) {
                minStartTime = tasks[i][0];
                minIndex = i;
            }
        }
        
        assignments.put(minIndex, "C");
        boolean impossible = false;
        
        for (int i = 1; i < taskCount; i++) {
            if (tasks[i - 1][0] >= tasks[i - 1][1]) {
                assignments.put(0, "IMPOSSIBLE");
                break;
            }
            
            for (int j = 0; j < i; j++) {
                if (isOverlap(tasks[i], tasks[j]) && assignments.get(i).equals(assignments.get(j))) {
                    assignments.put(i, switchAssignment(assignments.get(i)));
                    
                    for (int k = 0; k < i; k++) {
                        if (isOverlap(tasks[i], tasks[k]) && assignments.get(i).equals(assignments.get(k))) {
                            impossible = true;
                            assignments.put(0, "IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }
            
            if (impossible) {
                break;
            }
        }
        
        if (!assignments.get(0).equals("IMPOSSIBLE")) {
            if (assignments.get(minIndex).equals("J")) {
                for (int i = 0; i < taskCount; i++) {
                    assignments.put(i, switchAssignment(assignments.get(i)));
                }
            }
        }
        
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            if (!assignments.get(0).equals("IMPOSSIBLE")) {
                output.append(assignments.get(i));
            } else {
                output.append(assignments.get(0));
                break;
            }
        }
        
        return output.toString();
    }
    
    private static String switchAssignment(String assignment) {
        return assignment.equals("C") ? "J" : "C";
    }
    
    private static boolean isOverlap(int[] a, int[] b) {
        return !(a[1] <= b[0] || b[1] <= a[0]);
    }
}