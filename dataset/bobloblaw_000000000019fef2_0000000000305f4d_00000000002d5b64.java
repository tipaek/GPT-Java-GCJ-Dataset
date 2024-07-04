import java.util.*;

public class Solution {
    class Shuffle {
        public int a;
        public int b;

        public Shuffle(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public List<Shuffle> shuffle(int r, int s) {
        if (r == 1) {
            return new ArrayList<>();
        }
        List<Shuffle> out = new ArrayList<>();
        for (int i = 1; i < s; i++) {
            out.add(new Shuffle(r, r * s - r - i));
        }
        out.addAll(shuffle(r - 1, s));
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        int tests = sc.nextInt();
        for (int test = 1; test <= tests; test++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            List<Shuffle> ans = sol.shuffle(r, s);
            System.out.println(String.format("Case #%d: %d", test, ans.size()));
            ans.forEach(a -> System.out.println(String.format("%d %d", a.a, a.b)));
        }
    }
}