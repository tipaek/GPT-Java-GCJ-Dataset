import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean reverseX = x < 0;
            boolean reverseY = y < 0;

            x = Math.abs(x);
            y = Math.abs(y);

            String result = "";
            if ((x + y) % 2 == 0) {
                result = "IMPOSSIBLE";
            } else {
                if (x == 0) {
                    if (y == 1) result = "N";
                    else if (y == 3) result = "NN";
                } else if (x == 1) {
                    if (y == 0) result = "E";
                    else if (y == 2) result = "EN";
                    else if (y == 4) result = "WEN";
                } else if (x == 2) {
                    if (y == 1) result = "NE";
                    else if (y == 3) result = "SEN";
                } else if (x == 3) {
                    if (y == 0) result = "EE";
                    else if (y == 2) result = "WNE";
                    else if (y == 4) result = "EEN";
                } else if (x == 4) {
                    if (y == 1) result = "SNE";
                    else if (y == 3) result = "NNE";
                }

                if (reverseX) {
                    result = result.replace('E', 'T').replace('W', 'E').replace('T', 'W');
                }
                if (reverseY) {
                    result = result.replace('N', 'T').replace('S', 'N').replace('T', 'S');
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}