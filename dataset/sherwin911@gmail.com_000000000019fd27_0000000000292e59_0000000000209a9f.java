import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private static char OPEN = '(';
    private static char CLOSE = ')';
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        List<String> inputs = new ArrayList<String>();
        for (int i = 0; i < testcases; i++) {
            String input = sc.next();
            inputs.add(input);
        }
        sc.close();
        int count = 1;
        for (String input : inputs) {
            System.out.println("Case #" + count++ + ": " + solve(input));
        }
    }
    public static String solve(String input){
        Stack<Character> stack = new Stack<Character>();
        int numOfParenthesisPair = 0;
        for(int i = 0; i< input.length() ; i++){
            Stack<Character> temp = new Stack<Character>();
            char ch = input.charAt(i);
            int value = Integer.parseInt(String.valueOf(ch));
            //If the number is same we add the character with the previous character
//            if(numOfParenthesisPair == value){
//                //Pop all the closing braces
//                for(int j = 0 ; j < value; j++){
//                    temp.push(stack.pop());
//                }
//                //Push the same value
//                stack.push(ch);
//                //Push the closing braces that were popped before
//                for(int j = 0 ; j < value; j++){
//                    stack.push(temp.pop());
//                }
//                numOfParenthesisPair = value;
//            }
            if(numOfParenthesisPair >= value){
                //Pop (numOfParenthesisPair - value) the closing braces
                for(int j = 0 ; j < value; j++){
                    temp.push(stack.pop());
                }
                //Push the same value
                stack.push(ch);
                //Push the closing braces that were popped before
                for(int j = 0 ; j < value; j++){
                    stack.push(temp.pop());
                }
                numOfParenthesisPair = value;
            }
            if(numOfParenthesisPair < value){

                int bracesToAdd = value - numOfParenthesisPair;
                for(int j = 0 ; j < numOfParenthesisPair; j++){
                    temp.push(stack.pop());
                }
                //Pushing Opening braces
                for(int j = 0 ; j < bracesToAdd; j++){
                    stack.push(OPEN);
                }
                stack.push(ch);
                for(int j = 0 ; j < bracesToAdd; j++){
                    stack.push(CLOSE);
                }
                for(int j = 0 ; j < numOfParenthesisPair; j++){
                    stack.push(temp.pop());
                }
                numOfParenthesisPair = value;
            }

        }
        //System.out.print(stack.toString());
        char[] output = new char[stack.size()];
        for(int i = stack.size() - 1 ; i  >=0 ; i--){
            output[i] = stack.pop();
        }
        return new String(output);
    }
}
