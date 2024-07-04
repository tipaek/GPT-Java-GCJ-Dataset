import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int t = 1; t <= testCaseCount; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            char[] moveArray = moves.toCharArray();

            int xCurrent = x;
            int yCurrent = y;
            int minutes = 0;
            boolean reached = false;

            for (int i = 0; i < moveArray.length; i++) {
                switch (moveArray[i]) {
                    case 'N': yCurrent++; break;
                    case 'S': yCurrent--; break;
                    case 'E': xCurrent++; break;
                    case 'W': xCurrent--; break;
                }

                minutes++;

                if (xCurrent == 0 && yCurrent == 0) {
                    reached = true;
                    break;
                }

                if (Math.abs(xCurrent) > Math.abs(yCurrent)) {
                    xCurrent += (xCurrent < 0) ? 1 : -1;
                } else if (Math.abs(xCurrent) < Math.abs(yCurrent)) {
                    yCurrent += (yCurrent < 0) ? 1 : -1;
                } else {
                    if (i + 1 < moveArray.length) {
                        int nextX = xCurrent, nextY = yCurrent;
                        switch (moveArray[i + 1]) {
                            case 'N': nextY++; break;
                            case 'S': nextY--; break;
                            case 'E': nextX++; break;
                            case 'W': nextX--; break;
                        }
                        if (Math.abs(nextX) > Math.abs(nextY)) {
                            xCurrent += (xCurrent < 0) ? 1 : -1;
                        } else {
                            yCurrent += (yCurrent < 0) ? 1 : -1;
                        }
                    }
                }

                if (xCurrent == 0 && yCurrent == 0) {
                    reached = true;
                    break;
                }
            }

            if (reached) {
                System.out.println("Case #" + t + ": " + minutes);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}