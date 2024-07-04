import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] square = makeSquare(n, sc);

            int trace = calcTrace(square, n);
            int raw = calcRaw(square, n);
            int calum = calcCalm(square, n);

            System.out.println(String.format("Case #%s: %s %s %s", i, trace, raw, calum));
        }

    }

    private static int calcRaw(int[][] square, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            boolean[] raws = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int num = square[i][j];
                if(raws[num]) {
                    sum++;
                    break;
                }

                raws[num] = true;
            }
        }
        return sum;
    }

    private static int calcCalm(int[][] square, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            boolean[] raws = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int num = square[j][i];
                if(raws[num]) {
                    sum++;
                    break;
                }

                raws[num] = true;
            }
        }
        return sum;
    }

    private static int calcTrace(int[][] square, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
           sum += square[i][i];
        }
        return sum;
    }

    private static int[][] makeSquare(int n, Scanner sc) {

        int[][] square = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = sc.nextInt();
            }

        }
        return square;
    }

}
