import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
                int n = in.nextInt();
              
                int rows[][] = new int[n][n];
                int cols[][] = new int[n][n];
                boolean rows_repeat[] = new boolean[n];
                boolean cols_repeat[] = new boolean[n];
                int trace = 0;
                int r = 0, c = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int br = in.nextInt();
                       
                        if (!rows_repeat[i]) {
                            if (rows[i][br-1] == 1) {
                                rows_repeat[i] = true;
                                r++;
                            }
                            else{
                                rows[i][br-1] = 1;
                            }
                        }
                        if (!cols_repeat[j]) {
                            if (cols[j][br-1] == 1) {
                                cols_repeat[j] = true;
                                c++;
                            }
                            else{
                                cols[j][br-1] = 1;
                            }
                        }
                        if(i==j){
                            trace+=br;
                        }

                    }
                }
                
                System.out.println("Case #" + k + ": " + trace + " " + r + " " + c);
            }
      }
    }