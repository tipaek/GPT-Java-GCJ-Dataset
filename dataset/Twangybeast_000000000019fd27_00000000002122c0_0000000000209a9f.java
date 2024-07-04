import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static String fixString(String s) {
        boolean change;
        do {
            change = false;
            String result = "";
            boolean closing = false;
            for (char c : s.toCharArray()) {
                if (c == '(' || c == ')') {
                    result = result + c;
                } else {
                    if (c == '0') {
                        if (closing) {
                            closing = false;
                            result += ')';
                        }
                        result += c;
                    } else {
                        if (!closing) {
                            closing = true;
                            result += '(';
                            change = true;
                        }
                        result += (char)(c - 1);
                    }
                }
            }
            if (closing) {
                result += ')';
            }
            s = result;
        } while (change);
        return s;
    }
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new FileReader("in.txt"));

        int T = in.nextInt();
        in.nextLine();
        for (int t = 0; t < T; t++)
        {
            String original = in.nextLine();

            String result = fixString(original);
            String s = "";
            int i = 0;
            for (char c : result.toCharArray()) {
                if (c == '(' || c == ')') {
                    s += c;
                } else {
                    s += original.charAt(i);
                    i++;
                }
            }
            System.out.printf("Case #%d: %s\n", t + 1, s);
        }
        in.close();
    }
}
