import java.io.*;
import java.util.*;

/**
 * Solution to Subtask 2
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
            } else if(N >= 501){
                for(int i = 1; i <= 3; i++)
                    System.out.printf("%d 1\n", i);
                System.out.println("3 2");
                for(int i = 3; i + 2 < N; i++)
                    System.out.printf("%d %d\n", i, i);
            } else if(N <= 1000){
                System.out.println("1 1");
                int sum = 1;
                int row = 2;
                while(sum + (row-1) <= N){
                    System.out.printf("%d 2\n", row);
                    sum += row-1;
                    row++;
                }
                row--;
                while(sum + 1 <= N){
                    System.out.printf("%d 1\n", row);
                    sum += 1;
                    row++;
                }
            }
        }
    }
}