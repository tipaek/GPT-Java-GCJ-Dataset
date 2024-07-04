import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            int result = findTraversalTime(x, y, directions);
            
            if (result == -1) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
    
    private static int findTraversalTime(int x, int y, String directions) {
        if (x == 0 && y == 0) return 0;
        
        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);
            int time = i + 1;
            
            switch (direction) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            
            int totalDistance = Math.abs(x) + Math.abs(y);
            if (totalDistance <= time) return time;
        }
        
        return -1;
    }
}