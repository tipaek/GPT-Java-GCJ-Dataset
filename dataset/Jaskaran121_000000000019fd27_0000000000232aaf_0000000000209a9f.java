import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static String calculate(String string){
        String result = "";
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<string.length();i++){
            int num = Character.getNumericValue(string.charAt(i));
            int count = num;
            if(num == 0)
                stack.push(num + "");
            else {
                int popedCount = 0;
                while (count > 0 && !stack.isEmpty()) {
                    if (stack.peek() == ")") {
                        //System.out.println("runn");
                        stack.pop();
                        popedCount++;
                    }
                    else break;
                    count--;
                }
                count = num-popedCount;
                while (count > 0) {
                    stack.push("(");
                    count--;
                }
                stack.push(num + "");
                count=num;
                while (count > 0) {
                    stack.push(")");
                    count--;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String value : stack) {
            builder.append(value);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        String[] result = new String[t];
        for (int i = 0; i <t; i++) {
            String string = in.nextLine();
            result[i] = calculate(string);
        }

        for(int i=1;i<=t;i++){
            System.out.print("Case #" + i + ": " + result[i-1]);
            if(i!=t)
                System.out.println("");
        }
    }
}
