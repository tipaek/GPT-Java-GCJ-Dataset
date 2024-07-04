import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String movements = input[2];
            
            int currentX = x;
            int currentY = y;
            int remainingTime = movements.length();
            
            for (int i = 0; i < movements.length(); i++) {
                char move = movements.charAt(i);
                
                switch (move) {
                    case 'W':
                        if (currentX > 0) {
                            currentX--;
                            remainingTime--;
                        }
                        break;
                    case 'E':
                        currentX++;
                        remainingTime--;
                        break;
                    case 'N':
                        currentY++;
                        remainingTime--;
                        break;
                    case 'S':
                        if (currentY > 0) {
                            currentY--;
                            remainingTime--;
                        }
                        break;
                }
                
                if (currentX <= 0) {
                    currentX = 0;
                    break;
                }
                if (currentY <= 0) {
                    currentY = 0;
                    break;
                }
            }
            
            int totalTime = movements.length();
            if (remainingTime + Math.abs(currentX) + Math.abs(currentY) <= totalTime) {
                int resultTime = Math.max(remainingTime + Math.abs(currentX) + Math.abs(currentY),
                                          totalTime - (remainingTime + Math.abs(currentX) + Math.abs(currentY)));
                System.out.println("Case #" + caseNumber + ": " + resultTime);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}