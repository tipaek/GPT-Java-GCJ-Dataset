import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();
            int[][] cameronSchedule = new int[1002][2];
            int cameronCount = 0;
            int[][] jamieSchedule = new int[1002][2];
            int jamieCount = 0;
            
            for (int p = 0; p < activities; p++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (isImpossible) continue;
                
                if (isSchedulable(cameronSchedule, cameronCount, start, end)) {
                    result.append("C");
                    cameronCount++;
                } else if (isSchedulable(jamieSchedule, jamieCount, start, end)) {
                    result.append("J");
                    jamieCount++;
                } else {
                    isImpossible = true;
                }
            }
            
            System.out.println("Case #" + i + ": " + (isImpossible ? "IMPOSSIBLE" : result.toString()));
        }
        
        scanner.close();
    }

    private static boolean isSchedulable(int[][] schedule, int count, int start, int end) {
        for (int i = 0; i < count; i++) {
            if (!(start > schedule[i][1] || end - 1 <= schedule[i][0])) {
                return false;
            }
        }
        schedule[count][0] = start;
        schedule[count][1] = end - 1;
        return true;
    }
}