import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            
            int pathLength = path.length();
            
            if (pathLength <= (x + y) / 2) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                continue;
            }
            
            boolean isPossible = false;
            
            for (int i = 0; i < pathLength; i++) {
                char direction = path.charAt(i);
                
                switch (direction) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                
                if (i + 1 >= Math.abs(x) + Math.abs(y)) {
                    System.out.println("Case #" + caseNumber + ": " + (i + 1));
                    isPossible = true;
                    break;
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}