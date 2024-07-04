import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String movesString = scanner.nextLine().trim();
            char[] moves = movesString.toCharArray();

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

            String result = reached ? String.valueOf(time) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}