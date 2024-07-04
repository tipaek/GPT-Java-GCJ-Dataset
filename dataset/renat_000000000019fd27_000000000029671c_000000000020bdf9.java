import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int id = 1;
        while (t != 0) {
            int n = sc.nextInt();
            int[] board = new int[24 * 60 + 10];
            int[] board1 = new int[24 * 60 + 10];
            StringBuilder sb = new StringBuilder();
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                int a, b;
                a = sc.nextInt();
                b = sc.nextInt();
                boolean f = false;
                for (int j = a; j < b; j++) {
                    board[j]++;
                    board1[j]++;
                    if (board1[j] > 2) {
                        impossible = true;
                    }
                    if (board[j] == 2) {
                        f = true;
                    }
                }
                if (f) {
                    sb.append('J');
                    for (int j = a; j < b; j++) {
                        board[j]--;
                    }
                } else {
                    sb.append('C');
                }

            }
            if (impossible)
                sb = new StringBuilder("IMPOSSIBLE");
            System.out.println("Case #" + id + ": " + sb.toString());
            id++;
            t--;
        }
    }
}
