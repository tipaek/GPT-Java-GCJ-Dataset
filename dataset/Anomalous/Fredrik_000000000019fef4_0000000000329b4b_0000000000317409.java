import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);
            String moves = parts[2];

            int x2 = 0;
            int y2 = 0;

            if (x1 == x2 && y1 == y2) {
                System.out.printf("Case %d: %d%n", i, 0);
                continue;
            }

            int minutes = 1;
            for (char move : moves.toCharArray()) {
                switch (move) {
                    case 'S':
                        y1--;
                        break;
                    case 'N':
                        y1++;
                        break;
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
                    break;
                }
                minutes++;
            }

            if (x1 != x2 || y1 != y2) {
                System.out.printf("Case %d: IMPOSSIBLE%n", i);
            }
        }
    }
}