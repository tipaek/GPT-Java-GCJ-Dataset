import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] entries = new int[N][3];
            int[][] sorted = new int[N][3];

            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                entries[i][0] = start;
                sorted[i][0] = start;
                entries[i][1] = end;
                sorted[i][1] = end;
                entries[i][2] = sorted[i][2] = i;
            }

            sort(sorted);

            int j = 0, c = sorted[0][1]; // C is code 1 and J is code 2
            entries[sorted[0][2]][2] = 1;
            boolean impossible = false;
            for (int i = 1; i < N; i++) {
                int start = sorted[i][0];
                if (start >= c) {
                    c = sorted[i][1];
                    entries[sorted[i][2]][2] = 1;
                } else if (start >= j) {
                    j = sorted[i][1];
                    entries[sorted[i][2]][2] = 2;
                } else {
                    impossible = true;
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            if (impossible) {
                sb.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < N; i++) {
                    int code = entries[i][2];
                    if (code == 1) sb.append("C");
                    else sb.append("J");
                }
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }//END
    }

    private static void sort(int[][] sorted) {
        int n = sorted.length;
        for (int i = 1; i < n; ++i) {
            int key0 = sorted[i][0];
            int key1 = sorted[i][1];
            int key2 = sorted[i][2];
            int j = i - 1;

            while (j >= 0 && sorted[j][0] > key0) {
                sorted[j + 1][0] = sorted[j][0];
                sorted[j + 1][1] = sorted[j][1];
                sorted[j + 1][2] = sorted[j][2];
                j = j - 1;
            }
            sorted[j + 1][0] = key0;
            sorted[j + 1][1] = key1;
            sorted[j + 1][2] = key2;
        }
    }

}

