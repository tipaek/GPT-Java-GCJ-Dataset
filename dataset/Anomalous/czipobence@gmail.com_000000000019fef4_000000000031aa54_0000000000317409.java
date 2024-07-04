import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character
            String movesStr = scanner.nextLine().trim();

            char[] moves = movesStr.toCharArray();
            int currentX = startX;
            int currentY = startY;
            int time = 0;
            boolean reached = startX == 0 && startY == 0;

            while (!reached && time < moves.length) {
                switch (moves[time]) {
                    case 'S':
                        currentY--;
                        break;
                    case 'N':
                        currentY++;
                        break;
                    case 'W':
                        currentX--;
                        break;
                    case 'E':
                        currentX++;
                        break;
                }
                time++;
                if (Math.abs(currentX) + Math.abs(currentY) <= time) {
                    reached = true;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + (reached ? time : "IMPOSSIBLE"));
        }
    }
}