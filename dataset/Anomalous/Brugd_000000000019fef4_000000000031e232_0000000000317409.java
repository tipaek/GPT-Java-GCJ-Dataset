import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in); PrintWriter output = new PrintWriter(System.out)) {
            int T = input.nextInt();
            
            for (int i = 0; i < T; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                String movement = input.next();
                String result = solve(x, y, movement);
                output.printf("Case #%d: %s%n", (i + 1), result);
                output.flush();
            }
        }
    }
    
    private static int[] getMovement(char direction) {
        switch (direction) {
            case 'E': return new int[]{1, 0};
            case 'W': return new int[]{-1, 0};
            case 'S': return new int[]{0, -1};
            case 'N': return new int[]{0, 1};
            default: return new int[]{0, 0}; // Default case should not be reached
        }
    }
    
    private static int calculateDistance(int[] position) {
        return Math.abs(position[0]) + Math.abs(position[1]);
    }
    
    private static String solve(int x, int y, String movement) {
        int[] catPosition = new int[]{x, y};
        int[] myPosition = new int[]{0, 0};
        
        int moves = 0;
        int distance;
        int index = 0;
        char[] moveArray = movement.toCharArray();

        while (index <= moveArray.length) {
            distance = calculateDistance(catPosition);
            if (distance <= index) {
                return Integer.toString(index); 
            }
            
            if (index == moveArray.length) {
                break;
            }
            
            char currentMove = moveArray[index];
            int[] moveVector = getMovement(currentMove);
            
            catPosition[0] += moveVector[0];
            catPosition[1] += moveVector[1];
            
            index++;
        }                
       
        return IMPOSSIBLE;
    }
}