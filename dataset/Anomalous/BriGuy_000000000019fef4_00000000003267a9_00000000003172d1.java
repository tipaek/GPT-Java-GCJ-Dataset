import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());

            if (D == 2) {
                boolean zero = false;
                HashSet<Long> set = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    long x = Long.parseLong(st.nextToken());
                    if (set.contains(x)) {
                        zero = true;
                        break;
                    }
                    set.add(x);
                }
                System.out.println("Case #" + t + ": " + (zero ? 0 : 1));
            } else {
                boolean zero = false;
                boolean one = false;
                HashMap<Long, Integer> map = new HashMap<>();
                for (int i = 0; i < N; i++) {
                    long x = Long.parseLong(st.nextToken());
                    if (map.containsKey(x) && map.get(x) == 2) {
                        zero = true;
                        break;
                    }

                    if (x % 2 == 0 && map.containsKey(x / 2)) {
                        one = true;
                    }

                    if (map.containsKey(x * 2)) {
                        one = true;
                    }

                    map.put(x, map.getOrDefault(x, 0) + 1);
                }
                if (zero) {
                    System.out.println("Case #" + t + ": 0");
                } else if (one) {
                    System.out.println("Case #" + t + ": 1");
                } else {
                    System.out.println("Case #" + t + ": 2");
                }
            }
        }
    }
}