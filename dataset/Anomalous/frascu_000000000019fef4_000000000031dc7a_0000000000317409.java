import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String moves = scanner.next();
                
                int currentX = x;
                int currentY = y;
                int steps = 0;
                boolean reachedOrigin = false;

                for (int index = 0; index < moves.length(); index++) {
                    char move = moves.charAt(index);
                    switch (move) {
                        case 'S':
                            currentY--;
                            break;
                        case 'N':
                            currentY++;
                            break;
                        case 'E':
                            currentX++;
                            break;
                        case 'W':
                            currentX--;
                            break;
                    }
                    steps++;

                    if (currentX == 0 && currentY == 0) {
                        reachedOrigin = true;
                        break;
                    }

                    if (Math.abs(currentX) == Math.abs(currentY) && currentX == 1 && index < moves.length() - 1) {
                        char nextMove = moves.charAt(index + 1);
                        switch (nextMove) {
                            case 'S':
                                currentY--;
                                break;
                            case 'N':
                                currentY++;
                                break;
                            case 'E':
                                currentX++;
                                break;
                            case 'W':
                                currentX--;
                                break;
                        }
                        steps++;
                    }

                    if (Math.abs(currentX) > Math.abs(currentY)) {
                        currentX -= Integer.signum(currentX);
                    } else if (Math.abs(currentX) < Math.abs(currentY)) {
                        currentY -= Integer.signum(currentY);
                    } else {
                        currentX -= Integer.signum(currentX);
                    }

                    if (currentX == 0 && currentY == 0) {
                        reachedOrigin = true;
                        break;
                    }
                }

                if (reachedOrigin) {
                    System.out.println("Case #" + caseNumber + ": " + steps);
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                }
            }
        }
    }
}