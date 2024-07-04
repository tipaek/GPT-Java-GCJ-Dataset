import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int q = 0; q < t; q++) {
            int n = sc.nextInt();
            int[][] activities = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = sc.nextInt();
                activities[i][1] = sc.nextInt();
            }
            
            int[][] sortedActivities = activities.clone();
            Arrays.sort(sortedActivities, new StartComparator());
            
            HashMap<String, String> assignment = new HashMap<>();
            int cameronFreeTime = 0;
            int jamieFreeTime = 0;
            boolean isImpossible = false;
            
            for (int i = 0; i < n; i++) {
                int start = sortedActivities[i][0];
                int end = sortedActivities[i][1];
                
                if (cameronFreeTime <= start) {
                    cameronFreeTime = end;
                    assignment.put(start + "-" + end, "C");
                } else if (jamieFreeTime <= start) {
                    jamieFreeTime = end;
                    assignment.put(start + "-" + end, "J");
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (q + 1) + ": IMPOSSIBLE");
                continue;
            }
            
            StringBuilder result = new StringBuilder();
            HashMap<String, Integer> taskCount = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                String key = activities[i][0] + "-" + activities[i][1];
                if (taskCount.containsKey(key)) {
                    result.append("C");
                } else {
                    result.append(assignment.get(key));
                }
                taskCount.put(key, 1);
            }
            
            System.out.println("Case #" + (q + 1) + ": " + result.toString());
        }
    }

    static class StartComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }
}