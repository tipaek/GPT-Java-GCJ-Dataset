import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int i = 0; i < testCaseCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String movements = scanner.next();
            
            int result = calculateMinimumTime(x, y, movements);
            System.out.println("Case #" + (i + 1) + ": " + (result == -1 ? "IMPOSSIBLE" : result));
        }
    }
    
    private static int calculateMinimumTime(int x, int y, String movements) {
        if (x == 0 && y == 0) {
            return 0;
        }
        
        for (int i = 0; i < movements.length(); i++) {
            char move = movements.charAt(i);
            
            switch (move) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'W': x--; break;
                case 'E': x++; break;
            }
            
            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= i + 1) {
                return i + 1;
            }
        }
        
        return -1;
    }
}