import java.util.*;

public class Solution {

    private static String solve(int u, Pair[] pairs) {
        // u = 2
        Map<Character, Integer> cnt = new HashMap<>();
        for (Pair p : pairs) {
            int n = p.n;
            String s = p.s;
            if (s.length() == 1) {
                cnt.compute(s.charAt(0), (k, v) -> v == null ? 1 : v + 1);
            } else {
                cnt.compute(s.charAt(0), (k, v) -> v == null ? 1 : v + 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(cnt.entrySet());
        Collections.sort(list, Map.Entry.<Character, Integer>comparingByValue().reversed());
        StringBuilder sb = new StringBuilder();
        //Set<Character> set = new HashSet<>()
        for (Map.Entry<Character, Integer> e : list) {
            sb.append(e.getKey());
        }
        //S
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ks = 1; ks <= T; ++ks) {
            int u = in.nextInt();
            Pair[] pairs = new Pair[10000];
            for (int i = 0; i < 10000; i++) {
                pairs[i].n = in.nextInt();
                pairs[i].s = in.next();
            }
            System.out.println("Case #" + ks + ": " + solve(u, pairs));
        }
    }
}

class Pair {
    int n;
    String s;

    public Pair(int n, String s) {
        this.n = n;
        this.s = s;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}