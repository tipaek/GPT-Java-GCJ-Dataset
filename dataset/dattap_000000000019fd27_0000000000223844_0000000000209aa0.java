import java.util.Scanner;
import java.util.TreeSet;

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
                    int c1 = 0;
                    int f1 = 0;
                   // while(true) {
                        //c1 = 0;
                        for (int k = 0; k < N; k++) {
                            i1 = 0;
                            c1 = c1 + 1;
                            for (int l = 0; l < N; l++) {
                                if (!b[k][l]) {
                                    m[k][l] = a[i1++];
                                    b[k][l] = true;
                                }
                            }
                            int r = 0;
                            for (int i2 = 0; i2 < N; i2++) {
                                TreeSet ts = new TreeSet();
                                for (int j = 0; j < N; j++) {
                                    ts.add(m[i2][j]);
                                }
                                if (ts.size() == N) {
                                    r++;
                                }
                            }
                            int c = 0;
                            for (int i2 = 0; i2 < N; i2++) {
                                TreeSet ts = new TreeSet();
                                for (int j = 0; j < N; j++) {
                                    ts.add(m[j][i2]);
                                }
                                if (ts.size() == N) {
                                    c++;
                                }
                            }

                            if (r == N && c == N) {
                                f1 = 1;
                                break;
                            } else {
                                //rotateLeft(a);
                                rotateRight(a);


                            }
                        }

                    //}
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
    static void rotateLeft(int[] a){
        int t = a[0];
        for(int i=0; i < a.length-1; i++){
            a[i] = a[i+1];
        }
        a[a.length-1] = t;
    }
    static void rotateRight(int[] a){
        int t = a[a.length-1];
        for(int i=a.length - 1; i >= 1; i--){
            a[i] = a[i-1];
        }
        a[0] = t;
    }
}

