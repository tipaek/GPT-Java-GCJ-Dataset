import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            solve(reader, i + 1);
        }
    }

    static void solve(BufferedReader reader, int caseNum) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        System.out.printf("Case #%d:%n", caseNum);

        if (N == 1) {
            System.out.printf("1 1%n");
            return;
        }

        int maxRows = 40;
        Set<Integer> flip = new HashSet<>();
        boolean solutionFound = false;

        for (int rows = 1; rows <= Math.min(N, maxRows) && !solutionFound; rows++) {
            for (int numFlips = 0; numFlips <= rows && !solutionFound; numFlips++) {
                int target = N - rows + numFlips;
                if (target < 0) continue;

                flip.clear();
                int copy = target;
                int bitPosition = 1;

                while (copy > 0) {
                    if ((copy & 1) == 1) {
                        flip.add(bitPosition);
                    }
                    copy >>= 1;
                    bitPosition++;
                }

                if (flip.size() == numFlips && bitPosition <= rows) {
                    solutionFound = true;
                    boolean left = true;

                    for (int i = 1; i <= rows; i++) {
                        if (flip.contains(i)) {
                            if (left) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.printf("%d %d%n", i, j);
                                }
                            } else {
                                for (int j = i; j >= 1; j--) {
                                    System.out.printf("%d %d%n", i, j);
                                }
                            }
                            left = !left;
                        } else {
                            System.out.printf("%d %d%n", i, left ? 1 : i);
                        }
                    }
                }
            }
        }
    }
}