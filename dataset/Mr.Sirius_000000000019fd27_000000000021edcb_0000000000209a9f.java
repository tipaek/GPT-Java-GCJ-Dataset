import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner sc;

        if (args.length > 0) {
            sc = new Scanner(new File(args[0]));
        } else {
            sc = new Scanner(System.in);
        }

        int t = sc.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            System.out.println("Case #" + tt + ": " + _s(sc));
        }
        sc.close();
    }

    static String _s(Scanner sc) {
        StringBuilder sb = new StringBuilder();
        int openBracket = 0;
        String s = sc.nextLine();
        while (s.equals("")) {
            s = sc.nextLine();
        }
        int num[] = s.chars().map(i -> i - 48).toArray();

        for (int i : num) {
            if (i > openBracket) {
                int quant = i - openBracket;
                openBracket = i;
                sb.append(addBrackets(quant, '(')).append(i);
            } else if (i < openBracket) {
                int quant = openBracket - i;
                openBracket = i;
                sb.append(addBrackets(quant, ')')).append(i);
            } else {
                sb.append(i);
            }
        }
        if (openBracket > 0) sb.append(addBrackets(openBracket, ')'));
        return sb.toString();
    }

    static String addBrackets(int quantity, char bracket) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quantity; ++i) sb.append(bracket);
        return sb.toString();
    }
}