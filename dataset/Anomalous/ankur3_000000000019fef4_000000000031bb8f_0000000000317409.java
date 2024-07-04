import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int totalCases = testCases;

        while (testCases-- > 0) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String directions = scanner.next();

            int[] distanceArray = new int[directions.length() + 1];
            int currentX = startX;
            int currentY = startY;
            boolean reachable = false;
            int steps = -1;

            distanceArray[0] = Math.abs(currentX) + Math.abs(currentY);

            for (int i = 1; i < distanceArray.length; i++) {
                char direction = directions.charAt(i - 1);
                switch (direction) {
                    case 'N':
                        currentY++;
                        break;
                    case 'S':
                        currentY--;
                        break;
                    case 'E':
                        currentX++;
                        break;
                    case 'W':
                        currentX--;
                        break;
                }
                distanceArray[i] = Math.abs(currentX) + Math.abs(currentY);
                if (distanceArray[i] <= i) {
                    steps = i;
                    reachable = true;
                    break;
                }
            }

            if (reachable) {
                System.out.println("Case #" + (totalCases - testCases) + ": " + steps);
            } else {
                System.out.println("Case #" + (totalCases - testCases) + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}