import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            char[] M = scanner.next().toCharArray();
            boolean found = false;

            for (int i = 1; i <= M.length; i++) {
                switch (M[i - 1]) {
                    case 'N':
                        Y++;
                        break;
                    case 'S':
                        Y--;
                        break;
                    case 'E':
                        X++;
                        break;
                    case 'W':
                        X--;
                        break;
                }

                if (Math.abs(X) + Math.abs(Y) <= i) {
                    System.out.println("Case #" + t + ": " + i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}