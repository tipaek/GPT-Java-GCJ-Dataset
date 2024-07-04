import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for(int k=1; k<=T; k++) {
            int len = scanner.nextInt();
            int[][] intervals = new int[len][];
            for(int i=0; i<len; i++) 
                intervals[i] = new int[]{scanner.nextInt(), scanner.nextInt()};
            System.out.println("Case #" + k + ": " + solve(intervals));
        }
    }

    private static String solve(int[][] intervals) {
        if(!isValid(intervals)) {
            return "IMPOSSIBLE";
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int end = -1;
        char last = 'J';
        for(int[] t : intervals) {
            char person = last;
            if(t[0] < end) {
                person = (last == 'J') ? 'C' : 'J';
            }
            sb.append(person);
            if(end < t[1]) {
                last = person;
            }
            end = Math.max(end, t[1]);
        }
        return sb.toString();
    }

    private static boolean isValid(int[][] intervals) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(int[] t : intervals) {
            count.put(t[0], count.getOrDefault(t[0], 0) + 1);
            count.put(t[1], count.getOrDefault(t[1], 0) - 1);
        }

        int k = 0;
        for(int key : count.keySet()) {
            k += count.get(key);
            if(k > 2) return false;
        }
        return true;
    }
}