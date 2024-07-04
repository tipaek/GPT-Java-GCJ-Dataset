import java.util.Scanner;

public class Solution {
    private static int caseCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            evaluateCase(scanner);
        }
    }

    private static void evaluateCase(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int transformedX = Math.abs(x);
        int transformedY = Math.abs(y);

        String result = determinePossibility(transformedX, transformedY);

        System.out.println("Case #" + caseCounter + ": " + result);
        caseCounter++;
    }

    private static String determinePossibility(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        if (max % 2 == 0) {
            return (min % 2 == 1) ? "POSSIBLE" : "IMPOSSIBLE";
        } else {
            return (min % 2 == 1) ? "IMPOSSIBLE" : "POSSIBLE";
        }
    }
}