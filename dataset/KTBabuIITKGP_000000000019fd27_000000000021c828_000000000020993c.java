import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t=1; t<=T; t++){
            int N = sc.nextInt();
            int[][] A = new int[N][N];

            for (int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    A[i][j] = sc.nextInt();
                }
            }

            int desired_xor = 0;
            for(int i=1; i<=N; i++){
                desired_xor = desired_xor^i;
            }
            int r=0;
            for (int i=0; i<N; i++){
                int actual_xor = 0;
                for(int j=0; j<N; j++){
                    actual_xor = actual_xor^A[i][j];
                }
                if (actual_xor != desired_xor){
                    r++;
                }
            }
            int c=0;
            for (int i=0; i<N; i++){
                int actual_xor = 0;
                for(int j=0; j<N; j++){
                    actual_xor = actual_xor^A[j][i];
                }
                if (actual_xor != desired_xor){
                    c++;
                }
            }
            int trace=0;
            for(int i=0; i<N; i++){
                trace+=A[i][i];
            }
            System.out.println("Case #"+t+": "+trace+" "+r+" "+c);
        }
    }
}
