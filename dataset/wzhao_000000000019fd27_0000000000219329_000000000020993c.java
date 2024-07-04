import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(input.readLine());
            int[][] grid = new int[N][N];
            //int[][] grid2 = new int[N][N];
            for(int n = 0; n<N; n++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                for(int m = 0; m<N; m++){
                    grid[n][m] = Integer.parseInt(st.nextToken());
                }
            }
            //trace
            int k = 0;
            for(int i = 0; i<N; i++){
                k+=grid[i][i];
            }

            //rows
            int rcount = 0;
            int[] tracker = new int[N+1];
            for(int i = 0; i<N; i++){
                Arrays.fill(tracker, 0);
                for(int j = 0; j<N; j++){
                    if(tracker[grid[i][j]]!=0){
                        rcount++;
                        break;
                    }
                    else tracker[grid[i][j]] = 1;
                }
            }

            //columns
            int ccounter = 0;
            for(int j = 0; j<N; j++){
                Arrays.fill(tracker, 0);
                for(int i = 0; i<N; i++){
                    if(tracker[grid[i][j]]!=0){
                        ccounter++;
                        break;
                    }
                    else tracker[grid[i][j]] = 1;
                }
            }

            output.println("Case #" + (t+1) + ": " + k + " " + rcount + " " + ccounter);
        }
        output.flush();
        output.close();
    }
}