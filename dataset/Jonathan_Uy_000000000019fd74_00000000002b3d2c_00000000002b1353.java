import java.io.*;
import java.util.*;

/**
 * Solution to Subtask 1
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            System.out.printf("Case #%d:\n", t);
            
            int N = Integer.parseInt(br.readLine());
            if(N <= 4){
                for(int i = 1; i <= N; i++)
                    System.out.printf("%d 1\n", i);
            } else if(N <= 501){
                for(int i = 1; i <= 3; i++)
                    System.out.printf("%d 1\n", i);
                System.out.println("3 2");
                for(int i = 3; i + 2 < N; i++)
                    System.out.printf("%d %d\n", i, i);
            }
        }
    }
}