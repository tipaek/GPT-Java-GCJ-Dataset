import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= testCases; i++) {
            String inputLine = scanner.nextLine();
            String[] inputs = inputLine.split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            String directions = inputs[2];
            
            System.out.println("Case #" + i + ": " + calculateSteps(x, y, directions));
        }
    }

    private static String calculateSteps(int x, int y, String directions) {
        if (x == 0 && y == 0) {
            return "0";
        }
        
        int length = directions.length();
        for (int i = 0; i < length; i++) {
            int[] newPosition = move(x, y, directions.charAt(i));
            x = newPosition[0];
            y = newPosition[1];
            
            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                return String.valueOf(i + 1);
            }
        }
        return "IMPOSSIBLE";
    }

    private static int[] move(int x, int y, char direction) {
        switch (direction) {
            case 'N':
                return new int[] {x, y + 1};
            case 'E':
                return new int[] {x + 1, y};
            case 'W':
                return new int[] {x - 1, y};
            case 'S':
                return new int[] {x, y - 1};
            default:
                return new int[] {x, y};
        }
    }
}