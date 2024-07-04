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
            if (isTracePossible(trace, matrixSize)) {
                result = "POSSIBLE";
            } else {
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #" + (testcase + 1) + ": " + result);
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

    private static boolean isTracePossible(int trace, int matrixSize) {
        int[][] matrix = getRowMatrices(matrixSize);
        int[] arr = new int[matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            arr[i] = i;
        }
        List<List<Integer>> permutation = permute(arr);
        int traceElement = 0;
        for(List<Integer> perm:permutation)
        {
            for (int a = 0; a < perm.size(); a++) {
                int rowNo = perm.get(a);
                traceElement += matrix[rowNo][a];
            }
            if (trace == traceElement) {
                return true;
            }
        }
        return false;
    }

    public static int getTrace(int matrixSize, int[][] matrix) {
        // diagonal elements are where i = j;
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }
        return trace;
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
                    continue;
                }
                used[i] = true;
                resultList.add(arr[i]);

                permutationHelper(list, resultList, arr, used);
                used[i] = false;
                resultList.remove(resultList.size() - 1);
            }
        }
    }
}
