import java.util.Scanner;
import java.util.Stack;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases;

        noOfTestCases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < noOfTestCases; i++) {
            String str = sc.nextLine();
            String result = balanceString(str);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String balanceString(String str)
    {
        String result = null;

        char[] ch = str.toCharArray();
        int open = 0;

        int required = 0;
        int digit = 0;
        int j = 0;

        Stack<String> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            digit = Character.getNumericValue(ch[i]);

            if (digit > open) {

                required = digit - open;
                open += required;

                while (j < required) {
                    st.push("(");
                    j++;
                }
            } else if (digit < open || digit == 0) {

                required = open - digit;
                open -= required;

                while (j < required) {
                    st.push(")");
                    j++;
                }
            }

            st.push(String.valueOf(digit));
            j = 0;
            required = 0;
        }

        for (int i = 0; i < open; i++) {
            st.push(")");
        }

        StringBuilder builder = new StringBuilder();
        while (!st.isEmpty()) {
            builder.append(st.peek());
            st.pop();
        }
        result = builder.reverse().toString();
        return result;
    }
}