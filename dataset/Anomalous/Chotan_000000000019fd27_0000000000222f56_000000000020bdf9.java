import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] tasks = new int[N][3];
            
            for (int i = 0; i < N; i++) {
                tasks[i][0] = sc.nextInt(); // Start time
                tasks[i][1] = sc.nextInt(); // End time
                tasks[i][2] = i;            // Original index
            }
            
            Arrays.sort(tasks, (a, b) -> {
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            });
            
            HashSet<Integer> assignedToC = new HashSet<>();
            int lastEndTimeC = tasks[0][1];
            assignedToC.add(tasks[0][2]);
            
            for (int i = 1; i < N; i++) {
                if (lastEndTimeC <= tasks[i][0]) {
                    assignedToC.add(tasks[i][2]);
                    lastEndTimeC = tasks[i][1];
                }
            }
            
            HashSet<Integer> assignedToJ = new HashSet<>();
            int lastEndTimeJ = -1;
            
            for (int i = 0; i < N; i++) {
                if (!assignedToC.contains(tasks[i][2])) {
                    if (lastEndTimeJ == -1 || lastEndTimeJ <= tasks[i][0]) {
                        assignedToJ.add(tasks[i][2]);
                        lastEndTimeJ = tasks[i][1];
                    }
                }
            }
            
            if (assignedToC.size() + assignedToJ.size() == N) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if (assignedToC.contains(i)) {
                        result.append('C');
                    } else {
                        result.append('J');
                    }
                }
                System.out.println("Case #" + t + ": " + result.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}