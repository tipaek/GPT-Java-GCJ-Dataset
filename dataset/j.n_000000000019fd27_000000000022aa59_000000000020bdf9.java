import java.util.*;
import java.io.*;
public class Solution {
    public static void solve(int t, List<List<Integer>> tasks){
        Collections.sort(tasks, Comparator.comparing(p -> p.get(0)));
        String res[] = new String[tasks.size()];
        res[tasks.get(0).get(2)] = "J";
        String prev = "J";
        String resString = "";
        Map<String, String> swap = new HashMap<>();
        Map<String, Integer> mx = new HashMap<>();
        swap.put("J", "C");
        swap.put("C", "J");
        mx.put("J", tasks.get(0).get(1));
        mx.put("C",0);
        for (int i = 1; i < tasks.size(); i++ ) {
            if (tasks.get(i).get(0) >= tasks.get(i - 1).get(1)) {
                res[tasks.get(i).get(2)] = prev;
                mx.put(prev, tasks.get(i).get(1));
            } else if (tasks.get(i).get(0) >= mx.get(swap.get(prev))) {
                prev = swap.get(prev);
                mx.put(prev, tasks.get(i).get(1));
                res[tasks.get(i).get(2)] = prev;
            }
            else {
                resString = "IMPOSSIBLE";
                break;
            }
        }
        if (!resString.equals("IMPOSSIBLE")){
            resString = String.join("",res);
        }
        System.out.println("Case #" + t + ": " + resString);

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
                l.add(Arrays.asList(n1, n2, k));
            }
           solve(i, l);
        }
    }
}
