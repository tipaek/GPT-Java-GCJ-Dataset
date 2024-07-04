import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int[][] schedule = new int[1440][2];
            boolean impossible = false;
            
            int w = in.nextInt();
            int[][] activities = new int[w][3];
            
            for (int j = 0; j < w; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activities[j][2] = j;
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            int[] assignment = new int[w];
            Arrays.fill(assignment, -1);
            
            for (int j = 0; j < w; j++) {
                int start = activities[j][0];
                int end = activities[j][1];
                int index = activities[j][2];
                
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;
                
                for (int k = start; k < end; k++) {
                    if (schedule[k][0] == 1) canAssignToCameron = false;
                    if (schedule[k][1] == 1) canAssignToJamie = false;
                }
                
                if (canAssignToCameron) {
                    for (int k = start; k < end; k++) {
                        schedule[k][0] = 1;
                    }
                    assignment[index] = 1;
                } else if (canAssignToJamie) {
                    for (int k = start; k < end; k++) {
                        schedule[k][1] = 1;
                    }
                    assignment[index] = 2;
                } else {
                    impossible = true;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int j : assignment) {
                    result.append(j == 1 ? "C" : "J");
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
    }
}