import java.util.Scanner;

public class Solution {

    public static int getResult(int targetX, int targetY, String road) {
        int[] distance = new int[road.length() + 1];
        distance[0] = Math.abs(targetX) + Math.abs(targetY);

        for (int i = 0; i < road.length(); i++) {
            char direction = road.charAt(i);
            if (direction == 'N') {
                targetY++;
            } else if (direction == 'S') {
                targetY--;
            } else if (direction == 'E') {
                targetX++;
            } else if (direction == 'W') {
                targetX--;
            }
            distance[i + 1] = Math.abs(targetX) + Math.abs(targetY);
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] <= i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            String road = scanner.next();

            System.out.print("Case #" + i + ": ");
            int result = getResult(targetX, targetY, road);
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }
}