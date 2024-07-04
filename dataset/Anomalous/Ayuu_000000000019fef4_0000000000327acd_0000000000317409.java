import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            
            int result = -1;
            for (int step = 0; step < directions.length(); step++) {
                char direction = directions.charAt(step);
                
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                
                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= step + 1) {
                    result = step + 1;
                    break;
                }
            }
            
            if (result == -1) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
        
        scanner.close();
    }
}