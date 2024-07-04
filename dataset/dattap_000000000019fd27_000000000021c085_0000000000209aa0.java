import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        for (int ii = 1; ii <= t; ii++) {
            String[] d = s.nextLine().split(" ");
            int N = Integer.parseInt(d[0]);
            int K = Integer.parseInt(d[1]);
            int[][] m = new int[N][N];
            boolean[][] b = new boolean[N][N];
                int f=0;
                for(int i=1; i <= N; i++){
                    int sum = 0;
                    for(int j=0; j < N; j++){
                        m[j][j] = i;
                        sum = sum + m[j][j];
                        b[j][i-1] = true;
                    }
                    if (sum == K){
                        f=1;
                        for(int k=0; k < N; k++){
                            for(int l=0; l < N; l++) {
                                if (!b[k][l]) {
                                       m[k][l] = Math.abs(k+l - i);
                                       b[k][l] = true;
                                }
                            }
                        }
                    }

                   

                }
                 if (f == 1){
                        System.out.println("Case #" +  ii + ": " + "POSSIBLE");
                    }
                    else{
                        System.out.println("Case #" +  ii + ": " + "IMPOSSIBLE");
                    }
            }
        }
    }

