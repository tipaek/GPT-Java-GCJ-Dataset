import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;


public class Solution {
    public Solution() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String str = in.next();
            // 0((2)1), (((3))1(2)), ((((4)))), ((2))((2))(1)
            char[] chars = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            List<Character> retChar = new ArrayList<>();
            for(int j = 0; j < chars.length; j++) {
                int digit = Character.getNumericValue(chars[j]);
                if (stack.isEmpty()) {
                    for(int k = 0; k < digit; k++) {
                        stack.push('(');
                        retChar.add('(');
                    }
                } else {
                    if (digit == stack.size()) { retChar.add(chars[j]);continue;}
                    if (digit < stack.size()) {
                        int temp = stack.size() - digit;
                        while (temp > 0) {
                            stack.pop();
                            retChar.add(')');
                            temp--;
                        }
                    }
                    if (digit >  stack.size()) {
                        int temp = digit - stack.size();
                        while (temp > 0) {
                            stack.push('(');
                            retChar.add('(');
                            temp--;
                        }
                    }
                }
                retChar.add(chars[j]);
            }
            while (!stack.isEmpty()) {
                stack.pop();
                retChar.add(')');
            }
            // convert retChar to string
            String ret = retChar.stream().map(String::valueOf).collect(Collectors.joining());
            System.out.println("Case #" + i +": " + ret);
        }
    }
}