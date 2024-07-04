import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < cases; i++) {
            System.out.println("Case #"+ (i + 1)  + ": " + getString(scan.nextLine().toCharArray()));
        }
    }

    public static String getString(char[] str)
    {
        String res = new String();
        int previous = 0;
        int current;
        for (char c: str)
        {
            current = Integer.parseInt(c + "");
            res = pushParentheses(res, current - previous, c);
            previous = current;
        }
        current = 0;
        res = pushParentheses(res, current - previous, '\0');
        return (res);
    }

    public static String pushParentheses(String str, int positiveNumber, char next)
    {
        char c;
        String res = "";
        if (positiveNumber >= 0)
            c = '(';
        else
            c = ')';
        positiveNumber = Math.abs(positiveNumber);
        for (int i = 0; i < positiveNumber; i++)
            res = res + c;
        return (str + res + ((next != '\0') ? next : ""));
    }

}
