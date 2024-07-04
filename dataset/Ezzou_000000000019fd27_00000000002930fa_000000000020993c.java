import java.util.*;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        algooo();
    }
    
    static void algooo() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = s.nextInt();
            HashSet[] sets = new HashSet[N];
            int trace = 0;
            int rows = 0;
            int cols = 0;

            for (int j = 0; j < N; j++) {
                sets[j] = new HashSet<>();
            }

            for (int j = 0; j < N; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowReapet = false;

                for (int k = 0; k < N; k++) {
                    int p = s.nextInt();
                    if(j == k) trace += p;

                    if(rowSet.contains(p) && !rowReapet) {
                        rowReapet = true;
                        rows++;
                    }
                    else {
                        rowSet.add(p);
                    }

                    HashSet colSet = sets[k];

                    if(colSet != null && colSet.contains(p)) {
                        cols++;
                        sets[k] = null;
                    }
                    else {
                        if(colSet != null) colSet.add(p);
                    }

                }
            }
            System.out.print(String.format("Case #%d: %d %d %d\n", i, trace, rows, cols));
        }
    }
}