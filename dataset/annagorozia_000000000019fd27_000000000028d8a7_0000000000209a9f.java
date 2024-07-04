

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        short T = Short.parseShort(myReader.nextLine());
        for (int i = 0; i < T; i++) {
            String res = addParenthesis(new StringBuilder(myReader.nextLine()));
            System.out.println("Case #" + (i + 1) + ": " + res);
        }

        myReader.close();
    }

    private static String addParenthesis(StringBuilder sb) {
        StringBuilder res = new StringBuilder("");
        short prev = 0;
        short currDepth = 0;
        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            short num = Short.parseShort("" + sb.charAt(i));
            if (i == 0 || currDepth == 0) {
                currDepth += num;
                prepand(res, num, index);
                res.append(num);
                prev = num;
                if (i == sb.length() - 1) {
                    append(res, currDepth);
                }
                continue;
            }
            if (num == prev) {
                res.append(num);
                prev = num;
                continue;
            }
            if (num < prev) {
                append(res, (short) (prev - num));
                res.append(num);
                currDepth -= (prev - num);
                prev = num;
                index = res.length();

                continue;
            }
            if (num > prev ) {
                res.append(num);
                index = res.length();
                append(res, currDepth);

                currDepth = 0;
                prev = num;
                continue;
            }
            if (i == (sb.length() - 1)) {
                res.append(num);
                index = res.length();
                append(res, currDepth);

                currDepth = 0;
                prev = num;
            }

        }


        return res.toString();
    }

    private static void prepand(StringBuilder res, short num, int index) {
        for (int i = 0; i < num; i++) {
            res.insert(index, '(');
        }
    }

    private static void append(StringBuilder res, short num) {
        for (int i = 0; i < num; i++) {
            res.append(')');
        }
    }


}
