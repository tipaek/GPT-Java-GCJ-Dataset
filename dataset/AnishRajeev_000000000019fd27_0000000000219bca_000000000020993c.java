import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testcases = 1; testcases <= T; testcases++){
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            for(int i = 0; i < N; i++){
                for(int c = 0; c < N; c++){
                    matrix[i][c]=scanner.nextInt();
                    if(i==c)trace+=matrix[i][c];
                    matrix[i][c]--;
                }
            }
            //CHECK ROWS
            int rowcount = 0;
            for(int i = 0; i < N; i++){
                boolean visited[] = new boolean[N];
                Arrays.fill(visited, false);
                for(int c = 0; c < N; c++){
                    if(visited[matrix[i][c]]){
                        rowcount++;
                        break;
                    }
                    else{
                        visited[matrix[i][c]]=true;
                    }
                }
            }
            //CHECK COLUMNS
            int columncount = 0;
            for(int i = 0; i < N; i++){
                boolean visited[] = new boolean[N];
                Arrays.fill(visited, false);
                for(int c = 0; c < N; c++){
                    if(visited[matrix[c][i]]){
                        columncount++;
                        break;
                    }
                    else{
                        visited[matrix[c][i]]=true;
                    }
                }
            }
            System.out.println("Case #"+testcases+": " + trace + " " + rowcount + " " + columncount);
        }
    }
}
