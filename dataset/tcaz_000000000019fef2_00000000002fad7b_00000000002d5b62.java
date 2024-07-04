import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        new Solution().solve();
    }

    // try jump n, s
    // try jump e, w

    String tryJump(long x, long y, int jumps, long dstX, long dstY, String curr) {
        if (jumps > 9) {
            return "IMPOSSIBLE";
        }
        if (x == dstX && y == dstY) {
            return curr;
        }
        long nextJump = (long)Math.pow(2, jumps);
        List<String> results = new ArrayList<>();
        // try jump E
        results.add(tryJump(x + nextJump, y, jumps + 1, dstX, dstY, curr + 'E'));
        // try jump W
        results.add(tryJump(x - nextJump, y, jumps + 1, dstX, dstY, curr + 'W'));
        // try jump N
       results.add(tryJump(x, y + nextJump, jumps + 1, dstX, dstY, curr + 'N'));
        // try jump S
        results.add(tryJump(x, y - nextJump, jumps + 1, dstX, dstY, curr + 'S'));
        String result = "";
        int length = Integer.MAX_VALUE;
        for (String r : results) {
            if (!r.equals("IMPOSSIBLE") && r.length() < length) {
                result = r;
                length = r.length();
            }
        }
        if (result.isEmpty()) {
            return "IMPOSSIBLE";
        }
        return result;

    }

    void solve() {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            long x = scan.nextLong();
            long y = scan.nextLong();
            int jumps = 0;
            String res = tryJump(0, 0, jumps, x, y, "");
            printCase(i+1, res);
        }
    }



    void printCase(int num, String ans) {
        System.out.println("Case #" + num + ": " + ans);
    }

}
