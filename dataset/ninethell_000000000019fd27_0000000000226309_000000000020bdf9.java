import java.util.Scanner;

public class Solution {

    public static void qSort(int[][] mas, int nStart, int nEnd, int column) {
        int L, R, c1, c2, c3, c4, pivot;
        if (nStart >= nEnd) return;
        L = nStart;
        R = nEnd;
        pivot = mas[(L + R) / 2][column];

        while (L <= R) {
            while (mas[L][column] < pivot) L++;
            while (mas[R][column] > pivot) R--;
            if (L <= R) {
                c1 = mas[L][0];
                c2 = mas[L][1];
                c3 = mas[L][2];
                c4 = mas[L][3];
                mas[L][0] = mas[R][0];
                mas[L][1] = mas[R][1];
                mas[L][2] = mas[R][2];
                mas[L][3] = mas[R][3];
                mas[R][0] = c1;
                mas[R][1] = c2;
                mas[R][2] = c3;
                mas[R][3] = c4;
                L++;
                R--;
            }
        }
        qSort(mas, nStart, R, column);
        qSort(mas, L, nEnd, column);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int[][] activities = new int[n][4];
            result.append("Case #" + (test+1) + ": ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    activities[i][j] = sc.nextInt();
                }
                activities[i][2] = i;
            }
            qSort(activities, 0, n - 1, 0);
            int cFree = 0;
            int jFree = 0;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (activities[i][0] >= cFree) {
                    activities[i][3] = 0;
                    cFree = activities[i][1];
                } else if (activities[i][0] >= jFree) {
                    activities[i][3] = 1;
                    jFree = activities[i][1];
                } else {
                    result.append("IMPOSSIBLE");
                    flag = true;
                    break;
                }
            }

            qSort(activities, 0, n - 1, 2);
            if (!flag) {
                for (int i = 0; i < n; i++) {
                    if (activities[i][3] == 0) result.append("C");
                    else result.append("J");
                }
            }
            result.append("\n");


        }
        System.out.println(result);
    }
}
