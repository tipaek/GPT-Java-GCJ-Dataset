import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int colRepeat = 0;
            int rowRepeat = 0;
            int totalDiagonal = 0;
            int indexD = 0;

            List<Set<Integer>> colSet = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {

                    int currentVal = in.nextInt();
                    if (k == indexD) {
                        totalDiagonal += currentVal;
                    }
                    rowSet.add(currentVal);

                    if (j == 0) {
                        colSet.add(new HashSet<>());
                    }
                    colSet.get(k).add(currentVal);

                }

                rowRepeat += (rowSet.size() == n) ? 0 : 1;
                indexD++;
            }

            for(Set<Integer> cc : colSet) {
                colRepeat += (cc.size() == n)? 0 : 1;
            }

            System.out.println("Case #" + i + ": " + totalDiagonal + " " + rowRepeat + " " + colRepeat);
        }
    }
}
