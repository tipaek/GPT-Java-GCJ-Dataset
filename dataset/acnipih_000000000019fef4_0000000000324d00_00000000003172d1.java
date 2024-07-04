import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("02.in"));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = in.nextInt();
            int d = in.nextInt();
            List<Long> angles = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                angles.add(in.nextLong());
            }
            int res = solve(n, d, angles);

            System.out.println("Case #" + caseNum + ": " + res);
        }
    }

    private static int solve(int n, int d,  List<Long> angles) {
       long sum = 0;
       for(int i = 0; i < angles.size(); i++) sum += angles.get(i);
       angles.add(360*1000000000L - sum);
        Collections.sort(angles);
        Map<Long, Integer> set = new HashMap<>();
        int res = 2;
        for (int i = 0; i < n; i++) {
            long el = angles.get(i);
            if (d == 2) {
                if (set.containsKey(el)) return 0;
                int f = set.getOrDefault(el, 0);
                set.put(el, f + 1);
            } else if (d == 3) {
                int f = set.getOrDefault(el, 0);
                if (f == 2) return 0;
                if (f == 1 && angles.size() > 2) res = Math.min(res, 1);
                set.put(el, f + 1);
                if(el % 2 == 0 && set.containsKey(el / 2)) res = Math.min(res, 1);
            }
        }
        if(d == 2) return 1;
        return res;
    }
}
