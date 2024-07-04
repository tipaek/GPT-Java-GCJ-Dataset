import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            List<int[]> jamie = new ArrayList<>();
            List<int[]> cameron = new ArrayList<>();
            StringBuilder ans = new StringBuilder();
            boolean isPossible = true;
            
            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int[] interval = {start, end};
                
                if (isAvailable(jamie, interval)) {
                    jamie.add(interval);
                    ans.append("J");
                } else if (isAvailable(cameron, interval)) {
                    cameron.add(interval);
                    ans.append("C");
                } else {
                    isPossible = false;
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + i + ": " + ans);
            }
        }
        
        sc.close();
    }
    
    private static boolean isAvailable(List<int[]> schedule, int[] interval) {
        for (int[] time : schedule) {
            if (!(time[1] <= interval[0] || time[0] >= interval[1])) {
                return false;
            }
        }
        return true;
    }
}