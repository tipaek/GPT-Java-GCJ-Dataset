import java.util.Scanner;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int T, N;

        T = in.nextInt();
        
        for (int t = 0; t < T; t++) {
            N = in.nextInt();
         
            boolean[] check = new boolean[N];
            int[][] matrix = new int[N][N];

            clear_array(N, check);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            
            int x, k, r, c;
            x = t + 1;
            k = r = c = 0;

            for (int i = 0; i < N; i++) {
                k += matrix[i][i];
            }

            for (int i = 0; i < N; i++) {
                clear_array(N, check);
                for (int j = 0; j < N; j++) {
                    if (check[matrix[i][j] - 1] == true) {
                        r++;
                        break;
                    } else {
                        check[matrix[i][j] - 1] = true;
                    }
                }
            }
            
            for (int j = 0; j < N; j++){
                clear_array(N, check);
                for (int i = 0; i < N; i++) {
                    if (check[matrix[i][j] - 1] == true) {
                        c++;
                        break;
                    }else{
                        check[matrix[i][j] - 1] = true;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", x, k, r, c);
        }
    }

    private static void clear_array(int N, boolean[] check) {
        for (int i = 0; i < N; i++) {
            check[i] = false;
        }
    }
}