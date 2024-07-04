import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = initializeScanner();
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            char[] route = input[2].toCharArray();
            String result = resolveCase(x, y, route);
            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }

    private static Scanner initializeScanner() throws Exception {
        String userName = System.getProperty("user.name");
        if ("Alexey".equals(userName) || "Aleksiej_Mitrofanov".equals(userName)) {
            System.err.println("development mode, reading from file");
            return new Scanner(new FileInputStream("input.txt"));
        } else {
            return new Scanner(System.in);
        }
    }

    private static String resolveCase(int x, int y, char[] route) {
        if (x == 0 && y == 0) {
            return "0";
        }

        int currX = x, currY = y;
        for (int i = 0; i < route.length; i++) {
            switch (route[i]) {
                case 'N':
                    currY++;
                    break;
                case 'S':
                    currY--;
                    break;
                case 'W':
                    currX--;
                    break;
                case 'E':
                    currX++;
                    break;
            }
            if ((i + 1) >= Math.abs(currX) + Math.abs(currY)) {
                return String.valueOf(i + 1);
            }
        }

        return "IMPOSSIBLE";
    }
}