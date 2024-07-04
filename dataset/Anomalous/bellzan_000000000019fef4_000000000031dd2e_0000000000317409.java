import java.io.*;
import java.util.*;

public class Solution {
    private static int startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            String path = st.nextToken();

            int totalTime = path.length();
            endX = startX;
            endY = startY;

            // Calculate the endpoint
            for (char direction : path.toCharArray()) {
                switch (direction) {
                    case 'N': endY++; break;
                    case 'S': endY--; break;
                    case 'W': endX--; break;
                    case 'E': endX++; break;
                }
            }

            boolean isPossible = Math.abs(endX) + Math.abs(endY) <= totalTime;
            int remainingTime = totalTime - (Math.abs(endX) + Math.abs(endY));
            int currentX = endX, currentY = endY;
            int answer = totalTime;
            boolean done = false;

            if (isPossible) {
                for (int j = totalTime - 1; j >= 0 && !done; j--) {
                    char currentChar = path.charAt(j);
                    if (canMove(currentChar, currentX, currentY)) {
                        move(currentChar, currentX, currentY);
                        answer--;
                    } else if (remainingTime > 1) {
                        remainingTime -= 2;
                        move(currentChar, currentX, currentY);
                        answer--;
                    } else {
                        done = true;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + (isPossible ? answer : "IMPOSSIBLE"));
        }
    }

    private static boolean canMove(char direction, int x, int y) {
        switch (direction) {
            case 'N': return y > 0;
            case 'S': return y < 0;
            case 'W': return x < 0;
            case 'E': return x > 0;
            default: return false;
        }
    }

    private static void move(char direction, int x, int y) {
        switch (direction) {
            case 'N': y--; break;
            case 'S': y++; break;
            case 'W': x++; break;
            case 'E': x--; break;
        }
    }
}