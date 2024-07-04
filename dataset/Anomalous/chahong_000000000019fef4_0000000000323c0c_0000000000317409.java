import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int mx = 0, my = 0;
            int result = 0;
            String path = scanner.next();

            System.out.print("Case #" + (i + 1) + ": ");

            if (x == 0 && y == 0) {
                result = 0;
            } else {
                for (int j = 0; j < path.length(); j++) {
                    char direction = path.charAt(j);
                    switch (direction) {
                        case 'S': y--; break;
                        case 'N': y++; break;
                        case 'E': x++; break;
                        case 'W': x--; break;
                    }
                    result++;

                    int xGap = Math.abs(x - mx);
                    int yGap = Math.abs(y - my);

                    if (xGap >= yGap) {
                        if (x > mx) mx++;
                        else if (x < mx) mx--;
                    } else {
                        if (y > my) my++;
                        else if (y < my) my--;
                    }

                    if (x == mx && y == my) {
                        break;
                    }

                    if (j == path.length() - 1) {
                        result = -1;
                    }
                }
            }

            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }
}