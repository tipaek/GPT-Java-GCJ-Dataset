import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        int T=SC.nextInt(),N,S,C1 = 0,C2 = 0;
        int[][] M;
        for (int i = 0; i < T; i++) {
            N=SC.nextInt();
            M=new int[N][N];
            S=0;
            C2=0;
            C1=0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    M[j][k]=SC.nextInt();
                    if (j==k) {
                        S+=M[j][j];
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N-1; k++) {
                    for (int l = k+1; l < N; l++) {
                        if (M[j][k]==M[j][l]) {
                            C1++;
                            k=N-1;
                            break;
                        }
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N-1; k++) {
                    for (int l = k+1; l < N; l++) {
                        if (M[k][j]==M[l][j]) {
                            C2++;
                            k=N-1;
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + S + " " + C1 + " " + C2);
        }
    }
    
}