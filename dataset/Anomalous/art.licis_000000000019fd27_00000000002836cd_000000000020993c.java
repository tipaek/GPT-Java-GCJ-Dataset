import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int diagonalSum = 0;

            Set<Integer>[] rowSets = initializeSets(matrixSize);
            BitSet rowDuplicates = new BitSet(matrixSize);
            Set<Integer>[] colSets = initializeSets(matrixSize);
            BitSet colDuplicates = new BitSet(matrixSize);

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int number = scanner.nextInt();

                    if (!rowSets[row].add(number)) {
                        rowDuplicates.set(row);
                    }
                    if (!colSets[col].add(number)) {
                        colDuplicates.set(col);
                    }

                    if (row == col) {
                        diagonalSum += number;
                    }
                }
            }

            System.out.printf("Case %d: %d %d %d%n", testCase, diagonalSum, rowDuplicates.cardinality(), colDuplicates.cardinality());
        }
        scanner.close();
    }

    private static Set<Integer>[] initializeSets(int size) {
        Set<Integer>[] sets = new Set[size];
        for (int i = 0; i < size; i++) {
            sets[i] = new HashSet<>();
        }
        return sets;
    }
}