import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        try {
            InputStream is = System.in;
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
            int t = scanner.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            scanner.nextLine();//skip last nextline

            for (int i = 1; i <= t; ++i) {
                System.out.print("Case #");
                System.out.print(i);
                System.out.print(": ");
                solve(scanner);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void solve(Scanner scanner) {
        char[] str = ("0" + scanner.nextLine() + "0").toCharArray();
        Stack<Character> dst = new Stack<>();
        for (int i = 1; i < str.length; i++) {
            char current = str[i];
            char prev = str[i - 1];
            int diff = current - prev;

            if (diff > 0) {
                for (int j = 0; j < diff; j++)
                    dst.push('(');
                dst.push(current);
            } else {
                for (int j = 0; j < diff * (-1); j++)
                    dst.push(')');
                dst.push(current);
            }
        }

        for (int i = 0; i < dst.size() - 1; i++)
            System.out.print((char) dst.get(i));

        System.out.println();
    }
}
