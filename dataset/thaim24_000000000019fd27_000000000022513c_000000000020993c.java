import java.util.Scanner;

public class Vestigum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int N = sc.nextInt();
            int[][] M = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println("Case #" + (t+1) + ": "+ toString(solve(N, M)));
        }
    }

    private static int[] solve(int N, int[][] M) {
        int trace = 0;
        int[] count = new int[2];
        int req = N * (1 + N) / 2;

        for (int i=0; i<N; i++) {
            trace += M[i][i];
        }
        for (int i=0; i<N; i++) {
            int sum = 0;
            boolean[] hit = new boolean[N];
            boolean dup = false;

            for (int j=0; j<N; j++) {
                sum += M[i][j];
                if (hit[M[i][j]-1]) {
                    dup = true;
                } else {
                    hit[M[i][j]-1] = true;
                }
            }

            if (dup || sum != req) {
                count[0]++;
            }
        }
        for (int i=0; i<N; i++) {
            int sum = 0;
            boolean[] hit = new boolean[N];
            boolean dup = false;

            for (int j=0; j<N; j++) {
                sum += M[j][i];
                if (hit[M[i][j]-1]) {
                    dup = true;
                } else {
                    hit[M[i][j]-1] = true;
                }
            }

            if (dup || sum != req) {
                count[1]++;
            }
        }

        return new int[]{trace, count[0], count[1]};
    }

    private static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}