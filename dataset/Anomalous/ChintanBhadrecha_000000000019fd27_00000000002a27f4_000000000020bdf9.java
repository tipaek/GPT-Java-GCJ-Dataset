import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTests = sc.nextInt();
        String[] solutions = new String[noOfTests];
        
        for (int t = 0; t < noOfTests; t++) {
            int n = sc.nextInt();
            ArrayList<int[]> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                intervals.add(new int[]{sc.nextInt(), sc.nextInt(), i});
            }
            solutions[t] = solve(intervals, n);
        }
        
        for (int i = 0; i < solutions.length; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static String solve(ArrayList<int[]> intervals, int n) {
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        
        char[] result = new char[n];
        int[] cEnd = {-1};
        int[] jEnd = {-1};

        for (int[] interval : intervals) {
            if (interval[0] >= cEnd[0]) {
                result[interval[2]] = 'C';
                cEnd[0] = interval[1];
            } else if (interval[0] >= jEnd[0]) {
                result[interval[2]] = 'J';
                jEnd[0] = interval[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }
}