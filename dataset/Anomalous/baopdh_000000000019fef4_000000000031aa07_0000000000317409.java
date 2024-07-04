import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Map<Character, int[]> directionMap = new HashMap<>();
        directionMap.put('S', new int[]{0, -1});
        directionMap.put('N', new int[]{0, 1});
        directionMap.put('W', new int[]{-1, 0});
        directionMap.put('E', new int[]{1, 0});

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();

            boolean reached = false;
            for (int timeElapsed = 1; timeElapsed <= moves.length(); timeElapsed++) {
                char move = moves.charAt(timeElapsed - 1);
                int[] delta = directionMap.get(move);
                x += delta[0];
                y += delta[1];

                if (Math.abs(x) + Math.abs(y) <= timeElapsed) {
                    System.out.println("Case #" + caseNumber + ": " + timeElapsed);
                    reached = true;
                    break;
                }
            }

            if (!reached) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}