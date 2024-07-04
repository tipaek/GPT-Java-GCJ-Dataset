import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int tc = 0; tc < testCases; tc++) {
            int celX = scanner.nextInt();
            int celY = scanner.nextInt();
            boolean xNegative = celX < 0;
            boolean yNegative = celY < 0;
            celX = Math.abs(celX);
            celY = Math.abs(celY);

            boolean xOdd = celX % 2 == 1;
            boolean yOdd = celY % 2 == 1;

            if (xOdd && yOdd) {
                System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                continue;
            }

            boolean xNeedsParityChange = xOdd;
            boolean yNeedsParityChange = yOdd;

            String output = "";
            if ((celX & celY) != 0) {
                if (xNeedsParityChange) {
                    if ((celX + 1 & celY) == 0) {
                        celX += 1;
                        output += xNegative ? "E" : "W";
                    } else if ((celX - 1 & celY) == 0) {
                        celX -= 1;
                        output += xNegative ? "W" : "E";
                    } else {
                        System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                        continue;
                    }
                } else if (yNeedsParityChange) {
                    if ((celX & (celY + 1)) == 0) {
                        celY += 1;
                        output += yNegative ? "N" : "S";
                    } else if ((celX & (celY - 1)) == 0) {
                        celY -= 1;
                        output += yNegative ? "S" : "N";
                    } else {
                        System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                        continue;
                    }
                } else {
                    System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                    continue;
                }
            }

            int stepsX = Integer.bitCount(celX);
            int stepsY = Integer.bitCount(celY);

            for (int i = 0; i < stepsX; i++) {
                output += xNegative ? "W" : "E";
            }
            for (int i = 0; i < stepsY; i++) {
                output += yNegative ? "S" : "N";
            }

            System.out.println("Case #" + (tc + 1) + ": " + output);
        }
    }
}