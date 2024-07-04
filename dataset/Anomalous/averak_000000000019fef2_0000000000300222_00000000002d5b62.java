import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            if (Math.abs(x + y) % 2 == 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                int currentX = 0, currentY = 0;
                int power = 0;

                while (currentX != x || currentY != y) {
                    int step = (int) Math.pow(2, power);
                    if (Math.abs(currentX - x) > Math.abs(currentY - y)) {
                        if (currentX < x) {
                            currentX += step;
                            result.append('E');
                        } else {
                            currentX -= step;
                            result.append('W');
                        }
                    } else {
                        if (currentY < y) {
                            currentY += step;
                            result.append('N');
                        } else {
                            currentY -= step;
                            result.append('S');
                        }
                    }
                    power++;
                }
                System.out.println("Case #" + i + ": " + result);
            }
        }
        scanner.close();
    }
}