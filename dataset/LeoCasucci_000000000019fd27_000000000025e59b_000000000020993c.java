import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int testNumber = in.nextInt(); 
    
    for (int i = 1; i <= testNumber; ++i) {
      
        // test matrix i
      
        int dimensione = in.nextInt();
        int[][] testMatrix = new int[dimensione][dimensione];
      
        for (int x = 0; x < dimensione; x++) {
            for (int y = 0; y < dimensione; y++) {
                testMatrix[x][y] = in.nextInt();
                System.out.println(testMatrix[x][y]);
            }
        }
    }
  }
}