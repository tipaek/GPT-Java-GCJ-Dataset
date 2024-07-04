import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputLine = scanner.nextLine();
            int[] coordinates = parseCoordinates(inputLine);
            String moves = parseMoves(inputLine);

            int x = coordinates[0];
            int y = coordinates[1];
            int minutes = 1;

            for (char move : moves.toCharArray()) {
                switch (move) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                }

                if (x > 0) {
                    x--;
                } else if (y > 0) {
                    y--;
                } else if (y < 0) {
                    y++;
                }

                if (x == 0 && y == 0) {
                    System.out.printf("Case %d: %d%n", caseNumber, minutes);
                    continue;
                }
                minutes++;
            }

            System.out.printf("Case %d: IMPOSSIBLE%n", caseNumber);
        }
    }

    private static int[] parseCoordinates(String input) {
        String[] parts = input.split(" ");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }

    private static String parseMoves(String input) {
        String[] parts = input.split(" ");
        return parts[parts.length - 1];
    }
}