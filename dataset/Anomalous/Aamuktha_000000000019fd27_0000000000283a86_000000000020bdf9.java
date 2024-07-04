import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();
            List<int[]> jActivities = new ArrayList<>();
            List<int[]> cActivities = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int start = startTimes[i];
                int end = endTimes[i];
                
                if (isAvailable(start, end, jActivities)) {
                    jActivities.add(new int[]{start, end});
                    schedule.append('J');
                } else if (isAvailable(start, end, cActivities)) {
                    cActivities.add(new int[]{start, end});
                    schedule.append('C');
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            System.out.println(isPossible ? schedule.toString() : "IMPOSSIBLE");
        }
    }
    
    private static boolean isAvailable(int start, int end, List<int[]> activities) {
        for (int[] activity : activities) {
            if (!(end <= activity[0] || start >= activity[1])) {
                return false;
            }
        }
        return true;
    }
}