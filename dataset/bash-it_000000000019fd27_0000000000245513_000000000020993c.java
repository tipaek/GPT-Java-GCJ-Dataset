import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int z = 1; z <= t; ++z) {
      int size = in.nextInt();
      int sum = 0;
      int rowMatch = 0;
      int columnMatch = 0;
      int[][] matrix = new int[size][size];
      String[] line;
      for(int i = 0; i < size; i++){
          line = in.nextLine().split(" ");
          for(int c = 0; c < size; c++){
              int num = Integer.parseInt(line[c]);
              //final int colNum = c;
              matrix[i][c] = num;
              //if(Arrays.asList(matrix[i]).contains(num)) rowMatch++;
              //if(Arrays.asList(Arrays.stream(matrix).map(o -> o[colNum]).toArray()).contains(num)) columnMatch++;
              if(i == c) sum += num;
          }
      }
      System.out.println("Case #" + z + ": " + sum + " " + rowMatch + " " + columnMatch);
    }
  }
}