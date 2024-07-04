import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int badRows = 0;
      int badCols = 0;
      int trace = 0;
      int mult = 1;
      for (int k=2; k<=n; k++)
      {
          mult = mult*k;
      }
      int[] colMults = new int[n];
      for (int k=0; k< arrOfStr.length; ++k) {
              colMults[k] = 1;
          }
      for (int j =1; j<=n; ++j) {
          String line = in.nextLine();
          String[] arrOfStr = line.split(" ");
          int rowMult = 1;
          for (int k=0; k< arrOfStr.length; ++k) {
              int num = Integer.parseInt(arrOfStr[k]);
              colMults[k] = colMults[k]*num;
              rowMult = rowMult*num;
              if(k==(j-1))
              {
                  trace = trace+num;
              }
          }
          if(rowMult != mult)
          {
              badRows++;
          }
      }
      for (int k=0; k< arrOfStr.length; ++k) {
              if(colMults[k] != mult)
              {
                  badCols++;
              }
          }
      System.out.println("Case #" + i + ": " + trace + " " + badRows + " " + badCols);
    }
  }
}