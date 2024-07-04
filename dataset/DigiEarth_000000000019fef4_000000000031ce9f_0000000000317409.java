
import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    private static String answer;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = createScanner();

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            String path = in.nextLine();
            String[] directions = path.split("");
            Position position = new Position(x, y);

            int walkableDistance;
            for (walkableDistance = 0; walkableDistance < directions.length;walkableDistance++) {
                position.move(directions[walkableDistance]);

                if (position.getDistance() <= walkableDistance) {
                    break;
                }
            }

            String answer = walkableDistance == directions.length ? "IMPOSSIBLE" : "" + walkableDistance;

            System.out.printf("Case #%d: %s%s", i, answer, i != t ? "\n" : "");
        }
        in.close();
    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(String direction) {
            switch (direction) {
                case "S":
                    this.y = this.y - 1;
                    break;
                case "N":
                    this.y = this.y + 1;
                    break;
                case "W":
                    this.x = this.x - 1;
                    break;
                case "E":
                    this.x = this.x + 1;
                    break;
            }
        }

        public int getDistance() {
            return Math.abs(this.x) + Math.abs(this.y);
        }
    }

    private static Scanner createScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
//			String outputFileName = "output-" + INPUT_FILE_NAME + ".out";
//			File outputFile = new File(outputFileName);
//			System.setOut(new PrintStream(outputFile));

            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));

        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
}
