import java.util.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] intervals = new int[N][3];
            
            for (int i = 0; i < N; i++) {
                intervals[i][0] = sc.nextInt(); // start time
                intervals[i][1] = sc.nextInt(); // end time
                intervals[i][2] = i;            // original index
            }
            
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[1], b[1]);
                }
            });
            
            Set<Integer> setC = new HashSet<>();
            int lastEndC = intervals[0][1];
            setC.add(intervals[0][2]);
            
            for (int i = 1; i < N; i++) {
                if (lastEndC <= intervals[i][0]) {
                    setC.add(intervals[i][2]);
                    lastEndC = intervals[i][1];
                }
            }
            
            Set<Integer> setJ = new HashSet<>();
            int lastEndJ = -1;
            
            for (int i = 0; i < N; i++) {
                if (!setC.contains(intervals[i][2])) {
                    if (lastEndJ == -1 || lastEndJ <= intervals[i][0]) {
                        setJ.add(intervals[i][2]);
                        lastEndJ = intervals[i][1];
                    }
                }
            }
            
            if (setC.size() + setJ.size() == N) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    result.append(setC.contains(i) ? 'C' : 'J');
                }
                System.out.println("Case #" + t + ": " + result.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}