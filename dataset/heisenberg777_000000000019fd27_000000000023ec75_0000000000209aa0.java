import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int x = 1; x <= T; x++) {
            int N = in.nextInt();
            int k = in.nextInt();
            int[] possibilities = new int[N + 1];
            int fact = 0;
            if (N >= 3) {
                for (int i = 0; i < N; i++) {
                    fact += (i + 1);
                    possibilities[i] = (i + 1) * N;
                }
                possibilities[N] = (fact);
                int index = -1;
                for (int i = 0; i <= N; i++) {
                    if (k == possibilities[i])
                        index = i;
                }
                int[][] array = new int[N][N];

                if (index < 0) {
                    System.out.println("Case #" + x + ": IMPOSSIBLE");
                } else {
                    if (index == N) {
                        int y = 0;
                        for (int i = 0; i < N; i++) {
                            array[i][i] = N - i;
                            int c = 0;
                            for (int j = i + 1; j < N + i; j++) {
                                if ((array[i][i] + (i + 1 - y)) + c > N)
                                    array[i][j % N] = ((array[i][i] + (i + 1 - y)) + c++) % N;
                                else
                                    array[i][j % N] = ((array[i][i] + (i + 1 - y))) + c++;
                            }
                            y++;
                        }
                    } else {
                        int z = index + 1;
                        int y = 0;
                        for (int i = 0; i < N; i++) {
                            array[i][i] = z;
                            int c = 0;
                            for (int j = i + 1; j < N + i; j++) {
                                if ((array[i][i] + (i + 1 - y)) + c > N)
                                    array[i][j % N] = ((array[i][i] + (i + 1 - y)) + c++) % N;
                                else
                                    array[i][j % N] = ((array[i][i] + (i + 1 - y))) + c++;
                            }
                            y++;
                        }
                    }
                    System.out.println("Case #" + x + ": POSSIBLE");
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(array[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                if (N == 2) {
                    if (k == 4 || k == 2) {
                        System.out.println("Case #" + x + ": POSSIBLE");
                        if (k == 2) {
                            System.out.println(1 + " " + 2);
                            System.out.println(2 + " " + 1);
                        }
                        if (k == 4) {
                            System.out.println(2 + " " + 1 + " ");
                            System.out.println(1 + " " + 1 + " ");
                        }
                    } else
                        System.out.println("Case #" + x + ": IMPOSSIBLE");
                } else if (N == 1) {
                    if (k == 1) {
                        System.out.println("Case #" + x + ": POSSIBLE");
                        System.out.println(1);
                    } else
                        System.out.println("Case #" + x + ": IMPOSSIBLE");
                }
            }
        }
        in.close();
    }
}