    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // num of tests
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt(); //size of square matrix
          int[][] matrix = new int[n][n];
          int trace = 0;
          int rcount = 0;
          int ccount = 0;
          for(int r=0; r<n; r++){
              for(int c=0; c<n; c++){
                  matrix[r][c] = in.nextInt();//read values of matrix
                  if(r==c){
                      trace += matrix[r][c];
                  }
              }
          }//end matrix read
          
          //find number of duplicate rows
          HashSet<Integer> rowSet = new HashSet<Integer>();
          for(int k=0; k<n; k++){
              for(int l=0; l<n; l++){
                  rowSet.add(matrix[k][l]);
              }
              if(rowSet.size()<n){
                  rcount++;
              }
              rowSet = new HashSet<Integer>();
          }
          
          //find number of duplicate cols
          HashSet<Integer> colSet = new HashSet<Integer>();
          for(int k=0; k<n; k++){
              for(int l=0; l<n; l++){
                  colSet.add(matrix[l][k]);
              }
              if(colSet.size()<n){
                  ccount++;
              }
              colSet = new HashSet<Integer>();
          }
          
          System.out.println("Case #" + i + ": "+ trace + " " + rcount +" " + ccount);
        }
      }
      
      
    }