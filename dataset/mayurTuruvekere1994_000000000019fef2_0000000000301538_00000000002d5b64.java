import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int k = 0; k < T; k++) {
            List<Map.Entry<Integer, Integer>> list = new LinkedList<>();
            int R = in.nextInt();
            int S = in.nextInt();
            for (int i = 1; i <= S; i++) {
                for (int j = 1; j <= R; j++) {
                    list.add(new AbstractMap.SimpleEntry<>(j, i));
                }
            }
            int x = (int) (Math.log((R * S) - 1) / Math.log(2));
            System.out.println("Case #" + (k + 1) + ": " + x);
            S = (((R * S) - R) - 1);
            for (int i = 0; i < x; i++) {
                System.out.println(R + " " + S);
                if (R >= S) {
                    R = R - 1;
                    S = S - 1;
                } else {
                    S = S - 1;
                }
            }
        }
    }
}
