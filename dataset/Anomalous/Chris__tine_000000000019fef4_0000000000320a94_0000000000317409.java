import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String moves = scanner.next();
            System.out.printf("Case #%d: %s\n", t + 1, findMinimumTime(startX, startY, moves));
        }
    }
    
    public static String findMinimumTime(int startX, int startY, String moves) {
        int moveCount = moves.length();
        int[][] positions = new int[moveCount + 1][2];
        positions[0][0] = startX;
        positions[0][1] = startY;
        
        for (int i = 0; i < moveCount; i++) {
            char move = moves.charAt(i);
            positions[i + 1][0] = positions[i][0];
            positions[i + 1][1] = positions[i][1];
            
            switch (move) {
                case 'W':
                    positions[i + 1][0]--;
                    break;
                case 'E':
                    positions[i + 1][0]++;
                    break;
                case 'S':
                    positions[i + 1][1]--;
                    break;
                case 'N':
                    positions[i + 1][1]++;
                    break;
            }
        }
        
        for (int i = 0; i <= moveCount; i++) {
            int distance = Math.abs(positions[i][0]) + Math.abs(positions[i][1]);
            if (distance <= i) {
                return Integer.toString(i);
            }
        }
        
        return "IMPOSSIBLE";
    }
}