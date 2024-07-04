import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            int moves = -1;

            if (x == 0 && y == 0) {
                moves = 0;
            } else {
                for (int step = 0; step < path.length(); step++) {
                    char direction = path.charAt(step);
                    switch (direction) {
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
                    if (Math.abs(x) + Math.abs(y) <= step + 1) {
                        moves = step + 1;
                        break;
                    }
                }
            }

            String result = (moves >= 0) ? String.valueOf(moves) : "IMPOSSIBLE";
            System.out.println(String.format("Case #%d: %s", caseNumber, result));
        }
    }
}