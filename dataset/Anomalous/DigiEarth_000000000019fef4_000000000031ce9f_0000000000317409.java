import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = createScanner();

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            String path = scanner.nextLine();
            String[] directions = path.split("");
            Position position = new Position(x, y);

            int walkableDistance;
            for (walkableDistance = 0; walkableDistance < directions.length; walkableDistance++) {
                position.move(directions[walkableDistance]);
                if (position.getDistance() <= walkableDistance) {
                    break;
                }
            }

            String result = walkableDistance == directions.length ? "IMPOSSIBLE" : String.valueOf(walkableDistance);
            System.out.printf("Case #%d: %s%s", i, result, i != testCases ? "\n" : "");
        }
        scanner.close();
    }

    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move(String direction) {
            switch (direction) {
                case "S":
                    this.y--;
                    break;
                case "N":
                    this.y++;
                    break;
                case "W":
                    this.x--;
                    break;
                case "E":
                    this.x++;
                    break;
            }
        }

        int getDistance() {
            return Math.abs(this.x) + Math.abs(this.y);
        }
    }

    private static Scanner createScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
}