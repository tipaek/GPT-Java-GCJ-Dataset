import java.io.*;
import java.util.*;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            boolean[] taken = new boolean[N+1];
            int[][] matrix = new int[N][N];
            int trace = 0;
            int rows = 0;
            int cols = 0;
            
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++)
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                trace += matrix[i][i];
            }
            
            for(int i = 0; i < N; i++){
                taken = new boolean[N+1];
                for(int j = 0; j < N; j++){
                    int number = matrix[i][j];
                    if(taken[number]){
                        rows++; j = N;
                    }
                    taken[number] = true;
                }
            }
            
            for(int i = 0; i < N; i++){
                taken = new boolean[N+1];
                for(int j = 0; j < N; j++){
                    int number = matrix[j][i];
                    if(taken[number]){
                        cols++; j = N;
                    }
                    taken[number] = true;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", t, trace, rows, cols);
        }
    }
}