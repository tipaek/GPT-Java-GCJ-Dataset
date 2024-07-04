import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner( System.in);
        int T = sc.nextInt();
        int M=0;
        for (int p=0;p<T;p++){
            int N = sc.nextInt();
            int c[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    c[i][j] = sc.nextInt();
                }
            }
            int l = 0, r = 0, q = 0;
            for (int i = 0; i < N; i++) {
                l += c[i][i];
            }
            for (int i = 0; i < N; i++) {
                Set<Integer> hs = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    hs.add(c[i][j]);
                }
                if ( hs.size() < N ) {
                    r++;
                }
            }
            for (int i = 0; i < N; i++) {
                Set<Integer> hs = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    hs.add(c[j][i]);
                }
                if ( hs.size() < N ) {
                    q++;
                }
            }
            M++;
            System.out.println("Case #" + M +": " + l + " " + r + " " + q);
        }
    }
    }
