import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String n = in.nextLine();
            String s = "";
            int previousNum = 0;
            int openingBracket = 0;
            for (int j = 0; j < n.length(); j++) {
                int d = Integer.parseInt(n.substring(j, j + 1));
                if (d == 0) {
                    while (openingBracket > 0) {
                        s += ")";
                        openingBracket--;
                    }
                } else if (d > previousNum) {
                    int numOfParentheses = d - previousNum;
                    openingBracket += numOfParentheses;
                    while (numOfParentheses-- > 0) {
                        s += "(";
                    }
                } else if (d < previousNum) {
                    int numOfParentheses = previousNum - d;
                    openingBracket -= numOfParentheses;
                    while (numOfParentheses-- > 0) {
                        s += ")";
                    }
                }
                s += d;
                previousNum = d;
            }
            if (openingBracket > 0) {
                while (openingBracket-- > 0) {
                    s += ")";
                }
            }
            System.out.println("Case #" + i + ": " + s);
        }
    }
}
