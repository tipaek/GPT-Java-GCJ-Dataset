import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    private void generatePermutations(int index, int[] array, List<int[]> permutations) {
        if (index >= array.length) {
            permutations.add(Arrays.copyOf(array, array.length));
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            generatePermutations(index + 1, array, permutations);
            swap(array, i, index);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void processTestCases() {
        int testCaseCount = scanner.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] array = initializeArray(n);
            List<int[]> firstLines = new ArrayList<>();
            generatePermutations(0, array, firstLines);

            boolean found = findSolution(t, n, k, firstLines);
            if (!found) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            }
        }
    }

    private int[] initializeArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    private boolean findSolution(int testCase, int n, int k, List<int[]> firstLines) {
        for (int[] first : firstLines) {
            int[] moves = initializeMoves(n);
            List<int[]> movePermutations = new ArrayList<>();
            generatePermutations(0, moves, movePermutations);

            for (int[] move : movePermutations) {
                if (isSolution(first, move, n, k)) {
                    printSolution(testCase, first, move, n);
                    return true;
                }
            }
        }
        return false;
    }

    private int[] initializeMoves(int n) {
        int[] moves = new int[n - 1];
        for (int i = 1; i < n; i++) {
            moves[i - 1] = i;
        }
        return moves;
    }

    private boolean isSolution(int[] first, int[] move, int n, int k) {
        int sum = first[0];
        for (int i = 0; i < move.length; i++) {
            sum += first[(i + 1 + n - move[i]) % n];
        }
        return sum == k;
    }

    private void printSolution(int testCase, int[] first, int[] move, int n) {
        System.out.printf("Case #%d: POSSIBLE%n", testCase);
        printArray(first);
        for (int mv : move) {
            for (int d = 0; d < n; d++) {
                System.out.print(first[(-mv + n + d) % n] + " ");
            }
            System.out.println();
        }
    }

    private void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Solution().processTestCases();
    }
}