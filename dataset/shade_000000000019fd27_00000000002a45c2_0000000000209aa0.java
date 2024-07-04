import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTestCases = scanner.nextInt();

        for (int testcase = 0; testcase < numOfTestCases; testcase++) {
            int matrixSize = scanner.nextInt();
            int trace = scanner.nextInt();
            String result;
            Pair ans = isTracePossible(trace, matrixSize);

            if (ans.snd) {
                result = "POSSIBLE";
                System.out.println("Case #" + (testcase + 1) + ": " + result);
                for (int a = 0; a < matrixSize; a++) {
                    for (int b = 0; b < matrixSize; b++) {
                        System.out.print(ans.fst[a][b]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            } else {
                result = "IMPOSSIBLE";
                System.out.println("Case #" + (testcase + 1) + ": " + result);
            }
        }
    }

    private static int[][] getRowMatrices(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize+1]; // the extra one cell in each row is used to store the index position.

        for (int i = 0; i < matrixSize; i++) {
            matrix[0][i] = i + 1; // first row
        }
        matrix[0][matrixSize] = 0;

        for (int row = 1; row < matrixSize; row++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[row][j] = matrix[row-1][((j+1)%matrixSize)];
            }
            matrix[row][matrixSize] = row;
        }

        return matrix;
    }

    private static Pair isTracePossible(int trace, int matrixSize) {
        int[][] matrix = getRowMatrices(matrixSize);
        int[] arr = new int[matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            arr[i] = i;
        }
        List<List<Integer>> permutation = permute(arr);
        for(List<Integer> perm:permutation)
        {
            int traceElement = 0;

            for (int a = 0; a < perm.size(); a++) {
                int rowNo = perm.get(a);
                traceElement += matrix[rowNo][a];
            }
            if (trace == traceElement) {
                int[][] ans = getMatrix(perm, matrix);
                return new Pair(ans, true);
            }
        }
        return new Pair(null, false);
    }

    private static int[][] getMatrix(List<Integer> permutation, int[][] matrix) {
        int permLength = permutation.size();
        int[][] resultMatrix = new int[permLength][permLength];
        for(int a = 0; a < permLength; a++) {
            int index = permutation.get(a);

            for (int i = 0; i < permLength; i++) {
                if (matrix[i][permLength] == index) {
                    for (int j = 0; j < permLength; j++) {
                        resultMatrix[a][j] = matrix[i][j];
                    }
                }
            }
        }
        return resultMatrix;
    }

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        permutationHelper(list, new ArrayList<>(), arr,new boolean[arr.length]);
        return list;
    }

    private static void permutationHelper(List<List<Integer>> list, List<Integer> resultList, int [] arr, boolean [] used){

        // Base case
        if(resultList.size() == arr.length){
            list.add(new ArrayList<>(resultList));
        } else{
            for(int i = 0; i < arr.length; i++){
                if(used[i] || i > 0 && arr[i] == arr[i-1] && !used[i - 1])
                {
                    // If element is already used
                    continue;
                }
                // choose element
                used[i] = true;
                resultList.add(arr[i]);

                permutationHelper(list, resultList, arr, used);
                used[i] = false;
                resultList.remove(resultList.size() - 1);
            }
        }
    }

    static class Pair {
        int[][] fst;
        boolean snd;
        Pair(int[][] first, boolean second) {
            this.fst = first;
            this.snd = second;
        }
    }
}