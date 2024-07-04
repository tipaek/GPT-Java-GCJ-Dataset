import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            boolean isSolved = false;

            for (int step = 0; step < moves.length(); step++) {
                char direction = moves.charAt(step);

                switch (direction) {
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
                if (distance <= step + 1) {
                    System.out.println("Case #" + testCase + ": " + (step + 1));
                    isSolved = true;
                    break;
                }
            }

            if (!isSolved) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}