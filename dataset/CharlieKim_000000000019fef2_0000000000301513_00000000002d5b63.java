import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] conditions = scanner.nextLine().split(" ");
        int numOfCases = Integer.parseInt(conditions[0]);
        int A = Integer.parseInt(conditions[1]);
        int B = Integer.parseInt(conditions[2]);

        for (int i = 0; i < numOfCases; i++) {
            solve(scanner, A, B);
        }
    }

    private static void solve(Scanner scanner, int A, int B) {
        int x = 1000000000;
        while (true) {
            System.out.println(x + " 0");
            System.out.flush();

            String result = scanner.next();
            if (result.equals("MISS")) {
                x -= 1;
            } else if (result.equals("HIT")) {
                break;
            } else if (result.equals("CENTER")) {
                return;
            }
        }

        int maxX = x;
        x = -1000000000;

        while (true) {
            System.out.println(x + " 0");
            System.out.flush();

            String result = scanner.next();
            if (result.equals("MISS")) {
                x += 1;
            } else if (result.equals("HIT")) {
                break;
            } else if (result.equals("CENTER")) {
                return;
            }
        }

        int minX = x;
        int y = 1000000000;

        while (true) {
            System.out.println("0 " + y);
            System.out.flush();

            String result = scanner.next();
            if (result.equals("MISS")) {
                y -= 1;
            } else if (result.equals("HIT")) {
                break;
            } else if (result.equals("CENTER")) {
                return;
            }
        }

        int maxY = y;
        y = -1000000000;

        while (true) {
            System.out.println("0 " + y);
            System.out.flush();

            String result = scanner.next();
            if (result.equals("MISS")) {
                y += 1;
            } else if (result.equals("HIT")) {
                break;
            } else if (result.equals("CENTER")) {
                return;
            }
        }
        int minY = y;

        int avgX = (minX + maxX) / 2;
        int avgY = (minY + maxY) / 2;
        for (int i = avgX - 5; i <= avgX + 5; i++) {
            if (i >= -1000000000 && i <= 1000000000) {
                for (int j = avgY - 5; j <= avgY + 5; j++) {
                    if (j >= -1000000000 && j <= 1000000000) {
                        System.out.println(i + " " + j);
                        System.out.flush();

                        String result = scanner.next();
                        if (result.equals("CENTER")) {
                            return;
                        }
                    }
                }
            }
        }
    }
}
