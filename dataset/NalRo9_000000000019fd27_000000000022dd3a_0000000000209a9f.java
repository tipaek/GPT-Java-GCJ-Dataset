import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void printBracket(int before, int now) {
        int diff = Math.abs(before - now);

        if(before < now) {
            for(int i = 0; i < diff; i++) {
                System.out.print("(");
            }
        } else {
            for(int i = 0; i < diff; i++) {
                System.out.print(")");
            }
        }
    }

    public static void solve(Scanner scanner, int tc) {
        String s = scanner.next();
        int lv = 0;

        System.out.print(String.format("Case #%d: ", tc));

        for(char c : s.toCharArray()) {
            int now = Character.getNumericValue(c);
            printBracket(lv, now);
            System.out.print(c);
            lv = now;
        }
        printBracket(lv, 0);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            solve(scanner, i + 1);
        }
    }
}