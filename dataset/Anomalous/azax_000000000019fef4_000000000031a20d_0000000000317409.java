import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numCases; i++) {
                String[] input = scanner.nextLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                String path = input[2];
                
                System.out.println("Case #" + (i + 1) + ": " + findMinimumTime(x, y, path));
            }
        }
    }
    
    private static String findMinimumTime(int x, int y, String path) {
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
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
            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                return String.valueOf(i + 1);
            }
        }
        return "IMPOSSIBLE";
    }
}