import java.util.*;
    import java.io.*;
    public class Solution{
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int x = 1; x <= t; ++x) {
          int k = 0;
          int r = 0;
          int c = 0;
          int rans =0;
          int cans =0;
          int n = in.nextInt();
          int[][] matrix = new int[n][n];
          for(int i = 0; i < n; i++){
            HashSet<Integer> rcount = new HashSet();
            for(int j = 0; j <n; j++){
                matrix[i][j] = in.nextInt();
                if(rcount.contains(matrix[i][j])){
//                	System.out.println(i + " " + j + " " + matrix[i][j]);
                    r++;
                }
                rcount.add(matrix[i][j]);
                if(i ==j){
                    k += matrix[i][j];
                }
            }
            if(r >0) {
            	rans++;
            }
            r = 0;
          }
          
          for(int j = 0; j < n; j++){
            HashSet<Integer> ccount = new HashSet();
            for(int i =0; i <n; i++){
                if(ccount.contains(matrix[i][j])){
                    c++;
                }
                ccount.add(matrix[i][j]);
            }
            if(c >0) {
            	cans++;
            }
            c = 0;
          }
          
          System.out.println("Case #" + x + ": " + k + " "+ rans + " " + cans);
        }
      }
    }

