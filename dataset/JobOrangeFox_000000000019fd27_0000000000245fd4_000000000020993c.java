import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int krc[][] = new int[T][3];
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int Mi[][] = new int[N][N];
            int Mi2[][] = new int[N][N];
            int K=0;
            for (int j = 0; j < N; j++) {
                for (int j2 = 0; j2 < N; j2++) {
                    Mi[j][j2] = in.nextInt();
                    Mi2[j2][j] = Mi[j][j2];
                    if (j == j2) {
                        K+=Mi[j][j2];
                    }
                }
                krc[i][1] += Set2(N, Mi, j);
            }
            krc[i][2] = Set(N, Mi2);
            krc[i][0] = K;
        }           
        for (int i = 0; i < T; i++) {
            System.out.printf("case #%d : %d %d %d \n",i+1,krc[i][0],krc[i][1],krc[i][2]);
        }
            
    }
    public static int Set(int N,int Mi[][]) {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                for (int j2 = j+1; j2 < N; j2++) {
                    if (Mi[i][j]==Mi[i][j2]){ 
                        ans++;
                        j=N;
                        j2= N;
                        // System.out.println(".");
                    }
                    else {
                        // System.out.println("--");
                    }
                }
                    
                }
            }
            return ans;
        }
    public static int Set2(int N,int Mi[][],int i) {
        int ans = 0;
        for (int j = 0; j < N-1; j++) {
            for (int j2 = j+1; j2 < N; j2++) {
                if (Mi[i][j]==Mi[i][j2]){ 
                    j = N; 
                    j2= N;
                    ans = 1;     
                }
                else {
                    // System.out.println("..");
                }
            }    
        }
        return ans;
    }
}
