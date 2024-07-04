
import java.util.Scanner;

public class Solution {
    static int count = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t=1; t<=T; t++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            count = 1;

            int[][] A = new int[R][C];

            int[][][] N = new int[R][C][4];

            for (int i=0; i<R; i++) {
                for (int j=0; j<C; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            for (int i=0; i<R; i++) {
                for (int j=0; j<C; j++) {
                    N[i][j][0] = i-1 >= 0? i-1: -1;
                    N[i][j][1] = i+1 < R? i+1: -1;
                    N[i][j][2] = j-1 >= 0? j-1: -1;
                    N[i][j][3] = j+1 < C? j+1: -1;
                }
            }

            int sum = 0;
            int round = 1;
            while (count != 0){
//                System.out.println(Arrays.deepToString(N));
//                System.out.println("Performing Round: "+round++);
                sum = sum+performRound(A, N);
            }
            System.out.println("Case #"+t+": "+sum);
        }
    }

    private static int performRound(int[][] A, int[][][] N) {
        int interest = 0;
        count = 0;
        boolean[][] removed = new boolean[A.length][A[0].length];
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A[i].length; j++) {
                if (A[i][j] != 0) {
                    interest = interest + A[i][j];
                    int average = getAverage(i, j, A, N);
                    if (A[i][j] < average) {
                        count++;
                        removed[i][j] = true;
                    }
                }
            }
        }

        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A[i].length; j++) {
                if (removed[i][j]){
                    A[i][j]=0;
                    removeElement(i, j, N);
                }
            }
        }

        for (int i=A.length-1; i>=0; i--) {
            for (int j=A[i].length-1; j>=0; j--) {
                if (removed[i][j]){
                    A[i][j] = 0;
                    removeElement(i, j, N);
                }
            }
        }
        return interest;
    }

    private static int getAverage(int i, int j, int[][] A, int[][][] N){
        int count = 0;
        int sum = 0;

        if (N[i][j][0]!=-1) {
            sum = sum+A[N[i][j][0]][j];
            count++;
        }
        if (N[i][j][1]!=-1) {
            sum = sum+A[N[i][j][1]][j];
            count++;
        }
        if (N[i][j][2]!=-1) {
            sum = sum+A[i][N[i][j][2]];
            count++;
        }
        if (N[i][j][3]!=-1) {
            sum = sum+A[i][N[i][j][3]];
            count++;
        }

        if (count==0){
            return 0;
        }
        return (int)Math.ceil((double) sum/(double)count);
    }

    private static void removeElement(int i, int j, int[][][] N) {
        if (N[i][j][0] != -1){
            N[N[i][j][0]][j][1] = N[i][j][1];
        }

        if (N[i][j][1] != -1) {
            N[N[i][j][1]][j][0] = N[i][j][0];
        }

        if (N[i][j][2] != -1) {
            N[i][N[i][j][2]][3] = N[i][j][3];
        }

        if (N[i][j][3] != -1) {
            N[i][N[i][j][3]][2] = N[i][j][2];
        }
    }
}
