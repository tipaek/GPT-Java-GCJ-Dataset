import java.io.*;
import java.util.*;

public class Solution {

    private static final int DIX9 = 1000000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solveProblem(scanner);
    }

    private static void solveProblem(Scanner scanner) {
        int t = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int foundY = findCoordinate(scanner, true);
            int foundX = findCoordinate(scanner, false);

            searchCenter(scanner, foundX, foundY, A);
        }
    }

    private static int findCoordinate(Scanner scanner, boolean isY) {
        int foundCoord = DIX9;
        int minCoord = DIX9 - 101;
        int maxCoord = DIX9;

        for (int coord = minCoord; coord < maxCoord; coord++) {
            if (isY) {
                System.out.println("0 " + coord);
                System.err.println("0 " + coord);
            } else {
                System.out.println(coord + " 0");
                System.err.println(coord + " 0");
            }
            String answer = scanner.next();
            System.err.println(answer);

            if ("MISS".equals(answer)) {
                foundCoord = coord;
                break;
            }
        }
        System.err.println((isY ? "FoundY " : "FoundX ") + foundCoord);
        return foundCoord;
    }

    private static void searchCenter(Scanner scanner, int foundX, int foundY, int A) {
        for (int x = foundX - A - 4; x <= foundX - A + 4; x++) {
            for (int y = foundY - A - 4; y <= foundY - A + 4; y++) {
                System.out.println(x + " " + y);
                System.err.println(x + " " + y);
                String answer = scanner.next();
                System.err.println(answer);

                if ("CENTER".equals(answer)) {
                    return;
                }
            }
        }
    }
}