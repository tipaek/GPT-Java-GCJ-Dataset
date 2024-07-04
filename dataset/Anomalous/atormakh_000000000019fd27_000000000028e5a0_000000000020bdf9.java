import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            ArrayList<int[]> activities = new ArrayList<>();
            
            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end, i});
            }
            
            Collections.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            int[] assigned = new int[activitiesCount];
            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;
            
            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                int index = activity[2];
                
                if (start >= cEnd) {
                    assigned[index] = 'C';
                    cEnd = end;
                } else if (start >= jEnd) {
                    assigned[index] = 'J';
                    jEnd = end;
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < activitiesCount; i++) {
                    result.append((char) assigned[i]);
                }
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}