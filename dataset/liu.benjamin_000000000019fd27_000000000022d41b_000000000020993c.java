import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer input;
        
        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            int N = Integer.parseInt(in.readLine());
            int[][] arr = new int[N][N];
            int k = 0; // trace
            int r = 0; // row
            int c = 0; // col
            // fill 2d array
            for(int i = 0; i < N; i++){
                input = new StringTokenizer(in.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(input.nextToken());
                    if(i == j) k += arr[i][j];
                }
            }
            // rows
            for(int i = 0; i < N; i++){
                Set<Integer> s = new HashSet<>();
                for(int y : arr[i]) s.add(y);
                if(N != s.size()) r++;
            }
            // cols
            for(int j = 0; j < N; j++){
                Set<Integer> s = new HashSet<>();
                for(int i = 0; i < N; i++){
                    s.add(arr[i][j]);
                }
                if(N != s.size()) c++;
            }
            out.println("Case #" + x + ": " + k + r + c);
        }
        out.close();
    }
}