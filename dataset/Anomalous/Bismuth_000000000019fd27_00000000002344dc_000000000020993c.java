import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] bucketx = new int[N + 1][N + 1];
            int[][] buckety = new int[N + 1][N + 1];
            int[] isChecky = new int[N];
            int trace = 0;
            int sumrow = 0;
            int sumcol = 0;

            for (int j = 0; j < N; j++) {
                boolean isCheckx = false;
                for (int k = 0; k < N; k++) {
                    int M = sc.nextInt();
                    if (j == k) {
                        trace += M;
                    }
                    bucketx[j][M]++;
                    buckety[k][M]++;

                    if (!isCheckx && bucketx[j][M] > 1) {
                        sumrow++;
                        isCheckx = true;
                    }

                    if (isChecky[k] == 0 && buckety[k][M] > 1) {
                        sumcol++;
                        isChecky[k] = 1;
                    }
                }
            }
            ans.append("case #").append(i + 1).append(": ").append(trace).append(" ").append(sumrow).append(" ").append(sumcol).append("\n");
        }

        System.out.print(ans.toString());
        sc.close();
    }
}