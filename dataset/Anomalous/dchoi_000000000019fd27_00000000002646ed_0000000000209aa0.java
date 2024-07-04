import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int targetTrace = scanner.nextInt();

            List<Integer> possibleTraces = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i <= matrixSize; i++) {
                sum += i;
                possibleTraces.add(i * matrixSize);
            }
            if (matrixSize > 2) {
                possibleTraces.add(sum);
            }

            if (possibleTraces.contains(targetTrace)) {
                System.out.println("Case #" + testCase + ": POSSIBLE");

                if (targetTrace % matrixSize != 0) {
                    printMatrix(matrixSize, true);
                    printMatrix(matrixSize, false);
                } else {
                    int start = targetTrace / matrixSize;
                    for (int row = 0; row < matrixSize; row++) {
                        int rowStart = (row == 0) ? start : start + (matrixSize - row);
                        rowStart = rowStart == 0 ? matrixSize : rowStart;
                        StringBuilder rowOutput = new StringBuilder();
                        for (int col = 0; col < matrixSize; col++) {
                            int num = (rowStart + col) % matrixSize;
                            num = num == 0 ? matrixSize : num;
                            rowOutput.append(num).append(" ");
                        }
                        System.out.println(rowOutput.toString().trim());
                    }
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static void printMatrix(int size, boolean forward) {
        StringBuilder base = new StringBuilder();
        if (forward) {
            for (int i = 1; i <= size; i++) {
                base.append(i).append(" ");
            }
        } else {
            for (int i = 0; i < size; i++) {
                base.append(size - i).append(" ");
            }
        }
        for (int i = 0; i < size / 2; i++) {
            int rotationPoint = base.length() - (i * 4) % base.length();
            String rotated = base.substring(rotationPoint) + base.substring(0, rotationPoint);
            System.out.println(rotated);
        }
    }
}