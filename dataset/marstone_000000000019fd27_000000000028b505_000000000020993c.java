import java.util.*;

public class Solution {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            int D = in.nextInt();

            int k = 0;
            int r = 0;
            int c = 0;

            Map<Integer, Set<Integer>> colMap = new HashMap<>();
            for(int y = 0; y < D; y++) {
                Set<Integer> rowSet = new HashSet<>();
                for(int x = 0; x < D; x++) {
                    Set<Integer> colSet = colMap.computeIfAbsent(x, key -> new HashSet<>());
                    int i = in.nextInt();
                    if (x == y) {
                        k += i;
                    }
                    rowSet.add(i);
                    colSet.add(i);
                }
                if(rowSet.size() < D) {
                    r++;
                }
            }
            for(Set<Integer> colSet : colMap.values()) {
                if(colSet.size() < D) {
                    c++;
                }
            }
            System.out.format("Case #%d: %d %d %d\n", t, k, r, c);
        }
    }

}
