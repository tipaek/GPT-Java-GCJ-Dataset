
import java.util.Scanner;

class Vestigium {
    
    public static int T, N;
    public static int[][] M;
    
    public static void Vestigium(int t) {
        int k = 0;
        for (int i = 0; i < N; i++)
            k += M[i][i];
        
        int r = 0;
        int[] count = new int[N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (count[M[i][j]] != 0) {
                    r++;
                    j = N;
                    continue;
                }
                count[M[i][j]]++;
            }
            count = new int[N + 1];
        }
        
        int c = 0;
        count = new int[N + 1];
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (count[M[i][j]] != 0) {
                    c++;
                    i = N;
                    continue;
                }
                count[M[i][j]]++;
            }
            count = new int[N + 1];
        }
        
        System.out.println("Case #" + (t + 1) + ": " + k + " " + r + " " + c);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            
            M = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    M[i][j] = sc.nextInt();
            
            Vestigium(t);
        }
    }
    
}