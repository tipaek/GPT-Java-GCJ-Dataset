import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        short T = Short.parseShort(myReader.nextLine());
        for (int i = 0; i < T; i++) {
            String res = addParenthesis(myReader.nextLine());
            System.out.println("Case #" + (i + 1) + ": " + res);
        }

        myReader.close();
    }

    private static String addParenthesis(String input) {
        StringBuilder res = new StringBuilder();
        short prev = 0;
        short currDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            short num = Short.parseShort(String.valueOf(input.charAt(i)));

            if (num > currDepth) {
                appendParentheses(res, num - currDepth, '(');
            } else if (num < currDepth) {
                appendParentheses(res, currDepth - num, ')');
            }

            res.append(num);
            currDepth = num;
        }

        appendParentheses(res, currDepth, ')');
        return res.toString();
    }

    private static void appendParentheses(StringBuilder res, int count, char parenthesis) {
        for (int i = 0; i < count; i++) {
            res.append(parenthesis);
        }
    }
}