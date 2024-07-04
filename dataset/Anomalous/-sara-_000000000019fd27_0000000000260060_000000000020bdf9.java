import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            StringBuilder jamieSchedule = new StringBuilder("0".repeat(1440));
            StringBuilder cameronSchedule = new StringBuilder("0".repeat(1440));
            StringBuilder solution = new StringBuilder();
            
            boolean isPossible = true;
            
            for (int j = 0; j < n; j++) {
                int beginTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                if (isPossible) {
                    if (isAvailable(jamieSchedule, beginTime, endTime)) {
                        fillSchedule(jamieSchedule, beginTime, endTime);
                        solution.append("J");
                    } else if (isAvailable(cameronSchedule, beginTime, endTime)) {
                        fillSchedule(cameronSchedule, beginTime, endTime);
                        solution.append("C");
                    } else {
                        solution.setLength(0);
                        solution.append("IMPOSSIBLE");
                        isPossible = false;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + solution);
        }
        
        scanner.close();
    }
    
    private static boolean isAvailable(StringBuilder schedule, int beginTime, int endTime) {
        for (int k = beginTime; k < endTime; k++) {
            if (schedule.charAt(k) == '1') {
                return false;
            }
        }
        return true;
    }
    
    private static void fillSchedule(StringBuilder schedule, int beginTime, int endTime) {
        for (int k = beginTime; k < endTime; k++) {
            schedule.setCharAt(k, '1');
        }
    }
}