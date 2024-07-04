import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] times = new int[n][2];
            for (int j = 0; j < n; j++) {
                times[j][0] = in.nextInt();
                times[j][1] = in.nextInt();
            }
            String ans = solve(times);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(int[][] times) {
        Map<Integer, Character> map = new HashMap<>();
        PriorityQueue<int[]> start = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        PriorityQueue<int[]> end = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        for (int i = 0; i < times.length; i++) {
            start.add(new int[] {times[i][0], i});
            end.add(new int[] {times[i][1], i});
        }

        int level = 0;
        Stack<Character> stack = new Stack<>();
        stack.push('C');
        stack.push('J');
        while (!start.isEmpty() && !end.isEmpty()) {
            //a new start
            if (start.peek()[0] < end.peek()[0]) {
                int[] curr = start.remove();
                level++;
                if (level > 2) {
                    return "IMPOSSIBLE";
                }else {
                    map.put(curr[1], stack.pop());
                }
            }
            //a new end
            else {
                int[] curr = end.remove();
                level--;
                stack.push(map.get(curr[1]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times.length; i++) {
            sb.append(map.get(i));
        }
        return sb.toString();
    }
}

