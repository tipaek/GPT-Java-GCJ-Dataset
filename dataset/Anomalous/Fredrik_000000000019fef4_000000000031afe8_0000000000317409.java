import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String inputLine = scanner.nextLine();
            int[] coordinates = parseCoordinates(inputLine);
            String moves = parseMoves(inputLine);

            int x1 = coordinates[0];
            int y1 = coordinates[1];
            int x2 = 0;
            int y2 = 0;
            int minutes = 1;

            for (char move : moves.toCharArray()) {
                if (move == 'S') {
                    y1--;
                } else if (move == 'N') {
                    y1++;
                }

                if (x1 > x2) {
                    x2++;
                } else if (x1 < x2) {
                    x2--;
                } else if (y1 > y2) {
                    y2++;
                } else if (y1 < y2) {
                    y2--;
                }

                if (x1 == x2 && y1 == y2) {
                    System.out.printf("Case %d: %d%n", i, minutes);
                    continue;
                }
                minutes++;
            }

            System.out.printf("Case %d: IMPOSSIBLE%n", i);
        }
    }

    private static int[] parseCoordinates(String inputLine) {
        String[] parts = inputLine.split(" ");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }

    private static String parseMoves(String inputLine) {
        String[] parts = inputLine.split(" ");
        return parts[parts.length - 1];
    }
}