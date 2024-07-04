   import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          //int n = in.nextInt();
          //int m = in.nextInt();
          String output = analizzaTest(in);
          System.out.println("Case #" + i + ": " + output);
        }
      }
      
      public static String analizzaTest(Scanner in){
          int size = in.nextInt();
          int[] square = new int[size][size];
          int k = 0;
          int r = 0;
          int c = 0;
          for (int x = 0; x<size;x++){
            for (int y = 0; y<size;y++){
              square[x][y] = in.nextInt();
            }
          }
          int k = 0;
          int r =0,c = 0;
          boolean riga = false;
          int precRiga = 0;
          boolean col = false;
          int precCol = 0;
          for(int i = 0;i<arr.lenght;i++){
              k+= arr[i][i];
              precRiga = arr[i][0];
              precCol = arr[0][i];
              for(int k = 0;k<arr.lenght;k++){
                  if(precRiga==arr[i][k]){
                      riga = true;
                  }
                  if(precCol==arr[k][i]){
                     col = true;
                  }
              }
              if(riga){
                  r+=1;
              }
              if(col){
                  c+=1;
              }
          }
          
          return k+" "+r+" "+c+" ";
      }
      
      public static int sommaDiagonale(int[][] arr){
          int sum = 0;
          int r =0,c = 0;
          boolean riga = false;
          int precRiga = 0;
          boolean col = false;
          int precCol = 0;
          for(int i = 0;i<arr.lenght;i++){
              sum+= arr[i][i];
              precRiga = arr[i][0];
              precCol = arr[0][i];
              for(int k = 0;k<arr.lenght;k++){
                  if(precRiga==arr[i][k]){
                      riga = true;
                  }
                  if(precCol==arr[k][i]){
                     col = true;
                  }
              }
              if(riga){
                  r+=1;
              }
              if(col){
                  c+=1;
              }
          }
          return sum;
      }
    }