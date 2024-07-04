import java.util.Scanner;

public class Solution {

    private static int calculateManhattanDistance(int[] pointA, int[] pointB) {
        return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
    }

    private static int isReachableWithinTime(int[] target, int[] start, int time) {
        int distance = calculateManhattanDistance(target, start);
        return (distance <= time) ? time : -1;
    }

    public static int findWalkTime(int[] position, String directions) throws Exception {
        int[] initialPosition = {0, 0};
        int elapsedTime = 0;

        for (int i = 0; i < directions.length(); i++) {
            elapsedTime = i + 1;
            switch (directions.charAt(i)) {
                case 'N':
                    position[1] += 1;
                    break;
                case 'S':
                    position[1] -= 1;
                    break;
                case 'E':
                    position[0] += 1;
                    break;
                case 'W':
                    position[0] -= 1;
                    break;
            }
            int reachableTime = isReachableWithinTime(position, initialPosition, elapsedTime);
            if (reachableTime != -1) return reachableTime;
        }
        throw new Exception("IMPOSSIBLE");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int[] position = new int[2];
            position[0] = scanner.nextInt();
            position[1] = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline
            String directions = scanner.nextLine().trim();

            try {
                int result = findWalkTime(position, directions);
                System.out.println("Case #" + i + ": " + result);
            } catch (Exception e) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}