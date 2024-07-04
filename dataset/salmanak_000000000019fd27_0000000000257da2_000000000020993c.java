import java.util.Scanner;

public class Solution {
    public static void solve(int[][] M, int N) {
        int rows = 0, cols = 0, trace = 0;
        boolean[] seen;
        for(int i = 0; i<N; i++) {
            seen = new boolean[N+1];
            for(int j = 0; j<N; j++) {
                if(seen[M[i][j]]) {
                    rows++;
                    break;
                } else seen[M[i][j]] = true;
            }
        }
        for(int i = 0; i<N; i++) {
            seen =  new boolean[N+1];
            for(int j = 0; j<N; j++) {
                if(seen[M[j][i]]) {
                    cols++;
                    break;
                } else seen[M[j][i]]=true;
            }
        }
        for(int i = 0; i<N; i++) {
            trace+=M[i][i];
        }
        System.out.println(trace + " " + rows + " " + cols);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int t = 1; t<=T; t++) {
            int N;
            N = sc.nextInt();
            int[][] M = new int[N][N];
            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    M[i][j]=sc.nextInt();
                }
            }
            System.out.print("Case #"+t+": ");
            solve(M,N);
        }
    }
}
