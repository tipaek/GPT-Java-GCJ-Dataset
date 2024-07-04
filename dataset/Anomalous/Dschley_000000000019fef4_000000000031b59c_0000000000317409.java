import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            
            String result = calculateTimeToConverge(x, y, path);
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    private static String calculateTimeToConverge(int x, int y, String path) {
        int totalSteps = path.length();
        int timeElapsed = 0;
        int manhattanDistance = Math.abs(x) + Math.abs(y);
        
        Map<Character, Integer> directionMap = new HashMap<>();
        directionMap.put('N', 1);
        directionMap.put('E', 1);
        directionMap.put('S', -1);
        directionMap.put('W', -1);
        
        for (int i = 0; i < totalSteps; i++) {
            if (timeElapsed >= manhattanDistance) {
                return String.valueOf(timeElapsed);
            }
            timeElapsed++;
            
            char direction = path.charAt(i);
            if (direction == 'N' || direction == 'S') {
                y += directionMap.get(direction);
            } else {
                x += directionMap.get(direction);
            }
            
            manhattanDistance = Math.abs(x) + Math.abs(y);
        }
        
        if (timeElapsed >= manhattanDistance) {
            return String.valueOf(timeElapsed);
        }
        
        return "IMPOSSIBLE";
    }
}