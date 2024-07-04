import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {
    static Map<int[], Integer> map = new HashMap<>();
     static class myComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            int lines = scanner.nextInt();
            int[][] times = new int[lines][2];
            for (int j = 0; j < lines; j++) {
                times[j][0] = scanner.nextInt();
                times[j][1] = scanner.nextInt();
                map.put(times[j], j);
            }
            String res = solve(times);
            System.out.println("Case #" + i + ": " + res);
        }
    }
    private static String solve(int[][] n) {
         int[][] intervals = n.clone();
        Arrays.sort(intervals, new myComparator());
        char[] chars = new char[intervals.length];
        List<int[]> J = new ArrayList<>();
        chars[map.get(intervals[0])] = 'C';
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                chars[map.get(intervals[i])] = 'C';
            }
            else{
                chars[map.get(intervals[i])] = 'J';
                J.add(intervals[i]);
            }
        }
        int[][] tt = new int[J.size()][2];
        for (int i = 0; i < J.size(); i++) {
            tt[i] = J.get(i);
        }
        if (overlap(tt)){
            return "IMPOSSIBLE";
        }
        return String.valueOf(chars);
    }
    private static boolean overlap(int[][] intervals) {
        if (intervals.length  == 0) {
            return false;
        }
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            }
            else {
                return true;
            }
        }
        return false;
    }
}
