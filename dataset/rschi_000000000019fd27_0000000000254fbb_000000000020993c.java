import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int a = 1; a <= t; ++a) {
      int n = in.nextInt();
      final SquareMatrix sm = new SquareMatrix(a, n);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {

          sm.setValue(i, j, in.nextInt());
        }
      }
      PrintMatrix.print(sm);
    }
  }
}

class SquareMatrix {

  public int id;
  int[][] rowVals;
  int[][] colVals;
  int trace = 0;
  int repRows = 0;
  int repCols = 0;


  public SquareMatrix(int id, int size) {
    this.id = id;
    rowVals = new int[size][size + 1];
    colVals = new int[size][size + 1];
  }

  void setValue(int i, int j, int value) {
    if (i == j) {
      trace += value;
    }
    checkRows(i, value);
    checkCols(j, value);
  }

  private void checkCols(int i, int value) {
    if(duplicationCount(i, value, colVals)) repCols++;
  }

  private void checkRows(int i, int value) {
    if(duplicationCount(i, value, rowVals)) repRows++;
  }


  private boolean duplicationCount(int i, int value, int[][] array) {
    if (array[i][0] == 0) {
      if (array[i][value] == value) {
        array[i][0] = 1;
        return true;
      }else{
        array[i][value] = value;
        return false;
      }
    }
    return false;
  }


}

class PrintMatrix {


  static void print(SquareMatrix sm) {
    System.out.println("Case #" + sm.id + ": " + sm.trace + " " + sm.repRows + " " + sm.repCols);
  }


}

