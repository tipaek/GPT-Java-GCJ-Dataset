import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("Vestigium.in"));
        int T = Integer.parseInt(br.readLine());
        for(int i =0 ;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int[][]grid = new int[N][N];
            int sum = 0;
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    grid[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < N; j++) {
                sum+=grid[j][j];
            }
            int row = 0;
            for (int j = 0; j < N; j++) {
                HashSet<Integer>vals = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    vals.add(grid[j][k]);
                }
                if(vals.size()!=N){
                    row++;
                }
            }
            int col = 0;
            for (int j = 0; j < N; j++) {
                HashSet<Integer>vals = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    vals.add(grid[k][j]);
                }
                if(vals.size()!=N){
                    col++;
                }
            }
            System.out.println("Case #"+i+": "+sum+" "+row+" "+col);

        }
    }


}
