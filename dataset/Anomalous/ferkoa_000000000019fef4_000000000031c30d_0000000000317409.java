import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static String solve(int x, int y, String m) {
        int distance = Math.abs(x) + Math.abs(y);
        char[] moves = m.toCharArray();
        
        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown character (" + moves[i] + ") in " + m);
            }
            
            distance = Math.abs(x) + Math.abs(y);
            if (i + 1 >= distance) {
                return String.valueOf(i + 1);
            }
        }
        
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream output = System.out;

        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.nextLine().trim();
            output.println("Case #" + i + ": " + solve(x, y, moves));
        }
        
        scanner.close();
    }
}