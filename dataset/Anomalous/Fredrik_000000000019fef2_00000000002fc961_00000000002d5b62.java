package ax.makila;

import java.util.*;
import java.io.*;

class Jump {
    StringBuilder route;
    int[] position;
    int level;

    public Jump(int[] position) {
        this.route = new StringBuilder();
        this.position = position;
        this.level = 0;
    }

    public Jump(int x, int y) {
        this(new int[]{x, y});
    }

    public Jump(int x, int y, int level, StringBuilder route) {
        this(new int[]{x, y});
        this.level = level;
        this.route = route;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int[] targetCoords = readCoordinates(scanner);
            Set<String> visited = new HashSet<>();
            Queue<Jump> queue = new LinkedList<>();
            queue.offer(new Jump(0, 0));

            while (!queue.isEmpty()) {
                Jump currentJump = queue.poll();
                int x = currentJump.position[0];
                int y = currentJump.position[1];
                visited.add(x + "," + y);

                if (x == targetCoords[0] && y == targetCoords[1]) {
                    System.out.printf("Case %d: %s%n", i, currentJump.route.toString());
                    break;
                }

                int distance = (int) Math.pow(2, currentJump.level);

                if (isValidMove(x - distance, y, visited)) {
                    queue.offer(createNewJump(x - distance, y, currentJump, "E"));
                }

                if (isValidMove(x + distance, y, visited)) {
                    queue.offer(createNewJump(x + distance, y, currentJump, "W"));
                }

                if (isValidMove(x, y - distance, visited)) {
                    queue.offer(createNewJump(x, y - distance, currentJump, "S"));
                }

                if (isValidMove(x, y + distance, visited)) {
                    queue.offer(createNewJump(x, y + distance, currentJump, "N"));
                }
            }

            if (queue.isEmpty()) {
                System.out.printf("Case %d: IMPOSSIBLE%n", i);
            }
        }
    }

    private static int[] readCoordinates(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        return new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])};
    }

    private static boolean isValidMove(int x, int y, Set<String> visited) {
        return x >= -100 && x <= 100 && y >= -100 && y <= 100 && !visited.contains(x + "," + y);
    }

    private static Jump createNewJump(int x, int y, Jump currentJump, String direction) {
        Jump newJump = new Jump(x, y, currentJump.level + 1, new StringBuilder(currentJump.route));
        newJump.route.append(direction);
        return newJump;
    }
}