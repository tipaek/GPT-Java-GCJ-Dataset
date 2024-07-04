import java.util.Scanner;
import java.util.ArrayList;

public class Solution
{
    public static String nest(String message)
    {
        String result = "";
        int depth = 0;
        for (int i = 0; i < message.length(); i++)
        {
            String mini = "";
            for (int j = depth; j < Character.getNumericValue(message.charAt(i)); j++)
            {
                mini = mini + "(";
                depth++;
            }
            for (int j = depth; j > Character.getNumericValue(message.charAt(i)); j--)
            {
                mini = mini + ")";
                depth--;
            }
            mini = mini + message.charAt(i);
            for (int j = depth; j > Character.getNumericValue(message.charAt(i)); j--)
            {
                //mini = mini + ")";
                //depth--;
            }
            result = result + mini;
        }
        for (int i = 0; i < depth; i++)
        {
            result = result + ")";
        }
        return result;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        for (int ks = 1; ks <= T; ks++) {
            String message = input.nextLine();
            String result = nest(message);
            System.out.println("Case #" + ks + ": " + result);
        }
    }
}