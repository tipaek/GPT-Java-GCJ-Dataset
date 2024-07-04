
import java.util.*;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);
    private static final int M = 10000;
    private static final int D = 10;

    private long[] Q;
    private String[] R;
    private int U;
    private List<Character> C;
    private List<String> T;
    private String ans;

    private long toValue(String s, Map<Character, Integer> map) {
        long value = 0;
        for (char c : s.toCharArray()) {
            int d = map.get(c);
            if (value == 0 && d == 0) {
                return -1;
            }
            value = value * 10 + map.get(c);
        }
        return value;
    }

    private boolean per(int n, boolean[] exist, int[] buf) {
        if (n == 9) {
            for (int i = 0; i < D; ++i) {
                if (!exist[i]) {
                    buf[n] = i;
                    break;
                }
            }

            Map<Character, Integer> map = new HashMap<>();
            Map<Integer, Character> mapR = new HashMap<>();
            for (int i = 0; i < D; ++i) {
                map.put(C.get(i), buf[i]);
                mapR.put(buf[i], C.get(i));
            }

            boolean ok = true;
            for (int i = 0; i < M; i++) {
                if (Q[i] != -1) {
                    long v = toValue(R[i], map);
                    if (v > Q[i] || v <= 0) {
                        ok = false;
                        break;
                    }
                } else {
                    long v = toValue(R[i], map);
                    if (v <= 0) {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < D; ++i) {
                    sb.append(mapR.get(i));
                }
                ans = sb.toString();
//
//                for (int i = 0; i < M; i++) {
//                    long v = toValue(R[i], map);
//                    System.out.println(Q[i] + " " + v);
//                }
                return true;
            }
        }

        for (int i = 0; i < D; ++i) {
            if (!exist[i]) {
                exist[i] = true;
                buf[n] = i;
                if (per(n + 1, exist, buf)) {
                    return true;
                }
                exist[i] = false;
            }
        }
        return false;
    }

    private void solve() {
        U = sc.nextInt();

        Q = new long[M];
        R = new String[M];
        for (int i = 0; i < M; ++i) {
            Q[i] = sc.nextLong();
            R[i] = sc.next();
        }

        C = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (char c : R[i].toCharArray()) {
                if (C.contains(c)) {
                    continue;
                }
                C.add(c);
            }
        }

        boolean[] exist = new boolean[D];
        int[] buf = new int[D];
        per(0, exist, buf);

        System.out.println(ans);
    }

    private void run() {
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            System.out.print(String.format("Case #%d: ", t));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
