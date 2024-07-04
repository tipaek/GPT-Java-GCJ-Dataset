import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int len = in.nextInt();
            List<List<Integer>> matrix = new ArrayList<>();
            for (int r = 0; r < len; r++) {
                matrix.add(new ArrayList<>());
                for (int c = 0; c < len; c++) {
                    matrix.get(r).add(in.nextInt());
                }
            }
            System.out.print("Case #" + i + ": ");
            String res = search(matrix);
            System.out.println(res);
        }
    }

    public static String search(List<List<Integer>> m) {
        if (m == null || m.size() == 0) {
            return "0 0 0";
        }
        StringBuilder sb = new StringBuilder();
        int len = m.size();
        // trace
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += m.get(i).get(i);
        }
        sb.append(sum + " ");
        sum = 0;
        for (int i = 0; i < len; i++) {
            Set<Integer> set = new HashSet<>(m.get(i));
            if (set.size() != len) {
                sum++;
            }
        }
        sb.append(sum + " ");
        sum = 0;
        for (int i = 0; i < len; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < len; j++) {
                set.add(m.get(j).get(i));
            }
            if (set.size() != len) {
                sum++;
            }
        }
        sb.append(sum);

        return sb.toString();
    }
}