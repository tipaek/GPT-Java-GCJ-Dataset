import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

  public static void main(String[] arg) {
    // For each test case, output one line containing Case #x: k r c, where x is the test case
    // number (starting from 1), k is the trace of the matrix, r is the number of rows of the matrix
    // that contain repeated elements, and c is the number of columns of the matrix that contain
    // repeated elements.

    Scanner scanner = new Scanner(System.in);
    try {
      int testCases = Integer.valueOf(scanner.nextLine());
      ArrayList<ArrayList<ArrayList<Integer>>> matrices = new ArrayList<>();
      for (int i = 0; i < testCases; i++) {
        int matrixDimension = Integer.valueOf(scanner.nextLine());
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int j = 0; j < matrixDimension; j++) {
          ArrayList<Integer> row = new ArrayList<>();
          String in = scanner.nextLine();
          String[] rowStr = in.split("\\s+");

          for (String s : rowStr) {
            row.add(Integer.valueOf(s));
          }
          matrix.add(row);
        }
        matrices.add(matrix);
      }
      for (int i = 0; i < testCases; i++) {
        solveMatrix(matrices.get(i), i + 1);
      }
      ;
    } catch (Exception e) {
      System.out.println(String.format("Error: %s", e.getMessage()));
    } finally {
      scanner.close();
    }
  }

  private static void solveMatrix(ArrayList<ArrayList<Integer>> matrix, int caseNum) {

    int dimension = matrix.size();
    ArrayList<ArrayList<Integer>> invertedMatrix = invertMatrix(matrix, dimension);

    int r = findRepeatedRows(matrix, dimension);
    int c = findRepeatedRows(invertedMatrix, dimension);

    int k = 0;
    for (int rowInd = 0; rowInd < dimension; rowInd++) {
      k = k + matrix.get(rowInd).get(rowInd);
    }

    System.out.printf("Case #%d: %d %d %d\n", caseNum, k, r, c);
  }

  private static int findRepeatedRows(ArrayList<ArrayList<Integer>> matrix, int dimension) {
    int r = 0;
    for (int rowInd = 0; rowInd < dimension; rowInd++) {
      ArrayList<Integer> row = matrix.get(rowInd);
      HashSet<Integer> rowHash = new HashSet<>();
      for (int colInd = 0; colInd < dimension; colInd++) {
        int e = row.get(colInd);
        if (rowHash.contains(e)) {
          r++;
          break;
        }
        if (rowHash.isEmpty() || !rowHash.contains(e)) {
          rowHash.add(e);
        }
      }
    }
    return r;
  }

  private static ArrayList<ArrayList<Integer>> invertMatrix(
      ArrayList<ArrayList<Integer>> matrix, int dimension) {
    // initialise the invertedMatrix
    ArrayList<ArrayList<Integer>> invertedMatrix = new ArrayList<>();
    for (int colInd = 0; colInd < dimension; colInd++) {
      invertedMatrix.add(new ArrayList<>());
    }

    for (int rowInd = 0; rowInd < dimension; rowInd++) {
      ArrayList<Integer> row = matrix.get(rowInd);
      for (int colInd = 0; colInd < dimension; colInd++) {
        int e = row.get(colInd);
        ArrayList<Integer> invertedRow = invertedMatrix.get(colInd);
        invertedRow.add(rowInd, e);
      }
    }
    return invertedMatrix;
  }
}
