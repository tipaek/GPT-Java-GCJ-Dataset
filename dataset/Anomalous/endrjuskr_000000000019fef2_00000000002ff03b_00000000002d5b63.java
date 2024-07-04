import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int midPoint = 1000000000;

        for (int t = 1; t <= testCases; t++) {
            int x = midPoint;
            int y = 0;

            while (true) {
                System.out.printf("%d %d%n", x, y);
                String response = scanner.next();

                if (response.equals("MISS")) {
                    y++;
                } else if (response.equals("CENTER")) {
                    break;
                } else {
                    processHit(scanner, x, y, A);
                    break;
                }
            }
        }
        scanner.close();
    }

    private static void processHit(Scanner scanner, int x, int y, int A) {
        System.out.printf("%d %d%n", x - 1, y);
        String leftResponse = scanner.next();
        System.out.printf("%d %d%n", x + 1, y);
        String rightResponse = scanner.next();

        if (leftResponse.equals("MISS") && rightResponse.equals("MISS")) {
            y += A;
        } else if (leftResponse.equals("MISS")) {
            findCenter(scanner, x + 1, y - 1, A, 1);
        } else {
            findCenter(scanner, x - 1, y - 1, A, -1);
        }
    }

    private static void findCenter(Scanner scanner, int x, int y, int A, int direction) {
        while (true) {
            System.out.printf("%d %d%n", x, y);
            String response = scanner.next();

            if (response.equals("MISS")) {
                x += direction;
            } else {
                System.out.printf("%d %d%n", x + direction, y);
                response = scanner.next();

                if (response.equals("MISS")) {
                    y += A;
                    break;
                } else {
                    y--;
                    x += direction;
                }
            }
        }
    }
}