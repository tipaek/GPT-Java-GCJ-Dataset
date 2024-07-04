import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] movements = scanner.next().toCharArray();
            String result = "IMPOSSIBLE";

            for (int j = 0; j < movements.length; j++) {
                if (x == 0 && y == 0) {
                    result = "0";
                }

                switch (movements[j]) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }

                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= j + 1) {
                    result = Integer.toString(j + 1);
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}