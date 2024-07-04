import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            int steps = 0;
            boolean reached = false;
            
            for (int j = 0; j < directions.length(); j++) {
                if (Math.abs(x) + Math.abs(y) <= steps) {
                    System.out.println("Case #" + i + ": " + steps);
                    reached = true;
                    break;
                }
                steps++;
                char direction = directions.charAt(j);
                switch (direction) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                    case 'W': x--; break;
                    case 'E': x++; break;
                }
            }
            
            if (!reached) {
                if (Math.abs(x) + Math.abs(y) <= steps) {
                    System.out.println("Case #" + i + ": " + steps);
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        }
        
        scanner.close();
    }
}