import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            processCase(reader, i + 1);
        }
    }

    static void processCase(BufferedReader reader, int caseNumber) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        System.out.printf("Case #%d:%n", caseNumber);
        
        if (N == 1) {
            System.out.printf("%d %d%n", 1, 1);
        } else {
            int maxRows = 7;
            Set<Integer> flipSet = new HashSet<>();
            boolean solutionFound = false;

            for (int row = 1; row <= Math.min(N, 40) && !solutionFound; row++) {
                for (int numFlips = 0; numFlips <= row && !solutionFound; numFlips++) {
                    int target = N - row + numFlips;
                    if (target < 0) continue;

                    flipSet.clear();
                    int copy = target;
                    int bitPosition = 1;

                    while (copy > 0) {
                        if ((copy & 1) == 1) {
                            flipSet.add(bitPosition);
                        }
                        copy >>= 1;
                        bitPosition++;
                    }

                    if (flipSet.size() == numFlips && bitPosition <= row) {
                        maxRows = row;
                        boolean isLeft = true;

                        for (int i = 1; i <= maxRows; i++) {
                            if (flipSet.contains(i)) {
                                if (isLeft) {
                                    for (int j = 1; j <= i; j++) {
                                        System.out.printf("%d %d%n", i, j);
                                    }
                                } else {
                                    for (int j = i; j >= 1; j--) {
                                        System.out.printf("%d %d%n", i, j);
                                    }
                                }
                                isLeft = !isLeft;
                            } else if (isLeft) {
                                System.out.printf("%d %d%n", i, 1);
                            } else {
                                System.out.printf("%d %d%n", i, i);
                            }
                        }
                        solutionFound = true;
                    }
                }
            }
        }
    }
}