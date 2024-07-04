

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
                    b[j][j] = true;
                }
                if (sum == K){
                    f=1;
                    int[] a = new int[N-1];
                    int i1 =0;
                    for(int i2=1; i2 <= N;i2++){
                        if (i2 != i){
                            a[i1++] = i2;
                        }
                    }
                    i1 =0;
                    for(int k=0; k < N; k++){
                        i1=0;
                        for(int l=0; l < N; l++) {
                            if (!b[k][l]) {
                                m[k][l] = a[i1++];
                                b[k][l] = true;
                            }
                        }
                        rotate(a);
                    }
                    break;
                }



            }
            if (f == 1){
                System.out.println("Case #" +  ii + ": " + "POSSIBLE");
                for(int i=0; i < N; i++){
                    for(int j=0; j < N; j++){
                        System.out.print(m[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Case #" +  ii + ": " + "IMPOSSIBLE");
            }
        }
    }
    static void rotate(int[] a){
        int t = a[0];
        for(int i=0; i < a.length-1; i++){
            a[i] = a[i+1];
        }
        a[a.length-1] = t;
    }
}

