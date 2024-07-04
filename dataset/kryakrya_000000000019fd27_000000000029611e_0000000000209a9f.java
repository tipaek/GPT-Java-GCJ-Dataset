import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) {
        int temp_depth = scanner.nextInt();
        for(int i = 0; i < temp_depth; i++)
        {
            caseCalculator(i);
        }
    }
    static String util_sum(String string_input, int int_input) {
        String result = "";
        for(int i = 0; i < int_input; i++)
        {
            result += string_input;
        }
        return result;
    }

    static String resulter(String input_string)
    {
        int index;
        while((index = input_string.indexOf(")(")) != -1)
        {
            input_string = input_string.substring(0,index) + input_string.substring(index+2);
        }
        return input_string;
    }
    static void caseCalculator(int caseNomer) {
        String string = scanner.next();
        String result = "";
        int depth = 0;
        for(int i = 0; i < string.length(); i++) {
            String add;
            if(string.charAt(i) == '(')
                depth++;
            if(string.charAt(i) == ')')
                depth--;
            add = "" + string.charAt(i);
            if(Character.isDigit(string.charAt(i))) {
                int digit = string.charAt(i) - '0';
                int diff = digit - depth;
                add = util_sum("(",diff)+string.charAt(i)+util_sum(")",diff);
            }
            result += add;
        }
        System.out.println("Case #" + (caseNomer + 1) + ": " + resulter(result));
    }
}