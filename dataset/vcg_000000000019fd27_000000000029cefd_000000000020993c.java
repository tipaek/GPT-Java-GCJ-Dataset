import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int[][] M;
        Set<Integer> uS = new HashSet<>();
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            M = new int[N][N];
            int L=0,R=0,C=0;
            for(int i = 0;i<N;i++ ) {
                for (int j= 0;j<N;j++) {
                    M[i][j]=in.nextInt();
                    if(i==j){
                        L+=M[i][j];
                    }
                    uS.add(M[i][j]);
                }
                if(uS.size()!=N) {
                    R++;
                }
                uS.clear();
            }

            for(int i = 0;i<N;i++ ) {
                for (int j = 0; j < N; j++) {
                    uS.add(M[j][i]);
                }
                if(uS.size()!=N) {
                    C++;
                }
                uS.clear();
            }

            System.out.println("Case #" + t + ": " + L + " "+ R + " " + C);
        }
    }
}
