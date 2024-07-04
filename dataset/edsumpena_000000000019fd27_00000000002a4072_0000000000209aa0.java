import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
      int n = in.nextInt();
      int k = in.nextInt();
      
      int[][] square = generateNLS(n, k);
      
      String squareStr = null;
      if(square != null){
          squareStr = "";
      for(int i = 0; i < square.length; i++){
          for(int j = 0; j < square[i].length; j++){
              squareStr += square[i][j] + " ";
          }
          squareStr += "\n";
      }
      }
      
      System.out.println("Case #" + x + ": " + ((squareStr == null) ? "IMPOSSIBLE" : "POSSIBLE"));
      
      if(squareStr != null)
        System.out.println(squareStr);
    }
  }
  
  private static int[][] generateNLS(int n, int k){
    if(n + 1 == k)
        return null;
    int[] center = new int[n];
    
    for(int i = 0; i < center.length; i++)
        center[i] = (k / n) + k % (n - i);
        
    int[][] latinSquare = new int[n][n];
    
    for(int i = 0; i < latinSquare.length; i++)
        latinSquare[i][i] = center[i];
        
    for(int i = 0; i < latinSquare.length; i++){
        latinSquare[i] = generateValidRow(latinSquare, i, n);
    }
    
    return latinSquare;
  }
  
  private static int[] generateValidRow(int[][] latinSquare, int r, int n){
      ArrayList<Integer> possibleVals = new ArrayList<>();
      int[] row = latinSquare[r];
            
      for(int i = 0; i < row.length; i++){
          possibleVals.clear();
          for(int j = n; j >= 1; j--)
            possibleVals.add(j);
          int[] c = getColumn(latinSquare, i);
          int zeros = 0;
          int zIndex = 0;
          
          for(int j = 0; j < c.length; j++)
            if(c[j] == 0){
                zeros += 1;
                zIndex = j;
            }
                
                //System.out.println(Arrays.toString(c));
          
          if(zeros == 1 && zIndex == r){
            for(int j = 0; j < c.length; j++){
                //System.out.println(possibleVals + ", " + c[j]);
                if(possibleVals.contains(c[j]))
                possibleVals.remove(possibleVals.indexOf(c[j]));
            }
            if(!possibleVals.isEmpty())
                row[i] = possibleVals.get(0);
          }
      }
      
      possibleVals.clear();
      for(int i = n; i >= 1; i--)
            possibleVals.add(i);
            
      for(int i : row)
        if(possibleVals.contains(i))
            possibleVals.remove(possibleVals.indexOf(i));
        
      for(int i = 0; i < row.length; i++){
          if(row[i] == 0){
          int[] c = getColumn(latinSquare, i);
          for(int j = 0; j < possibleVals.size(); j++){
              //System.out.println(possibleVals);
              boolean contains = false;
              for(int k = 0; k < c.length; k++)
                if(possibleVals.get(j) == c[k])
                    contains = true;
              if(!contains){
                  row[i] = possibleVals.remove((int) j);
                  break;
              }
          }
          }
      }
      return row;
  }
  
  private static int[] getColumn(int[][] latinSquare, int col){
      int[] column = new int[latinSquare.length];
      for(int i = 0; i < latinSquare.length; i++){
          column[i] = latinSquare[i][col];
      }
      return column;
  }
}