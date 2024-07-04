import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class App {

  private static Scanner sc;

  public static void main(String[] args){
    App app = new App();
    sc = new Scanner(System.in);

    int T = getValue();

    List<int [][]> testCases = new ArrayList();
    for (int i = 0; i < T; i++) {
      int N = getValue();
      testCases.add(app.latinSquareInit(N));
    }
    app.initTestCase(testCases);
  }

  private static int getValue() {
    return sc.nextInt();
  }

  public void initTestCase(List<int [][]> testCases){
    int caseN = 1;
    for (int [][] testCase : testCases) {
      solve(caseN++, testCase, testCase.length);
    }
  }

  public int [][] latinSquareInit(int N) {
    int [][] latinSquare = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        latinSquare[i][j] = getValue();
      }
    }
    return latinSquare;
  }

  public void solve(int caseN, int [][] latinSquare, int N){
    int traceTotal = 0;
    int r = 0;
    int c = 0;
    traceTotal = getTraceTotal(latinSquare, N, traceTotal);
    for (int i = 0; i < N ; i++) {
      r = checkRepeatedByLine(latinSquare[i].clone(), r);
      c = checkRepeatedByLine(extractColumnLine(latinSquare, i).clone(), c);
    }

    System.out.println("Case #" + (caseN) +": "+  traceTotal + " " + r + " " + c);
  }

  private int [] extractColumnLine(int [][] latinSquare, int colIdx){
    int [] column = new int[latinSquare.length];
    for (int i = 0; i < latinSquare.length; i++) {
      column[i] = latinSquare[i][colIdx];
    }
    return column;
  }

  private int getTraceTotal(int[][] latinSquare, int N, int traceTotal) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if(i == j){
          traceTotal += latinSquare[i][j];
        }
      }
    }
    return traceTotal;
  }



  private int getR(int i, int r, int val, int [] repeatedRows) {

    if(r <= i){
     for (int x = 0; x < repeatedRows.length; x++) {
        if(repeatedRows[x] == val){
          r++;
          break;
        }
        if(repeatedRows[x] == 0){
          repeatedRows[x] = val;
          break;
        }
      }
    }
    return r;
  }


  private int checkRepeatedByLine(int [] line, int count) {
      Arrays.sort(line);
      int previousV = 0;
      for (int x = 0; x < line.length; x++) {
        if(x == 0){
          previousV = line[x];
          continue;
        }
        if(line[x] == previousV){
          count++;
          break;
        }
        previousV = line[x];
      }
    return count;
  }

}
