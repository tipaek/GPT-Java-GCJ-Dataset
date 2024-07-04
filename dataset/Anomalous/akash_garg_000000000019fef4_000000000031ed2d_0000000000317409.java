import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            
            int steps = 0;
            boolean reached = false;
            
            for (int index = 0; index < directions.length(); index++, steps++) {
                if (steps >= Math.abs(x) + Math.abs(y)) {
                    reached = true;
                    System.out.println(steps);
                    break;
                }
                
                char direction = directions.charAt(index);
                switch (direction) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
            }
            
            if (!reached) {
                if (steps >= Math.abs(x) + Math.abs(y)) {
                    System.out.println(steps);
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
    }
}