import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int c = 1; c <= t; c++) {
            int n = scanner.nextInt();
            int[][] e = new int[n * 2][3]; // [time, index, type (start=0, end=1)]
            for (int i = 0; i < n; i++) {
                e[i * 2][0] = scanner.nextInt();
                e[i * 2][1] = i;
                e[i * 2][2] = 0;
                e[i * 2 + 1][0] = scanner.nextInt();
                e[i * 2 + 1][1] = i;
                e[i * 2 + 1][2] = 1;
            }
            Arrays.sort(e, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) return o2[2] - o1[2];
                    return o1[0] - o2[0];
                }
            });
            boolean[] a = new boolean[n]; // true=C, false=J
            boolean cFree = true;
            boolean jFree = true;
            boolean possible = true;
            for (int i = 0; i < n * 2; i++) {
                if (e[i][2] == 0) {
                    if (cFree) {
                        cFree = false;
                        a[e[i][1]] = true;
                    } else if (jFree) {
                        jFree = false;
                        a[e[i][1]] = false;
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    if (a[e[i][1]]) {
                        cFree = true;
                    } else {
                        jFree = true;
                    }
                }
            }
            System.out.print("Case #" + c + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder out = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (a[i]) out.append('C');
                    else out.append('J');
                }
                System.out.println(out);
            }
        }
    }
}
