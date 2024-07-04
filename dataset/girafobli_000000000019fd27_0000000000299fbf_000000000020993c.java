import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer input;
        int T = Integer.parseInt(in.readLine());
        for (int l = 0; l < T; l++) {
            int N = Integer.parseInt(in.readLine());
            int[][] arr = new int[N][N];
            int k = 0; // trace
            int r = 0; // row
            int c = 0; // col
            for(int i = 0; i < N; i++){
                input = new StringTokenizer(in.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(input.nextToken());
                    if(i == j) k += arr[i][j];
                }
            }
            for(int i = 0; i < N; i++){
                Set<Integer> x = new HashSet<Integer>();
                Set<Integer> y = new HashSet<Integer>();
                for(int j = 0; j < N; j++){
                    x.add(arr[i][j]);
                    y.add(arr[j][i]);
                }
                if(x.size()<N)r++;
                if(y.size()<N)c++;
            }
            System.out.println("Case #"+l+": "+k+" "+r+" "+c) ;
        }
    }
}