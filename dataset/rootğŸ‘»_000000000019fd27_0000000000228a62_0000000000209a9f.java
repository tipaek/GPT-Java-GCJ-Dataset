import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int test = 1; test <= tests; ++test) {
            String next = in.next();
            StringBuilder list = new StringBuilder();
            int lastOpenedParenthesis = 0;
            for (int i = 0; i < next.length(); ++i) {
                int n = Character.getNumericValue(next.charAt(i));
                if (n != lastOpenedParenthesis) {
                    while (n > lastOpenedParenthesis) {
                        list.append('(');
                        ++lastOpenedParenthesis;
                    }
                    while (n < lastOpenedParenthesis) {
                        list.append(')');
                        --lastOpenedParenthesis;
                    }
                }
                list.append(next.charAt(i));
            }
            while (lastOpenedParenthesis > 0) {
                list.append(')');
                --lastOpenedParenthesis;
            }
            System.out.printf("Case #%d: %s\n", test, list.toString());
        }
    }
}