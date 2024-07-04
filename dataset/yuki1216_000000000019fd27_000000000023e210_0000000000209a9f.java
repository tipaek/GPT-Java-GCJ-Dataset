import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static int nest = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine());

        for (int i = 1; i <= t; ++i) {
            nest = 0;
            String input = in.nextLine();
            String result = "";

            for (int j = 0; j < input.length(); ++j) {
                char c = input.charAt(j);
                result = addBrackets(result, Character.getNumericValue(c));
            }

            StringBuilder sb = new StringBuilder();
            while (nest > 0) {
                sb.append(")");
                nest--;
            }
            result = result + sb;
            System.out.println("Case #" + i + ": " + result);
        }
        in.close();
    }

    private static String addBrackets(String str, int num) {

        if (num > nest) {
            StringBuilder sb = new StringBuilder();
            int diff = num - nest;
            for (int i = 0; i < diff; i++) {
                sb.append("(");
            }
            nest += diff;
            return str + sb + String.valueOf(num);
        }

        if (num < nest) {
            int diff = nest - num;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < diff; i++) {
                sb.append(")");
            }
            nest -= diff;
            return str + sb + String.valueOf(num);
        }
        return str + String.valueOf(num);
    }
}