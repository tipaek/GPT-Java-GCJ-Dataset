import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] conditions = scanner.nextLine().split(" ");
        int numOfCases = Integer.parseInt(conditions[0]);
        int A = Integer.parseInt(conditions[1]);
        int B = Integer.parseInt(conditions[2]);

        for (int i = 0; i < numOfCases; i++) {
            findCenter(scanner, A, B);
        }
    }

    private static void findCenter(Scanner scanner, int A, int B) {
        int x = 1000000000;
        x = binarySearch(scanner, x, -1, "0", true);
        int maxX = x;

        x = -1000000000;
        x = binarySearch(scanner, x, 1, "0", true);
        int minX = x;

        int y = 1000000000;
        y = binarySearch(scanner, y, -1, "0", false);
        int maxY = y;

        y = -1000000000;
        y = binarySearch(scanner, y, 1, "0", false);
        int minY = y;

        searchCenter(scanner, (minX + maxX) / 2, (minY + maxY) / 2);
    }

    private static int binarySearch(Scanner scanner, int coordinate, int step, String fixedCoordinate, boolean isX) {
        while (true) {
            if (isX) {
                System.out.println(coordinate + " " + fixedCoordinate);
            } else {
                System.out.println(fixedCoordinate + " " + coordinate);
            }
            System.out.flush();

            String result = scanner.next();
            if (result.equals("MISS")) {
                coordinate += step;
            } else if (result.equals("HIT")) {
                break;
            } else if (result.equals("CENTER")) {
                return coordinate;
            }
        }
        return coordinate;
    }

    private static void searchCenter(Scanner scanner, int avgX, int avgY) {
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