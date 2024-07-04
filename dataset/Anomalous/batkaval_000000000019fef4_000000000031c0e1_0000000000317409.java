import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String movements = scanner.next();
            int maxTime = movements.length();
            
            boolean found = false;
            for (int i = 0; i < maxTime; i++) {
                switch (movements.charAt(i)) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }
                
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    System.out.println(i + 1);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}