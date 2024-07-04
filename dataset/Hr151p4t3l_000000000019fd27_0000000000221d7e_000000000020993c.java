import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int T = 0;
        if(input.hasNextInt()) {
            T = input.nextInt();
            System.out.println(T);
        }
        
        for(int i = 0; i < T; i++) {
            int N = 0;
            if(input.hasNextInt()) {
                N = input.nextInt();
                System.out.println(N);
            }
            
            int[][] M = new int[N][N];
            List<Integer> row = null;
            
            for(int j = 0; j < N; j++) {
                row = new ArrayList<>(N);
                for(int k = 0; k < N; k++) {
                    if(input.hasNextInt()) {
                        M[j][k] = input.nextInt();
                        row.add(M[j][k]);
                        System.out.print(M[j][k]);
                    }
                }
                System.out.println();
            }
            System.out.println(row);
        }
    }
}