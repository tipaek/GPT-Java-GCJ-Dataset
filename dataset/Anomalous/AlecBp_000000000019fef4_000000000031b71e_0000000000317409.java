import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String movements = scanner.next();
            boolean isSolved = false;

            for (int j = 0; j < movements.length(); j++) {
                char move = movements.charAt(j);
                switch (move) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'W': x--; break;
                    case 'E': x++; break;
                }

                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= j + 1) {
                    System.out.println("Case #" + i + ": " + (j + 1));
                    isSolved = true;
                    break;
                }
            }

            if (!isSolved) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}