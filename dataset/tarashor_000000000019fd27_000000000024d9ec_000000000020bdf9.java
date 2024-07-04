import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            List<int[]> intervals = new ArrayList<>(N);
            for (int j = 0; j < N; j++){
                int[] interval = new int[3];
                interval[0] = in.nextInt();
                interval[1] = in.nextInt();
                interval[2] = j;
                intervals.add(interval);
            }

            intervals.sort((o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));

            System.out.println("Case #" + i + ": " + solve(intervals, N));
        }
        // write your code here
    }

    private static String solve(List<int[]> intervals, int N) {
        Set<Integer> cameron = new HashSet<>();
        Set<Integer> james = new HashSet<>();
        int cameronLast = 0;
        int jamesLast = 0;
        for (int i = 0; i < N; i++){
            int start = intervals.get(i)[0];
            int end = intervals.get(i)[1];
            int index = intervals.get(i)[2];
            if (cameronLast <= start) {
                cameron.add(index);
                cameronLast = end;
            } else if (jamesLast <= start) {
                james.add(index);
                jamesLast = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < N; i++){
            if (cameron.contains(i)) s.append('C');
            if (james.contains(i)) s.append('J');
        }
   
        return s.toString();
    }

}
