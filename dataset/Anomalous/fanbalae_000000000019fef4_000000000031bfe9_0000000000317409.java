import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String movements = scanner.next();
            
            int minSteps = Integer.MAX_VALUE;
            int distance = 0;
            int steps = 0;
            
            for (int i = 0; i < movements.length(); i++) {
                char direction = movements.charAt(i);
                
                switch (direction) {
                    case 'S':
                        y -= 1;
                        break;
                    case 'W':
                        x -= 1;
                        break;
                    case 'N':
                        y += 1;
                        break;
                    case 'E':
                        x += 1;
                        break;
                }
                
                distance = Math.abs(x) + Math.abs(y);
                steps++;
                
                if (steps >= distance) {
                    minSteps = steps;
                    break;
                }
            }
            
            if (distance > movements.length()) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + minSteps);
            }
        }
        
        scanner.close();
    }
}