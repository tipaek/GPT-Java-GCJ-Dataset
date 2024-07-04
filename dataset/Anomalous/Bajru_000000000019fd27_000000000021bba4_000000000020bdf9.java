import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            
            if (numActivities == 2) {
                System.out.println("Case #" + caseNum + ": CJ");
            } else {
                int[][] activities = new int[numActivities][3];
                for (int j = 0; j < numActivities; j++) {
                    activities[j][0] = scanner.nextInt();
                    activities[j][1] = scanner.nextInt();
                    activities[j][2] = j;
                }
                assignTasks(activities, numActivities, caseNum);
            }
        }
    }
    
    private static void sortByColumn(int[][] array, int column) {
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                return Integer.compare(entry1[column], entry2[column]);
            }
        });
    }
    
    private static void assignTasks(int[][] activities, int numActivities, int caseNum) {
        int cEnd = 0;
        int jEnd = 0;
        
        sortByColumn(activities, 0);
        
        cEnd = activities[0][1];
        StringBuilder schedule = new StringBuilder("C");
        
        for (int i = 1; i < numActivities; i++) {
            if (activities[i][0] >= cEnd) {
                schedule.append("C");
                cEnd = activities[i][1];
            } else if (activities[i][0] >= jEnd) {
                schedule.append("J");
                jEnd = activities[i][1];
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.print("Case #" + caseNum + ": ");
        char[] result = new char[numActivities];
        for (int i = 0; i < numActivities; i++) {
            result[activities[i][2]] = schedule.charAt(i);
        }
        
        System.out.println(new String(result));
    }
}