import java.util.*;

public class Solution {
    public static void main(String[] args) {
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
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
            
            Set<Integer> setC = new HashSet<>();
            int lastC = -1;
            for (int[] interval : intervals) {
                if (lastC == -1 || lastC <= interval[0]) {
                    setC.add(interval[2]);
                    lastC = interval[1];
                }
            }
            
            Set<Integer> setJ = new HashSet<>();
            int lastJ = -1;
            for (int[] interval : intervals) {
                if (!setC.contains(interval[2])) {
                    if (lastJ == -1 || lastJ <= interval[0]) {
                        setJ.add(interval[2]);
                        lastJ = interval[1];
                    }
                }
            }
            
            if (setC.size() + setJ.size() == N) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if (setC.contains(i)) {
                        result.append('C');
                    } else {
                        result.append('J');
                    }
                }
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}