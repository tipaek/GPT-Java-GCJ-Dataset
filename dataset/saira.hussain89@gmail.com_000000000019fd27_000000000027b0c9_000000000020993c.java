import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

  public static void main(String[] arg) {
    // For each test case, output one line containing Case #x: k r c, where x is the test case
    // number (starting from 1), k is the trace of the matrix, r is the number of rows of the matrix
    // that contain repeated elements, and c is the number of columns of the matrix that contain
    // repeated elements.

    Scanner scanner = new Scanner(System.in);
    try {
      int testCases = scanner.nextInt();
      ArrayList<ArrayList<ArrayList<Integer>>> matrices = new ArrayList<>();
      for (int i = 0; i < testCases; i++) {
        int matrixDimension = scanner.nextInt();
        ArrayList<ArrayList<Integer>> matrix = readMatrix(matrixDimension);
        matrices.add(matrix);
      }
      matrices.forEach(matrix -> {
          solveMatrix(matrix, testCases);
      });
    } catch (Exception e) {
      System.out.println(String.format("Error: %s", e.getMessage()));
    } finally {
      scanner.close();
    }
  }

  public static ArrayList<ArrayList<Integer>> readMatrix(int dimension)
      throws IOException, IllegalArgumentException {
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    for (int i = 0; i < dimension; i++) {
      matrix.add(readRow(dimension));
    }

    return matrix;
  }

  public static ArrayList<Integer> readRow(int length)
      throws IOException, IllegalArgumentException {
    ArrayList<Integer> row = new ArrayList<>();
    BufferedReader br = null;

    br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    while (st != null && st.hasMoreElements()) {
      row.add(Integer.valueOf(st.nextToken()));
    }

    if (row.size() != length) {
      throw new IllegalArgumentException(
          String.format("Length of the row entered does not match the expected length %d", length));
    }
    return row;
  }

  public static void solveMatrix(
      ArrayList<ArrayList<Integer>> matrix, int caseNum) {
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

  public static int findRepeatedRows(ArrayList<ArrayList<Integer>> matrix, int dimension) {
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

  public static ArrayList<ArrayList<Integer>> invertMatrix(ArrayList<ArrayList<Integer>> matrix, int dimension) {
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
