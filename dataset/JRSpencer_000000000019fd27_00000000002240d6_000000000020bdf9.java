import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            HashMap<Integer, Integer> order = new HashMap<Integer, Integer>();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                order.put(start, j);
                map.put(start, stop);
            }
            char[] sequence = new char[n];
            String output = "";
            int cLatest = 0;
            int jLatest = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (cLatest <= entry.getKey()) {
                    sequence[order.get(entry.getKey())] += 'C';
                    cLatest = entry.getValue();
                } else if (jLatest <= entry.getKey()) {
                    sequence[order.get(entry.getKey())] += 'J';
                    jLatest = entry.getValue();
                } else {
                    output = "IMPOSSIBLE";
                    break;
                }
            }
            if (output != "IMPOSSIBLE") {
                output = new String(sequence);
            }
            System.out.println(String.format("Case #%d: %s", i, output));
        }
    }
}
