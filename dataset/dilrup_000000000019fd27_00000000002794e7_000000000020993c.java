 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            int dia = 0; int csame = 0; int rsame = 0;
            HashSet<String> colC = new HashSet<String>();
            boolean[] col = new boolean[n];
            for(int j=0; j<n; j++)
            {
                HashSet<Integer> rowC = new HashSet<Integer>();
                boolean row = false;   
                for(int k=0; k<n; k++){
                    int a = in.nextInt();
                    
                    if(rowC.contains(a))
                        row = true;
                    else
                        rowC.add(a);
                        
                    if(colC.contains((char)(k+97)+""+a))
                        col[j] = true;
                    else
                        colC.add((char)(k+97)+""+a); 
                       
                    if(j==k)
                        dia += a;
                }
                if(row)
                    rsame++;
            }
            for(int j=0; j<n; j++){
                if(col[j])
                    csame++;
            }
          System.out.println("Case #" + i + ": " + dia + " " + rsame + " " + csame);
        }
      }
    }