
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N, B;
        int[][] solutions = new int[T][3];
        for (int i = 0; i < T; i++) {

            N = sc.nextInt();

            int[][] A = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) A[j][k] = sc.nextInt();
            }
            solutions[i] = findLatin(A);

        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i][0] + " " + solutions[i][1] + " " + solutions[i][2]);
        }
    }

    private static int[] findLatin(int[][] A) {
        int N = A.length;
        if (N == 0) return new int[]{0,0,0};
        int trace=0;
        for (int i = 0, j = 0; i < N; i++, j++) trace += A[i][j];
        int row=0,col = 0;

        for (int i = 0; i < N; i++) {
            List<Integer> visited= new ArrayList<>();
            for(int j=0;j<N;j++){
                if(visited.contains(A[i][j])) {row++;break;}
                visited.add(A[i][j]);
            }
            List<Integer> visited2= new ArrayList<>();
            for(int j=0;j<N;j++){
                if(visited2.contains(A[j][i])) {col++;break;}
                visited2.add(A[j][i]);
            }

        }
        return new int[]{trace,row,col};

    }
}
