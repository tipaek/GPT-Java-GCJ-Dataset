import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    static void trace(int[][] a, int N, int res) {
            for(int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (i==j) {
                        if(res == -1) {
                            a[i][j] = N - i;
                        } else {
                            a[i][j] = res;
                        }
                    } else if (j > i) {
                        int x = (a[i][j-1] + 1);
                        if (x > N) {
                            x = x%N;
                        }
                        a[i][j] = x;
                    }
                }
            }
            for(int i=1; i<N; i++) {
                int x = (a[i][N-1]+1);
                if (x > N) {
                    x = x%N;
                }
                a[i][0] = x;
            }
            for(int i=1; i<N; i++) {
                for (int j=1; j<N; j++) {
                    if(i>j) {
                        int x = (a[i][j-1] + 1);
                        if (x > N) {
                            x = x%N;
                        }
                        a[i][j] = x;
                    }
                }
            }
            
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int k=0; k<T; k++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int flag = 0;
            int res = -1;
            if (N%2 == 1) {
                int sum = (N*(N+1))/2;
                if (sum == K) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                for(int i=1; i<=N; i++) {
                    if ((N*i)==K) {
                        flag = 1;
                        res = i;
                        break;
                    }
                }
            }
            
            if(flag == 0) {
                System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
            } else {
                System.out.println("Case #"+(k+1)+": POSSIBLE");
                int[][] a = new int[N][N];
                trace(a,N,res);
                for(int i=0; i<N; i++) {
                    for (int j=0; j<N; j++) {
                        System.out.print(a[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}