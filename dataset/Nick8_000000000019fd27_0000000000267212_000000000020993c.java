import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        int[][] arr;
        int[] count = new int[5];
        int j = 0;
        int cast = 0;
        int row = 0, col = 0, trace = 0;
        StringTokenizer tk;
        while(t-- > 0) {
            cast++;
            trace = 0;
            row = 0;
            col = 0;
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                j = 0;
                count = new int[n + 1];
                tk = new StringTokenizer(br.readLine());
                while(tk.hasMoreTokens()) {
                    arr[i][j] = Integer.parseInt(tk.nextToken()); 
                    count[arr[i][j]]++;
                    j++;
                }
                for(j = 1; j <= n; j++) {
                    if(count[j] > 1) {
                        row++;
                        break;
                    }
                }
            }
            
            for(int i = 0; i < n; i++) {
                count = new int[n + 1];
                for(j = 0; j < n; j++) {
                    if(i == j)
                        trace+=arr[i][j];
                    count[arr[j][i]]++;
                }
                for(int k = 1; k <= n; k++) {
                    if(count[k] > 1) {
                        col++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+cast+": "+trace+" "+row+" "+col);
        }
    }
}