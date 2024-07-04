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
            StringBuilder sb = new StringBuilder();
            boolean impossible = false;
            Character ch = 'C';
            for (int i = 0; i < n; i++) {
                int a, b;
                a = sc.nextInt();
                b = sc.nextInt();
                boolean f = false;
                for (int j = a; j < b; j++) {
                    board[j]++;
                    if (board[j] > 2) {
                        impossible = true;
                    }
                    if (board[j] > 1) {
                        f = true;
                    }
                }
                if (f) {
                    if (ch == 'C') {
                        ch = 'J';
                    } else {
                        ch = 'C';
                    }
                }
                sb.append(ch);
            }
            if (impossible)
                sb = new StringBuilder("IMPOSSIBLE");
            System.out.println("Case #" + id + ": " + sb.toString());
            id++;
            t--;
        }
    }
}
