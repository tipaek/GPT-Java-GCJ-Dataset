import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] intervals = new int[N][3];
            
            for (int i = 0; i < N; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                intervals[i][2] = i;
            }
            
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
            
            Set<Integer> cSet = new HashSet<>();
            int lastC = intervals[0][1];
            cSet.add(intervals[0][2]);
            
            for (int i = 1; i < N; i++) {
                if (lastC <= intervals[i][0]) {
                    cSet.add(intervals[i][2]);
                    lastC = intervals[i][1];
                }
            }
            
            Set<Integer> jSet = new HashSet<>();
            int lastJ = -1;
            
            for (int i = 0; i < N; i++) {
                if (!cSet.contains(intervals[i][2])) {
                    if (lastJ == -1 || lastJ <= intervals[i][0]) {
                        jSet.add(intervals[i][2]);
                        lastJ = intervals[i][1];
                    }
                }
            }
            
            if (cSet.size() + jSet.size() == N) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    result.append(cSet.contains(i) ? 'C' : 'J');
                }
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}