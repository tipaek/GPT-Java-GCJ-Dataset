import java.util.HashSet;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numTest = Integer.parseInt(in.nextLine());

    for (int i=0;i<numTest;i++) {
      int maxSquareVal = Integer.parseInt(in.nextLine());
      int[][] square = new int[maxSquareVal][maxSquareVal];



      for (int j=0;j<maxSquareVal;j++) {
        String row = in.nextLine();
        String[] values = row.split(" ");

        for (int k=0;k<maxSquareVal;k++)
          square[j][k] = Integer.parseInt(values[k]);
      }

      isNaturalLatinSquare(i, maxSquareVal, square);
    }
  }

  private static void isNaturalLatinSquare(int testCaseNumber, int maxNumber, int[][] square) {
    int repeatingRows = 0, repeatingColumns=0, traceVal=0;

    for (int out=0;out<square[0].length;out++) {
      HashSet<Integer> rowResult = new HashSet<>();
      HashSet<Integer> columnResult= new HashSet<>();
      traceVal += square[out][out];

      for (int i=0;i<square[0].length;i++) {
        rowResult.add(square[out][i]);
        columnResult.add(square[i][out]);
      }

      if (rowResult.size() != maxNumber)
        repeatingRows++;

      if (columnResult.size() != maxNumber)
        repeatingColumns++;
    }

    testCaseNumber++;
    System.out.println("Case #" + testCaseNumber + ": " + traceVal + " " + repeatingRows + " " + repeatingColumns);
  }
}
