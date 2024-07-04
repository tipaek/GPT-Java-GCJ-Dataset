import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #"+t+": ");
            int N=sc.nextInt();
            int K=sc.nextInt();
            solve(N, K);
        }
    }

    private static void solve(int N, int K){
        if(K % N != 0){
            System.out.println("IMPOSSIBLE");
            return;
        }
        int[][] mat = new int[N][N];
        for(int i=0;i<N;i++){
            int ofs = i;
            for(int j=0;j<N;j++){
                mat[i][(j+ofs) % N] = j+1;
            }
        }
        for(int i=0;i<(K-N)/N;i++){
            plus1(mat);
            //printMat(mat);
        }
//        System.out.println(confirm(mat, N, K));
        System.out.println("POSSIBLE");
        printMat(mat);
    }
    private static void plus1(int[][] mat){
        int N = mat.length;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int plus = mat[i][j] + mat[j][i] - mat[i][i] - mat[j][j];
                if(plus == N){
                    swapline(mat, i, j);
                    return;
                }
            }
        }
    }
    private static void swapline(int[][] mat, int i, int j){
        int N = mat.length;
        int[] tmp = new int[N];
        for(int k=0;k<N;k++){
            tmp[k] = mat[i][k];
        }
        for(int k=0;k<N;k++) {
            mat[i][k] = mat[j][k];
            mat[j][k] = tmp[k];
        }
    }

    private static void printMat(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private static boolean confirm(int[][] Mat, int N, int K){
        boolean trace = IntStream.range(0,N).map(k->Mat[k][k]).sum() == K;
        boolean resR = !IntStream.range(0,N).mapToLong(k->
                Arrays.stream(Mat[k])
                        .boxed()
                        .distinct()
                        .count())
                .anyMatch(k->(k!=N));
        boolean resC = !IntStream.range(0,N).mapToLong(k->
                IntStream.range(0,N)
                        .map(r->Mat[r][k])
                        .boxed()
                        .distinct()
                        .count())
                .anyMatch(k->k!=N);
        return resR & resC & trace;

    }

}
