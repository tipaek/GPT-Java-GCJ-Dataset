import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            writer.println("Case #" + t + ":");

            int n = scanner.nextInt();
            Position position = new Position(1, 1);

            if (n < 30) {
                for (; n > 0; n--, position.moveToNextRow()) {
                    writer.println(position);
                }
            } else {
                n -= 30;
                int extraSteps = 0;

                for (int i = 0; i < 30; i++, n >>= 1) {
                    if ((n & 1) == 1) {
                        extraSteps++;
                        if (position.y == 1) {
                            for (; position.y < position.x; position.y++) {
                                writer.println(position);
                            }
                        } else if (position.y == position.x) {
                            for (; position.y > 1; position.y--) {
                                writer.println(position);
                            }
                        }
                    }
                    writer.println(position);
                    position.moveToNextRow();
                }

                for (int i = 0; i < extraSteps; i++) {
                    writer.println(position);
                    position.moveToNextRow();
                }
            }
        }

        scanner.close();
        writer.close();
    }

    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void moveToNextRow() {
            if (y == 1) {
                x++;
            } else if (x == y) {
                x++;
                y++;
            } else {
                System.exit(1);
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}