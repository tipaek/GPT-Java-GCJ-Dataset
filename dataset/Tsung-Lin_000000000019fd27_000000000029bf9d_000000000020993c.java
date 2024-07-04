import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases = Integer.parseInt(sc.nextLine());
    for(int c = 1; c <= cases; c++) {
      int n = Integer.parseInt(sc.nextLine());
      int[][] matrix = new int[n][n];
      for(int i = 0; i < n; i++) {
        String[] line = sc.nextLine().split(" ");
        for(int j = 0; j < n; j++) {
          matrix[i][j] = Integer.parseInt(line[j]);
        }
      }
      ans(matrix, n, c);
    }
  }
  private static void ans(int[][] matrix, int n, int c){
    int trace = 0, v = 0, h = 0;
    for(int i = 0; i < n; i++) {
      trace += matrix[i][i];
      HashSet<Integer> vset = new HashSet<>();
      for(int j = 0; j < n; j++) {
        if(vset.contains(matrix[i][j])) {
          v++; 
          break; 
        }
        vset.add(matrix[i][j]);
      }
      HashSet<Integer> hset = new HashSet<>();
      for(int j = 0; j < n; j++) {
        if(hset.contains(matrix[j][i])) {
          h++; 
          break; 
        }
        hset.add(matrix[j][i]);
      }
    }
    System.out.println("Case #" + c + ": " + trace + " " + h + " " + v);
  }
}