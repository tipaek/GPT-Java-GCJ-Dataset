import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String directions = sc.next().trim();
            int length = directions.length();
            
            int currentX = x;
            int currentY = y;
            boolean found = false;

            for (int i = 0; i <= length; i++) {
                if (found) {
                    break;
                }

                if (isPossible(currentX, currentY, i)) {
                    found = true;
                    System.out.println("Case #" + caseNumber + ": " + i);
                } else if (i < length) {
                    char direction = directions.charAt(i);
                    switch (direction) {
                        case 'N': currentY++; break;
                        case 'S': currentY--; break;
                        case 'E': currentX++; break;
                        case 'W': currentX--; break;
                        default: break;
                    }
                }
            }

            if (!found) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }

    private static boolean isPossible(int x, int y, int steps) {
        return (Math.abs(x) + Math.abs(y)) <= steps;
    }
}