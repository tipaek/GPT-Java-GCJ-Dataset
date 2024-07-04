import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int t = 1; t <= T; t++) {
            int x = input.nextInt();
            int y = input.nextInt();
            String M = input.next();

            int[][] map = new int[2000][2000];
            for (int[] row : map) Arrays.fill(row, -1);
            map[999 + y][999 - x] = 0;

            Queue<String> queue = new LinkedList<>();
            queue.add((999 + y) + "," + (999 - x));
            int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

            int northBound = 999 - M.length();
            int southBound = 999 + M.length();
            int westBound = 999 - M.length();
            int eastBound = 999 + M.length();

            int step = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String[] current = queue.poll().split(",");
                    int currX = Integer.parseInt(current[0]);
                    int currY = Integer.parseInt(current[1]);

                    for (int[] direction : directions) {
                        int newX = currX + direction[0];
                        int newY = currY + direction[1];
                        if (newX >= northBound && newY >= westBound && newX <= southBound && newY <= eastBound && map[newX][newY] == -1) {
                            map[newX][newY] = step;
                            queue.add(newX + "," + newY);
                        }
                    }
                }
                step++;
            }

            int i = 999, j = 999;
            int count = 0;
            int result = Integer.MAX_VALUE;
            for (char c : M.toCharArray()) {
                switch (c) {
                    case 'W': j--; break;
                    case 'E': j++; break;
                    case 'N': i--; break;
                    case 'S': i++; break;
                }
                count++;
                if (map[i][j] != -1 && map[i][j] <= count) {
                    result = Math.min(result, count);
                }
            }

            if (result == Integer.MAX_VALUE) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }
}