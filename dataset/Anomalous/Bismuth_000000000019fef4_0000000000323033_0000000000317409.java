import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String path = scanner.next();

            int currentX = startX;
            int currentY = startY;
            boolean reached = false;

            for (int step = 0; step < path.length(); step++) {
                char direction = path.charAt(step);
                switch (direction) {
                    case 'N':
                        currentY++;
                        break;
                    case 'E':
                        currentX++;
                        break;
                    case 'W':
                        currentX--;
                        break;
                    case 'S':
                        currentY--;
                        break;
                }

                if (Math.abs(currentX - startX) + Math.abs(currentY - startY) <= step + 1) {
                    result.append(step + 1).append("\n");
                    reached = true;
                    break;
                }
            }

            if (!reached) {
                result.append("IMPOSSIBLE\n");
            }
        }

        System.out.print(result.toString());
    }
}