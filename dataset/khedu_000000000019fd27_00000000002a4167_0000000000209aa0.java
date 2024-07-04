import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    static int[][] mat;
    private static int N = 0;
    public static void main(String[] args)throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++){
            if (T >=1 && T <= 100 ){
                N =  Integer.parseInt(br.readLine());
                mat = new int[N][N];

                int right = N - 1, left = 0;
                for (int k = 0; k < N; k++){
                    if (k % 2 == 0){
                        mat[k][right] = 1;
                        fillRemaining(k, right, N);
                        right--;
                    }
                    else{
                        mat[k][left] = 1;
                        fillRemaining(k, left, N);
                        left++;
                    }
                }

                for (int l = 0; l < N; l++)
                {
                    for (int j = 0 ; j < N; j++){
                        System.out.print(mat[l][j]+" ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static void fillRemaining(int i, int j, int n) {
        int x = 2;
        for (int k = i + 1; k < n; k++)
            mat[k][j] = x++;
        for (int k = 0; k < i; k++)
            mat[k][j] = x++;
    }
}
