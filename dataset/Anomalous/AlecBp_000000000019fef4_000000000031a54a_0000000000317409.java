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
            String movements = scanner.next();
            boolean reached = false;

            for (int j = 0; j < movements.length(); j++) {
                char move = movements.charAt(j);

                switch (move) {
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
                    System.out.println(j + 1);
                    reached = true;
                    break;
                }
            }

            if (!reached) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}