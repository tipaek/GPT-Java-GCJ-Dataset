import java.util.*;

public class Solution {
    
    static final Scanner SCANNER = new Scanner(System.in);
    
    static String assignTasks(int N, int[][] intervals) {
        
        StringBuilder result = new StringBuilder();
        int endC = 0, endJ = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> intervals[a][1] - intervals[b][1]);
        for (int i = 0; i < N; ++i) {
            pq.add(i);
        }
        
        char[] taskAssignments = new char[N];
        
        while (!pq.isEmpty()) {
            int current = pq.poll();
            int start = intervals[current][0];
            int end = intervals[current][1];
            
            if (endC <= endJ) {
                if (start >= endC) {
                    taskAssignments[current] = 'C';
                    endC = end;
                } else if (start >= endJ) {
                    taskAssignments[current] = 'J';
                    endJ = end;
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                if (start >= endJ) {
                    taskAssignments[current] = 'J';
                    endJ = end;
                } else if (start >= endC) {
                    taskAssignments[current] = 'C';
                    endC = end;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        
        for (char assignment : taskAssignments) {
            result.append(assignment);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        int T = SCANNER.nextInt();
        
        for (int i = 1; i <= T; ++i) {
            int N = SCANNER.nextInt();
            int[][] intervals = new int[N][2];
            
            for (int j = 0; j < N; ++j) {
                intervals[j][0] = SCANNER.nextInt();
                intervals[j][1] = SCANNER.nextInt();
            }
            
            String result = assignTasks(N, intervals);
            System.out.printf("Case #%d: %s\n", i, result);
        }
        
        SCANNER.close();
    }
}