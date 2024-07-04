import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            ArrayList<int[]> cameron = new ArrayList<>();
            ArrayList<int[]> jamie = new ArrayList<>();
            StringBuilder ans = new StringBuilder();
            boolean possible = true;
            
            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int[] interval = { start, end };
                
                if (isCompatible(cameron, interval)) {
                    cameron.add(interval);
                    ans.append("C");
                } else if (isCompatible(jamie, interval)) {
                    jamie.add(interval);
                    ans.append("J");
                } else {
                    possible = false;
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + i + ": " + ans.toString());
            }
        }
    }

    private static boolean isCompatible(ArrayList<int[]> schedule, int[] interval) {
        for (int[] time : schedule) {
            if (time[0] < interval[1] && interval[0] < time[1]) {
                return false;
            }
        }
        return true;
    }
}