import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, i);
        }
    }
    
    static void processTestCase(Scanner scanner, int caseNumber) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x == 0 && y == 0) {
            System.out.println("Case #" + caseNumber + ": 0");
            return;
        }
        
        String moves = scanner.next();
        int moveCount = moves.length();
        int steps = 0;
        boolean isSolvable = false;
        
        for (int i = 0; i < moveCount; i++) {
            char move = moves.charAt(i);
            steps++;
            
            switch (move) {
                case 'N': y++; break;
                case 'E': x++; break;
                case 'S': y--; break;
                case 'W': x--; break;
            }
            
            if (Math.abs(x) + Math.abs(y) <= steps) {
                isSolvable = true;
                break;
            }
        }
        
        if (isSolvable) {
            System.out.println("Case #" + caseNumber + ": " + steps);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}