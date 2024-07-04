
import java.io.*;
import java.util.*;

public class PartFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Solution p = new Solution();

        int numTest = Integer.valueOf(line);
        for (int i = 0; i < numTest; i++) {
            String[] each = br.readLine().split(" ");
            int dimension = Integer.valueOf(each[0]);
            int trace = Integer.valueOf(each[1]);
            p.latinMatrix(dimension, trace, i+1);
        }
    }

    private void combination(int trace, int[] current, int index, int count, List<List<Integer>> result) {
        if (index >= current.length) {
            if (trace == 0 && count == 0) {
                add(current, result);
            }
        }
        else {
            for (int i = 0; i <= count; i++) {
                current[index] = i;
                combination(trace - i * (index + 1), current, index + 1, count - i, result);
            }
        }

    }

    private void add(int[] current, List<List<Integer>> result) {
        List<Integer> curr = new ArrayList<>();
        for (int i = 0; i < current.length; i++) {
            curr.add(current[i]);
//            System.out.println((i + 1) +  " " + current[i]);
        }
        result.add(curr);
    }

    private List<List<Integer>> combinationCall(int dimension, int trace) {
//        System.out.println(dimension  + " trace " + trace);
        List<List<Integer>> result = new ArrayList<>();
        int[] current = new int[dimension];
        combination(trace, current, 0, dimension, result);
        return result;
    }

    private List<List<Integer>> convert(List<List<Integer>> input) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < input.get(i).size(); j++) {
                for (int k = 0; k < input.get(i).get(j); k++) {
                    current.add(j + 1);
                }
            }
            result.add(current);
        }
        return result;
    }

    private void latinMatrix(int dimension, int trace, int num) {
        String output = "Case #" + num + ": ";
        System.out.print(output);
        List<List<Integer>> result = combinationCall(dimension, trace);
        List<List<Integer>> input = convert(result);
        boolean found = false;
        for (int i = 0; i < input.size(); i++) {
            int[][] matrix = new int[dimension][dimension];
            for (int j = 0; j < dimension; j++) {
                matrix[j][j] = input.get(i).get(j);
            }
//            System.out.println(matrix);

            List<Set<Integer>> row = new ArrayList<>();
            List<Set<Integer>> col = new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                Set<Integer> currRow = new HashSet<>();
                Set<Integer> currCol = new HashSet<>();
                currRow.add(matrix[j][j]);
                currCol.add(matrix[j][j]);
                row.add(currRow);
                col.add(currCol);
            }
            if (check(matrix, 0, 0, row, col)) {
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("IMPOSSIBLE");
        }
    }

    private boolean check(int[][] matrix, int i, int j, List<Set<Integer>> row, List<Set<Integer>> col) {
        if (i == matrix.length) {
            System.out.println("POSSIBLE");
            // print out result
            for (int m = 0; m < matrix.length; m++) {
                for (int n = 0; n < matrix.length; n++) {
                    System.out.print(matrix[m][n] + " ");
                }
                System.out.println(" ");
            }
            return true;
        }
        else {
            if (i != j) {
                for (int k = 1; k <= matrix.length; k++) {
                    if (row.get(i).contains(k) || col.get(j).contains(k)) {
                        continue;
                    }
                    else {
                        Set<Integer> curRow = row.get(i);
                        Set<Integer> curCol = col.get(j);
                        curRow.add(k);
                        curCol.add(k);
                        row.set(i, curRow);
                        col.set(j, curCol);
                        matrix[i][j] = k;
                        if (j == matrix.length - 1) {
                            if (check(matrix, i + 1, 0, row, col)) {
                                return true;
                            }
                        }
                        else {
                            if (check(matrix, i, j + 1, row, col)) {
                                return true;
                            }
                        }
                        curRow.remove(k);
                        curCol.remove(k);
                        row.set(i, curRow);
                        col.set(j, curCol);
                    }
                }
            }
            else {
                if (j == matrix.length - 1) {
                    if (check(matrix, i + 1, 0, row, col)) {
                        return true;
                    }
                }
                else {
                    if (check(matrix, i, j + 1, row, col)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}


//2 1 1
//  2
//    2