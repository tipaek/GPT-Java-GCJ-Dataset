import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String path = scanner.next();
            boolean reached = false;

            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                switch (direction) {
                    case 'E':
                        X++;
                        break;
                    case 'W':
                        X--;
                        break;
                    case 'N':
                        Y++;
                        break;
                    case 'S':
                        Y--;
                        break;
                }

                if (Math.abs(X) + Math.abs(Y) <= i + 1) {
                    System.out.println("Case #" + t + ": " + (i + 1));
                    reached = true;
                    break;
                }
            }

            if (!reached) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}