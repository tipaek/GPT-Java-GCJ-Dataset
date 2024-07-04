import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        for (int i = 1; i <= cases; i++) {
            int rows = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            int[][] activities = new int[rows][2];
            for (int j = 0; j < rows; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            }
            
            if (isPossible(activities)) {
                System.out.println("Case #" + i + ": " + planActivities(activities));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    public static boolean isPossible(int[][] activities) {
        int maxEndTime = -1;
        for (int[] activity : activities) {
            if (activity[1] > maxEndTime) {
                maxEndTime = activity[1];
            }
        }
        
        int[] schedule = new int[maxEndTime + 1];
        for (int[] activity : activities) {
            for (int time = activity[0] + 1; time <= activity[1]; time++) {
                if (schedule.time < 2) {
                    schedule.time++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static String planActivities(int[][] activities) {
        StringBuilder output = new StringBuilder(" ".repeat(activities.length));
        int ca = -1, ja = -1;
        
        for (int i = 0; i < activities.length; i++) {
            Integer earliest = null;
            for (int j = 0; j < activities.length; j++) {
                if (activities[j][0] != -1) {
                    if (earliest == null || activities[j][0] < activities[earliest][0]) {
                        earliest = j;
                    }
                }
            }
            
            if (ca != -1 && activities[earliest][0] >= activities[ca][1]) {
                ca = -1;
            }
            if (ja != -1 && activities[earliest][0] >= activities[ja][1]) {
                ja = -1;
            }
            
            if (ca == -1) {
                ca = earliest;
                output.setCharAt(earliest, 'C');
                activities[earliest][0] = -1;
            } else if (ja == -1) {
                ja = earliest;
                output.setCharAt(earliest, 'J');
                activities[earliest][0] = -1;
            }
        }
        
        return output.toString();
    }
}