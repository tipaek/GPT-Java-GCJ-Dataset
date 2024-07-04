import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][2];
            char[] result = new char[numberOfActivities];
            Arrays.fill(result, '@');
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i][0] = start;
                activities[i][1] = end;
            }
            
            if (assignActivities(activities, result, 'C') && assignActivities(activities, result, 'J')) {
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
    
    private static boolean assignActivities(int[][] activities, char[] result, char person) {
        int lastEndTime = 0;
        
        for (int i = 0; i < activities.length; i++) {
            if (result[i] == '@' && activities[i][0] >= lastEndTime) {
                result[i] = person;
                lastEndTime = activities[i][1];
            }
        }
        
        return !new String(result).contains("@");
    }
}