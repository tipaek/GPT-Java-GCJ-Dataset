import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out))) {
            processInput(scanner, writer);
        }
    }

    private static void processInput(Scanner scanner, PrintWriter writer) {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            int steps = 0;
            boolean reached = false;
            
            for (int i = 0; i < moves.length(); i++) {
                switch (moves.charAt(i)) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                steps++;
                
                if (Math.abs(x) + Math.abs(y) <= steps) {
                    reached = true;
                    break;
                }
            }
            writer.println("Case #" + t + ": " + (reached ? steps : "IMPOSSIBLE"));
        }
    }
}