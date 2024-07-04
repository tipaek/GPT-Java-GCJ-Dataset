import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int trace = 0, r, c, next;
        int[][] m;

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            m = new int[n][n];

            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    m[j][k] = in.nextInt();
                }
            }

            //trace
            for (int l = 0; l < t; l++){
                int traceCol = 0;
                trace = 0;
                for (int j = 0; j < n; j++){
                    trace = trace + m[j][traceCol];
                    traceCol++;
                }
            }

            //row
            r = 0;
            for (int j = 0; j < n; j++){
                next = 1;
                for (int k = 0; k < n-1; k++){
                    if(m[j][k] == m[j][k+next]){
                        r++;
                        next = 1;
                        break;
                    }
                    else{
                        if (k+next+1 >= n)
                            next = 1;
                        else{
                            next++;
                            k--;
                        }
                    }
                }
            }

            //column
            c = 0;
            for (int k = 0; k < n; k++){
                next = 1;
                for (int j = 0; j < n-1; j++){
                    if(m[j][k] == m[j+next][k]){
                        c++;
                        next = 1;
                        break;
                    }
                    else{
                        if (j+next+1 >= n)
                            next = 1;
                        else{
                            next++;
                            j--;
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}