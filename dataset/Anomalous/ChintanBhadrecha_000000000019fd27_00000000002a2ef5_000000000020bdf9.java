import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTest = sc.nextInt();
        String[] solution = new String[noOfTest];
        
        for (int t = 0; t < noOfTest; t++) {
            int n = sc.nextInt();
            ArrayList<int[]> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                intervals.add(new int[]{sc.nextInt(), sc.nextInt(), i});
            }
            solution[t] = solve(intervals);
        }
        
        for (int i = 0; i < solution.length; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solution[i]);
        }
    }

    public static String solve(ArrayList<int[]> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.size()];
        int[] cEnd = {-1};
        int[] jEnd = {-1};

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int index = interval[2];
            
            if (start >= cEnd[0]) {
                result[index] = 'C';
                cEnd[0] = end;
            } else if (start >= jEnd[0]) {
                result[index] = 'J';
                jEnd[0] = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }
}