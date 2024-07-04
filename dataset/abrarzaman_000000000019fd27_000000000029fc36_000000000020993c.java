import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int z = 0; z<t; z++){
            StringTokenizer rt = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(rt.nextToken());
            int[][] arr = new int[n][n];
            int trace = 0;
            for (int i = 0; i<n; i++){
                StringTokenizer tt = new StringTokenizer((in.readLine()));
                for (int j = 0; j<n; j++){
                    arr[i][j] = Integer.parseInt(tt.nextToken());
                    if (i == j){
                        trace += arr[i][j];
                    }
                }
            }
            int cols = 0;
            int rows = 0;
            boolean[] row = new boolean[n];
            boolean[] col = new boolean[n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    for(int q = i + 1; q < n; q++){
                        if(arr[q][j] == arr[i][j] && !col[j]){
                            col[j] = true;
                            break;
                        }
                    }
                }
                for(int j = 0; j < n; j++){
                    for(int v = j + 1; v < n; v++){
                        if(arr[i][v] == arr[i][j] && !row[i]){
                            row[i] = true;
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i<n; i++){
                if (row[i]){
                    rows++;
                }
                if (col[i]){
                    cols++;
                }
            }
            System.out.println("Case #" + (j+1) + ": " + trace +" " + rows + " " + cols);
        }
    }
}
