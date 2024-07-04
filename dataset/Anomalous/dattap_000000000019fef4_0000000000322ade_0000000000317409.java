import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            String[] input = scanner.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            String movements = input[2];
            
            int currentX = X;
            int currentY = Y;
            int remainingTime = movements.length();
            
            for (int i = 0; i < movements.length(); i++) {
                char move = movements.charAt(i);
                
                switch (move) {
                    case 'W':
                        if (currentX > 0) currentX--;
                        break;
                    case 'E':
                        currentX++;
                        break;
                    case 'N':
                        currentY++;
                        break;
                    case 'S':
                        if (currentY > 0) currentY--;
                        break;
                }
                
                if (currentX <= 0) currentX = 0;
                if (currentY <= 0) currentY = 0;
                
                remainingTime--;
                
                if (currentX == 0 && currentY == 0) break;
            }
            
            int totalTime = movements.length() - remainingTime;
            int minTime = Math.max(totalTime + Math.abs(currentX) + Math.abs(currentY), movements.length() - (totalTime + Math.abs(currentX) + Math.abs(currentY)));
            
            if (minTime <= movements.length()) {
                System.out.println("Case #" + caseNumber + ": " + minTime);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}