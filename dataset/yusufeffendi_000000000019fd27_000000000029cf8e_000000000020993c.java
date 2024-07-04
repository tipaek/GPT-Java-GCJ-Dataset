import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int trace = 0, r, c, con;
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

            //loop trace
            for (int l = 0; l < t; l++){
                int tc = 0;
                trace = 0;
                for (int j = 0; j < n; j++){
                    trace = trace + m[j][tc];
                    tc++;
                }
            }

            //loop row
            r = 0;
            for (int j = 0; j < n; j++){
                con = 1;
                for (int k = 0; k < n-1; k++){
                    if(m[j][k] == m[j][k+con]){
                        r++;
                        con = 1;
                        break;
                    }
                    else{
                        if (k+con+1 >= n)
                            con = 1;
                        else{
                            con++;
                            k--;
                        }
                    }
                }
            }

            //loop column
            c = 0;
            for (int k = 0; k < n; k++){
                con = 1;
                for (int j = 0; j < n-1; j++){
                    if(m[j][k] == m[j+con][k]){
                        c++;
                        con = 1;
                        break;
                    }
                    else{
                        if (j+con+1 >= n)
                            con = 1;
                        else{
                            con++;
                            j--;
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
 }
}