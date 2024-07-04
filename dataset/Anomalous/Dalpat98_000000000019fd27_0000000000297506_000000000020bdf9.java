import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int line = scanner.nextInt();
            int[][] intervals = new int[line][2];
            List<String> result = new ArrayList<>(Collections.singletonList("CJ"));
            
            for (int a = 0; a < line; a++) {
                intervals[a][0] = scanner.nextInt();
                intervals[a][1] = scanner.nextInt();
            }
            
            boolean possible = true;
            int cStart = intervals[0][0];
            int cEnd = intervals[0][1];
            int jStart = intervals[1][0];
            int jEnd = intervals[1][1];
            
            for (int a = 2; a < line && possible; a++) {
                int start = intervals[a][0];
                int end = intervals[a][1];
                
                if (line == 2) {
                    break;
                } else if (cEnd == start || (cStart > start && start < cEnd) || (cStart < start && start > cEnd)) {
                    result.add("C");
                    cEnd = end;
                    cStart = start;
                } else if (jEnd == start || (jStart > start && start < jEnd) || (jStart < start && start > jEnd)) {
                    result.add("J");
                    jEnd = end;
                    jStart = start;
                } else {
                    result = new ArrayList<>(Collections.singletonList("IMPOSSIBLE"));
                    possible = false;
                }
            }
            
            String res = String.join("", result);
            System.out.println("Case #" + i + ": " + res);
        }
        
        scanner.close();
    }
}