import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(intervals, (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });
            
            Set<Integer> cameron = new HashSet<>();
            Set<Integer> jamie = new HashSet<>();
            int lastCameron = -1;
            int lastJamie = -1;
            
            boolean possible = true;
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                if (lastCameron <= intervals[i][0]) {
                    cameron.add(i);
                    lastCameron = intervals[i][1];
                    result.append('C');
                } else if (lastJamie <= intervals[i][0]) {
                    jamie.add(i);
                    lastJamie = intervals[i][1];
                    result.append('J');
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println(result.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}