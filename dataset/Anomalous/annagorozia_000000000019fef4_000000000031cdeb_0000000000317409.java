import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < testCases; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                String moves = scanner.nextLine();

                int result = calculateMoves(x, y, moves);
                System.out.println("Case #" + (i + 1) + ": " + (result == -1 ? "IMPOSSIBLE" : result));
            }
        }
    }

    private static int calculateMoves(int x, int y, String moves) {
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            switch (move) {
                case 'S':
                    y -= 1;
                    break;
                case 'N':
                    y += 1;
                    break;
                case 'E':
                    x += 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
            }

            int minute = i + 1;
            if (Math.abs(x) + Math.abs(y) <= minute) {
                return minute;
            }
        }
        return -1;
    }
}