import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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
            System.out.printf("%d %d%n", 1, 1);
        } else {
            int maxRows = 7;
            Set<Integer> flipSet = new HashSet<>();
            boolean foundSolution = false;

            for (int rows = 1; rows <= Math.min(N, 40) && !foundSolution; rows++) {
                for (int numFlips = 0; numFlips <= rows && !foundSolution; numFlips++) {
                    int target = N - rows + numFlips;
                    if (target < 0) continue;

                    flipSet.clear();
                    int remaining = target;
                    int currentBit = 1;

                    while (remaining > 0) {
                        if (remaining % 2 == 1) {
                            flipSet.add(currentBit);
                        }
                        remaining /= 2;
                        currentBit++;
                    }

                    if (flipSet.size() == numFlips && currentBit <= rows) {
                        maxRows = rows;
                        boolean leftSide = true;

                        for (int row = 1; row <= maxRows; row++) {
                            if (flipSet.contains(row)) {
                                if (leftSide) {
                                    for (int col = 1; col <= row; col++) {
                                        System.out.printf("%d %d%n", row, col);
                                    }
                                } else {
                                    for (int col = row; col >= 1; col--) {
                                        System.out.printf("%d %d%n", row, col);
                                    }
                                }
                                leftSide = !leftSide;
                            } else if (leftSide) {
                                System.out.printf("%d %d%n", row, 1);
                            } else {
                                System.out.printf("%d %d%n", row, row);
                            }
                        }
                        foundSolution = true;
                    }
                }
            }
        }
    }
}