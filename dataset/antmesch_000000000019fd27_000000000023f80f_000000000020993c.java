   import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) throws Exception {
		  
          
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
			System.out.println("Inizio");
          //int n = in.nextInt();
          //int m = in.nextInt();
          String output = analizzaTest(in);
          System.out.println("Case #" + i + ": " + output);
        }
      }
      
      public static String analizzaTest(Scanner in){
          int size = in.nextInt();
          int[][] square = new int[size][size];
          int k = 0;
          int r = 0;
          int c = 0;
          for (int x = 0; x<size;x++){
            for (int y = 0; y<size;y++){
              square[x][y] = in.nextInt();
            }
          }
		  
		  
		  
			  
          boolean riga = false;
          int precRiga = 0;
          boolean col = false;
          int precCol = 0;
          for(int i = 0;i<square[0].length;i++){
			  //System.out.println("inizio " + i);
              k+= square[i][i];
              precRiga = square[i][0];
              precCol = square[0][i];
              for(int j = 0;j<square[0].length;j++){
			  //System.out.println("valore " +square[i][j] + " precRiga "+precRiga);
			  if(j!=0){
                  if(precRiga==square[i][j]){
                      riga = true;
                  }precRiga=square[i][j];
                  if(precCol==square[j][i]){
                     col = true;
                  }
					 precCol=square[j][i];
			  }
              }
			  //System.out.println("i="+i);
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
          for(int i = 0;i<arr.length;i++){
              sum+= arr[i][i];
              precRiga = arr[i][0];
              precCol = arr[0][i];
              for(int k = 0;k<arr.length;k++){
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