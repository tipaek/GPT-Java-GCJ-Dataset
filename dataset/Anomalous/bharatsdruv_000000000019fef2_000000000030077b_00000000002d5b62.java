import java.util.Scanner;

class Solution {
    public static String exchangeWE(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == 'W') {
                result.append('E');
            } else if (c == 'E') {
                result.append('W');
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String exchangeNS(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == 'N') {
                result.append('S');
            } else if (c == 'S') {
                result.append('N');
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        
        for (int tc = 1; tc <= testcases; tc++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int originalX = X;
            int originalY = Y;
            int sum = Math.abs(X) + Math.abs(Y);
            String result = "";

            if (sum % 2 != 0) {
                X = Math.abs(X);
                Y = Math.abs(Y);

                if (X == 1 && Y == 0) result = "E";
                else if (X == 3 && Y == 0) result = "EE";
                else if (X == 0 && Y == 1) result = "N";
                else if (X == 2 && Y == 1) result = "NE";
                else if (X == 4 && Y == 1) result = "SNE";
                else if (X == 1 && Y == 2) result = "EN";
                else if (X == 3 && Y == 2) result = "WNE";
                else if (X == 0 && Y == 3) result = "NN";
                else if (X == 2 && Y == 3) result = "SEN";
                else if (X == 4 && Y == 3) result = "NNE";
                else if (X == 1 && Y == 4) result = "WEN";
                else if (X == 3 && Y == 4) result = "EEN";

                if (originalX >= 0 && originalY < 0) {
                    result = exchangeNS(result);
                } else if (originalX < 0 && originalY >= 0) {
                    result = exchangeWE(result);
                } else if (originalX < 0 && originalY < 0) {
                    result = exchangeWE(result);
                    result = exchangeNS(result);
                }

                System.out.println("Case #" + tc + ": " + result);
            } else {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}