import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int matrixSize = scanner.nextInt();
                int trace = 0;
                final Set<Integer>[] rowSets = initializeSets(matrixSize);
                BitSet rowDuplicates = new BitSet(matrixSize);
                final Set<Integer>[] columnSets = initializeSets(matrixSize);
                BitSet columnDuplicates = new BitSet(matrixSize);

                for (int row = 0; row < matrixSize; row++) {
                    for (int col = 0; col < matrixSize; col++) {
                        int value = scanner.nextInt();
                        if (!rowSets[row].add(value)) rowDuplicates.set(row);
                        if (!columnSets[col].add(value)) columnDuplicates.set(col);

                        if (row == col) trace += value;
                    }
                }

                System.out.printf("Case %d: %d %d %d%n", testCase, trace, rowDuplicates.cardinality(), columnDuplicates.cardinality());
            }
        }
    }

    private static Set<Integer>[] initializeSets(int size) {
        Set<Integer>[] sets = new Set[size];
        for (int i = 0; i < size; i++) {
            sets[i] = new HashSet<>();
        }
        return sets;
    }
}