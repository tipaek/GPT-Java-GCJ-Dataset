import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int numRows = in.nextInt();
      int counter = 1;
      int trace;
      HashSet<String>[] cols = new HashSet<String>[numRows];
      HashSet<String> rowCheck = new HashSet<String>();
      int rowDups;
      int colDups;
      int rowisDup;
      for (int x = 1; x < numRows; x++) { 
          int current = in.nextInt();
          //Trace calc
          if (counter%numRows == 1){
              trace = trace + current;
          }
          //Row Dups calc
          if (count%numRows == 1) {
              rowIsDup = 0;
              rowCheck = null;
          } else if (rowIsDup != 1) {
              Boolean isUniRow = rowCheck.add(current);
              if(!isUniRow){
                  rowDups++;
                  rowIsDup = 1;
              }
          }
          
          //col Dups Calc
          if (!cols[count%numRows].contains(-1)){
              Boolean isUni = cols[count%numRows].add(current);
            if(!isUni){
                colDups++;
                cols[count%numRows].add(-1);
            }          
          }
          counter++;
      }
      System.out.println("Case #" + i + ": " + trace + " " + rowDups + " " + colDups);
    }
  }
} 