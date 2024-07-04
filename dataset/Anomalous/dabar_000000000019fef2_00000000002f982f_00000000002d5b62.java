import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCases; i++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            TestCase testCase = new TestCase(x, y);
            String result = testCase.getResult();
            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }

    public static class TestCase {
        private int x;
        private int y;

        public TestCase(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String getResult() {
            StringBuilder path = new StringBuilder();
            int distance = Math.abs(x) + Math.abs(y);
            int stepSize = 1;
            int sum = 1;

            while (sum < distance) {
                stepSize *= 2;
                sum += stepSize;
            }

            while (stepSize >= 1) {
                if (Math.abs(x) > Math.abs(y)) {
                    if (x < 0) {
                        x += stepSize;
                        path.append("W");
                    } else {
                        x -= stepSize;
                        path.append("E");
                    }
                } else {
                    if (y < 0) {
                        y += stepSize;
                        path.append("S");
                    } else {
                        y -= stepSize;
                        path.append("N");
                    }
                }
                stepSize /= 2;
            }

            if (x != 0 || y != 0) {
                return "IMPOSSIBLE";
            }

            return path.reverse().toString();
        }
    }
}