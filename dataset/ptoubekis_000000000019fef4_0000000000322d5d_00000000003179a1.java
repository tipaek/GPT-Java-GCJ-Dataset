import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        final int n = 10000;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int u = in.nextInt();
            long[] q = new long[n];
            String[] s = new String[n];
            for (int j = 0; j < n; j++) {
                q[j] = in.nextLong();
                s[j] = in.next();
            }
            System.out.println("Case #" + i + ": " + foo(u, q, s));
        }
    }

    private static String foo(int u, long[] q, String[] r) {
        int n = r.length;
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            String s = r[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                Integer t = map.getOrDefault(c, 0);
                map.put(c, t + 1);
            }
        }
        Set<Entry<Character, Integer>> set = map.entrySet();
        ArrayList<Entry<Character, Integer>> list = new ArrayList<>(set);
        list.sort((Entry<Character, Integer> e1, Entry<Character, Integer> e2) -> {
            return Integer.compare(e2.getValue(), e1.getValue());
        });
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(list.size() - 1).getKey());
        for (int i = 0; i < list.size() - 1; i++) {
            Entry<Character, Integer> e = list.get(i);
            sb.append(e.getKey());
        }
        return sb.toString();
    }

}
