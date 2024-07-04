import java.util.*;
import java.io.*;
public class Solution {
    public static void solve(int t, List<List<Integer>> tasks){
        Collections.sort(tasks, Comparator.comparing(p -> p.get(0)));
        String res = "J";
        String prev = "J";
        Map<String, String> swap = new HashMap<>();
        Map<String, Integer> mx = new HashMap<>();
        swap.put("J", "C");
        swap.put("C", "J");
        mx.put("J", tasks.get(0).get(1));
        mx.put("C",0);
        for (int i = 1; i < tasks.size(); i++ ) {
            if (tasks.get(i).get(0) >= tasks.get(i - 1).get(1)) {
                res += prev;
                mx.put(prev, tasks.get(i).get(1));
            } else if (tasks.get(i).get(0) >= mx.get(swap.get(prev))) {
                prev = swap.get(prev);
                mx.put(prev, tasks.get(i).get(1));
                res += prev;
            }
            else {
                res = "IMPOSSIBLE";
                break;
            }
        }

        System.out.println("Case #" + t + ": " + res);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<List<Integer>> l = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                l.add(Arrays.asList(n1, n2));
            }
           solve(i, l);
        }
    }
}
