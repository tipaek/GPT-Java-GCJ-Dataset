
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test = in.nextInt();
    for(int i=1;i<=test;++i){
      int size = in.nextInt();
      int trace=0;
      int row=0;
      int col=0;
      int[] sumRow=new int [size];
      int[] sumCol=new int [size];
      int[][] matrix = new int[size][size];
      int compare = recSize(size);
      for(int a=0; a<size; ++a){
        for(int b=0; b<size; ++b){
          int elem = in.nextInt();
          matrix[a][b]= elem;
          sumRow[a] += elem;
          sumCol[b] += elem;
        };
        trace += matrix[a][a];
      };
      for(int c=0; c<size; ++c){
        if(compare != sumRow[c]){
          row += 1;
        } else {
          row += compareArray(matrix[c]);
        };
        if(compare != sumCol[c]){
          col += 1;
        }else {
          col += compareArray(getColumn(matrix, c));
        };
      };
      System.out.println("Case #"+i+": "+trace+" "+row+" "+col);
    };
  };

  static int recSize(int n) {
    if(n == 1) return n;
    return n + recSize(n-1);
  }

  static int compareArray(int[] arr){
    for(int i=0;i<arr.length;++i){
      for(int j=i+1;j<arr.length;++j){
        if(arr[i] == arr[j]) return 1;
      };
    };
    return 0;
  };

  static int[] getColumn(int matrix[][], int col){
    int column[] = new int[matrix.length];
    for(int i=0; i<matrix.length; ++i){
      column[i]=matrix[i][col];
    };
    return column;
  };
};