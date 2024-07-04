import java.util.Scanner;

public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfTestCases = SCANNER.nextInt();

        for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
            findCenter();
        }
    }

    private static void findCenter() {
        int A = SCANNER.nextInt();
        int B = SCANNER.nextInt();

        final int minX = -5, maxX = 5;
        final int minY = -5, maxY = 5;

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                System.out.println(x + " " + y);
                String response = SCANNER.next();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }
}