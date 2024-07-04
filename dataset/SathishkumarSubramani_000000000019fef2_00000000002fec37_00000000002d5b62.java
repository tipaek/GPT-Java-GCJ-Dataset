import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int i = 1; i <= testCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int rectifyableDistance = rectifyableDistance(x, y);
            boolean isPossible = isPossible(rectifyableDistance);

            String route = "IMPOSSIBLE";
            if (isPossible) {
                route = findRoute(x, y, rectifyableDistance);
            }

            System.out.format("\nCase #%d: %s", i, route);

        }
        scanner.close();
    }

    static int rectifyableDistance(int x, int y) {

        int maxDistance = Math.abs(x) + Math.abs(y);
        int index = 1;
        while (true) {
            maxDistance -= Math.pow(2, index - 1);
            if (maxDistance <= 0) {
                break;
            }
            index++;
        }

        return Math.abs(maxDistance);
    }

    static boolean isPossible(int rectifyableDistance) {

        return rectifyableDistance % 2 == 0;
    }

    static String findRoute(int x, int y, int rectifyableDistance) {
        return "";
    }

}