
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            List<int[]> re = get(r, s);
            System.out.println("Case #" + (i+1) + ": " + re.size());
            for (int[] e : re) System.out.println(e[0] + " " + e[1]);
        }
    }
    static Map<Integer, List<int[]>> dp = new HashMap<>();
    private static List<int[]> get(int r, int s) {
        if (r == 1) return new LinkedList<>();
        int index = r*100 + s ;
        if (dp.containsKey(index)) return dp.get(index);
        List<int[]> re = new LinkedList<>();
        for (int i = s-1; i > 0; i--) {
            re.add(new int[]{r*i-1, 1});
        }
        re.addAll(get(r-1, s));
        dp.put(index, re);
        return re;
    }


}
