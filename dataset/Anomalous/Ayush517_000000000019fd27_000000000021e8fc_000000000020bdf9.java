import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][3];
            char[] schedule = new char[n];
            Arrays.fill(schedule, 'C');
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            int cEnd = activities[0][1];
            int jEnd = -1;
            boolean isPossible = true;
            
            for (int i = 1; i < n; i++) {
                if (activities[i][0] >= cEnd) {
                    cEnd = activities[i][1];
                    schedule[activities[i][2]] = 'C';
                } else if (activities[i][0] >= jEnd) {
                    jEnd = activities[i][1];
                    schedule[activities[i][2]] = 'J';
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": " + new String(schedule));
            }
        }
        
        scanner.close();
    }
}