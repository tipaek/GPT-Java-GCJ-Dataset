import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            System.out.print("Case #" + t + ": ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] path = scanner.next().toCharArray();
            scanner.nextLine();

            boolean isPossible = false;
            for (int i = 0; i < path.length; i++) {
                switch (path[i]) {
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
                        break;
                }

                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    System.out.println(i + 1);
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}