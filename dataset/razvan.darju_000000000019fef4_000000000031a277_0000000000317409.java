import java.util.Scanner;

public class Solution {


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int cases = scanner.nextInt();

        for (int c = 1; c <= cases; c++) {

            System.out.print("Case #" + c + ": ");
            solve();
            System.out.println();
        }

    }

    private static void solve() {

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        String path = scanner.next();

        if (x + y == 0) {
            System.out.print(0);
            return;
        }

        int count = 0;


        for (char c : path.toCharArray()) {
            count++;
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
            }

            if (count >= Math.abs(x) + Math.abs(y)) {
                System.out.print(count);
                return;
            }
        }

        System.out.print("IMPOSSIBLE");
    }
}