import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numberOfLines = scanner.nextInt();

        for (int i = 0; i < numberOfLines; i++) {
            int size = scanner.nextInt();
            int targetDiagonalSum = scanner.nextInt();

            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = (col + row) % size + 1;
                }
            }

            ArrayList<ArrayList<int[]>> permutations = permute(matrix);

            boolean found = false;
            int index = 0;

            while (index < permutations.size() && !found) {
                if (getDiagonalSum(permutations.get(index)) == targetDiagonalSum) {
                    found = true;
                } else {
                    index++;
                }
            }

            if (found) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        System.out.print(permutations.get(index).get(row)[col]);
                        if (col + 1 < size) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    public static ArrayList<ArrayList<int[]>> permute(int[][] matrix) {
        ArrayList<ArrayList<int[]>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int[] row : matrix) {
            ArrayList<ArrayList<int[]>> current = new ArrayList<>();

            for (ArrayList<int[]> perm : result) {
                for (int j = 0; j <= perm.size(); j++) {
                    ArrayList<int[]> temp = new ArrayList<>(perm);
                    temp.add(j, row);
                    current.add(temp);
                }
            }

            result = new ArrayList<>(current);
        }

        return result;
    }

    public static int getDiagonalSum(ArrayList<int[]> matrix) {
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

    public static int[][] generatePermutations(int n) {
        int[][] permutations = new int[factorial(n)][n];
        for (int i = 0; i < n; i++) permutations[0][i] = i;

        for (int i = 1; i < permutations.length; i++) {
            permutations[i] = Arrays.copyOf(permutations[i - 1], n);
            int k, l;
            for (k = n - 2; permutations[i][k] >= permutations[i][k + 1]; k--);
            for (l = n - 1; permutations[i][k] >= permutations[i][l]; l--);
            swap(permutations[i], k, l);
            for (int j = 1; k + j < n - j; j++) swap(permutations[i], k + j, n - j);
        }
        return permutations;
    }

    private static void swap(int[] array, int k, int l) {
        int temp = array[k];
        array[k] = array[l];
        array[l] = temp;
    }
}