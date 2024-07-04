
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Solution p = new Solution();

        int numTest = Integer.valueOf(line);
        for (int i = 0; i < numTest; i++) {
            String each = br.readLine();
//            System.out.println(each);
            p.parenthesis(each, i+1);
        }

    }

    private void parenthesis(String input, int num) {
        String output = "Case #" + num + ": ";
        int count = 0;
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int value = charArray[i] - '0';
//            System.out.println(value);
            if (value - count > 0) {
                for (int j = 0; j < value - count; j++) {
                    output += "(";
                }
                output += value;
            }
            else if (value - count == 0) {
                output += value;
            }
            else {
                for (int j = 0; j < count - value; j++) {
                    output += ")";
                }
                output += value;
            }
            count = value;
        }
        if (count > 0) {
            for (int j = 0; j < count; j++) {
                output += ")";
            }
        }
        System.out.println(output);
    }

}
