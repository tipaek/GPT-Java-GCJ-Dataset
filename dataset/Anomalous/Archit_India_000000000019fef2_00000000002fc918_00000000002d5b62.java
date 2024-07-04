import java.util.*;

public class Solution {
    private static char[] path;
    private static int pathIndex = -1, stackIndex = -1;
    private static String[] stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int targetX = sc.nextInt();
            int targetY = sc.nextInt();
            path = new char[100];
            stack = new String[100];
            
            findPath(0, 0, targetX, targetY, 1);
            
            String result = "IMPOSSIBLE";
            int minLength = Integer.MAX_VALUE;
            
            for (int j = 0; j <= stackIndex; j++) {
                int length = stack[j].length();
                if (length < minLength) {
                    minLength = length;
                    result = stack[j];
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
            stackIndex = -1;
            pathIndex = -1;
        }
        
        sc.close();
    }

    private static void findPath(int currX, int currY, int targetX, int targetY, int step) {
        if (currX == targetX && currY == targetY) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= pathIndex; j++) {
                sb.append(path[j]);
            }
            stack[++stackIndex] = sb.toString();
            return;
        }
        
        if (currX > 100 || currX < -100 || currY > 100 || currY < -100) {
            return;
        }
        
        int units = (int) Math.pow(2, step - 1);
        
        path[++pathIndex] = 'N';
        findPath(currX, currY + units, targetX, targetY, step + 1);
        pathIndex--;
        
        path[++pathIndex] = 'S';
        findPath(currX, currY - units, targetX, targetY, step + 1);
        pathIndex--;
        
        path[++pathIndex] = 'E';
        findPath(currX + units, currY, targetX, targetY, step + 1);
        pathIndex--;
        
        path[++pathIndex] = 'W';
        findPath(currX - units, currY, targetX, targetY, step + 1);
        pathIndex--;
    }
}