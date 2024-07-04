import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int trace = 0;
            int numBadRows = 0;
            int numBadCols = 0;
            boolean[] badCol = new boolean[N];
            Arrays.fill(badCol, false);
            HashSet setCol;
            HashSet[] setCols = new HashSet[N];
            for (int i = 0; i < N; i++)
                setCols[i] = new HashSet();
            for (int row = 0; row < N; row++) {
                boolean badRow = false;
                HashSet setRow = new HashSet();
                for (int col = 0; col < N; col++) {
                    int n = in.nextInt();
                    if (col == row)
                        trace += n;
                    if (!badRow) {
                        if (setRow.contains(n)) {
                            badRow = true;
                            numBadRows++;
                        } else 
                            setRow.add(n);
                    }
                    if (!badCol[col]) {
                        setCol = setCols[col];
                        if (setCol.contains(n)) {
                            badCol[col] = true;
                            numBadCols++;
                        } else 
                            setCol.add(n);
                    }
                }
            }
            System.out.println("Case #" + t + ": " + trace + " " + numBadRows + " " + numBadCols);
        }
    }
}