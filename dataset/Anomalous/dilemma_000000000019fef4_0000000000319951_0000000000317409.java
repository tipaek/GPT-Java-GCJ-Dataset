import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            char[] directionArray = directions.toCharArray();

            if (x == 0 && y == 0) {
                writer.printf("Case #%d: 0\n", caseNumber);
            } else {
                int result = -1;
                for (int i = 0; i < directionArray.length; i++) {
                    char direction = directionArray[i];
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

                    if (Math.abs(x) + Math.abs(y) <= i + 1) {
                        result = i + 1;
                        break;
                    }
                }

                if (result == -1) {
                    writer.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
                } else {
                    writer.printf("Case #%d: %d\n", caseNumber, result);
                }
            }
        }

        writer.close();
    }
}