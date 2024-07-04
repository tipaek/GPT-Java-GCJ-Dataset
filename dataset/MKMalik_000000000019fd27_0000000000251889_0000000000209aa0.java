import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0; i<t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (k % n != 0) {
                System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
                continue;
            }
            else {
                System.out.println("Case #"+(i+1)+": POSSIBLE");
                int N = 0, K = 0, temp = 1;
                int result[][] = new int[n][n];
                while (k != K) {
                    result = genMat(n, temp);
                    K = dia_sum(result);
                    temp++;
                }
                for (int a=0; a<n; a++) {
                    for (int b=0; b<n; b++) {
                        System.out.print(result[a][b] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    static int[][] genMat(int n, int temp) {
        int[][] res = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                res[i][j] = ((i+j) % n) + temp;
            }
        }
        return res;
    }
    static int dia_sum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if (i==j)
                    sum += mat[i][j];
        return sum;
    }
}
