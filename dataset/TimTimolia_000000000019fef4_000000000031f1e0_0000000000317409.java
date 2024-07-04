import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseAmount = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        scanner.nextLine();
        a: for (int caseNumber = 1; caseNumber <= caseAmount; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String m = scanner.next();
            int posX = 0;
            int posY = 0;
            int count = 0;
            for (char c : m.toCharArray()) {
                switch (c) {
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'S': y--; break;
                    case 'W': x--; break;
                }
                if (posX < x) posX++;
                else if (posX > x) posX--;
                else {
                    if (posY < y) posY++;
                    else if (posY > y) posY--;
                }
                count++;
                if (posY == y && posX == x) {
                    System.out.println("Case #" + caseNumber + ": " + count);
                    continue a;
                }
            }
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }

    }

}
