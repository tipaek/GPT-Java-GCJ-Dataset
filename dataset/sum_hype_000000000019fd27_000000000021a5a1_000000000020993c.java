import java.util.*;
import java.io.*;
public class Vestigium{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N;
        N = Integer.parseInt(scan.nextLine());
        String[] ans = new String[N];
        for(int l = 1; l <= N; l++){
            int M = Integer.parseInt(scan.nextLine());
            int[][] array = new int[M][M];
            StringTokenizer line;

            for(int i = 0; i < M; i++){
                line = new StringTokenizer(scan.nextLine());
                for(int k = 0; k < M; k++){
                    array[i][k] = Integer.parseInt(line.nextToken());
                }
            }
            int trace = 0;
            for(int i = 0; i < M; i++)
                trace += array[i][i];

            int rows = 0;
            for(int i = 0; i < M; i++){
                boolean[] visited = new boolean[M];
                for(int k = 0; k < M; k++){
                    if(visited[array[i][k] - 1]){
                        rows ++;
                        break;
                    }
                    visited[array[i][k] - 1] = true;
                }
            }

            int cols = 0;
            for(int i = 0; i < 1*M; i++){
                boolean[] visited = new boolean[M];
                for(int k = 0; k < 1*M; k++){
                    if(visited[array[k][i] - 1]){
                        cols ++;
                        break;
                    }
                    visited[array[k][i] - 1] = true;
                }
            }

            ans[l-1] = "Case #" + l + ": " + trace + " " + rows + " " + cols;
        }
        for(String i: ans)
            System.out.println(i);
    }
}