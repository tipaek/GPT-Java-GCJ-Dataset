import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = scanner.nextInt();

        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            int size = scanner.nextInt();
            int targetDiagonalSum = scanner.nextInt();

            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = (col + row) % size + 1;
                }
            }

            ArrayList<ArrayList<int[]>> permutations = generatePermutations(matrix);

            boolean found = false;
            int foundIndex = -1;
            for (int i = 0; i < permutations.size(); i++) {
                if (calculateDiagonalSum(permutations.get(i)) == targetDiagonalSum) {
                    found = true;
                    foundIndex = i;
                    break;
                }
            }

            if (found) {
                System.out.println("Case #" + (caseNum + 1) + ": POSSIBLE");
                ArrayList<int[]> resultMatrix = permutations.get(foundIndex);
                for (int[] row : resultMatrix) {
                    for (int col = 0; col < size; col++) {
                        System.out.print(row[col]);
                        if (col < size - 1) System.out.print(" ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (caseNum + 1) + ": IMPOSSIBLE");
            }
        }
    }

    public static ArrayList<ArrayList<int[]>> generatePermutations(int[][] matrix) {
        ArrayList<ArrayList<int[]>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int[] row : matrix) {
            ArrayList<ArrayList<int[]>> current = new ArrayList<>();

            for (ArrayList<int[]> perm : result) {
                for (int j = 0; j <= perm.size(); j++) {
                    ArrayList<int[]> newPerm = new ArrayList<>(perm);
                    newPerm.add(j, row);
                    current.add(newPerm);
                }
            }

            result = current;
        }

        return result;
    }

    public static int calculateDiagonalSum(ArrayList<int[]> matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.size(); i++) {
            sum += matrix.get(i)[i];
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static int[][] generatePermutations(int N) {
        int[][] permutations = new int[factorial(N)][N];
        for (int i = 0; i < N; i++) permutations[0][i] = i;
        for (int i = 1; i < permutations.length; i++) {
            permutations[i] = Arrays.copyOf(permutations[i - 1], N);
            int k, l;
            for (k = N - 2; permutations[i][k] >= permutations[i][k + 1]; k--) ;
            for (l = N - 1; permutations[i][k] >= permutations[i][l]; l--) ;
            swap(permutations[i], k, l);
            for (int j = 1; k + j < N - j; j++) swap(permutations[i], k + j, N - j);
        }
        return permutations;
    }

    private static void swap(int[] array, int k, int l) {
        int temp = array[k];
        array[k] = array[l];
        array[l] = temp;
    }
}