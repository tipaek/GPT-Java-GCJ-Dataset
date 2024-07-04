import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next().trim();
            int steps = path.length();
            boolean reached = false;
            int minSteps = 0;
            
            for (int step = 1; step <= steps; step++) {
                char direction = path.charAt(step - 1);
                
                switch (direction) {
                    case 'N':
                        y += 1;
                        break;
                    case 'S':
                        y -= 1;
                        break;
                    case 'E':
                        x += 1;
                        break;
                    case 'W':
                        x -= 1;
                        break;
                }
                
                if (Math.abs(x) + Math.abs(y) <= step) {
                    reached = true;
                    minSteps = step;
                    break;
                }
            }
            
            if (reached) {
                System.out.println("Case #" + caseNumber + ": " + minSteps);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}