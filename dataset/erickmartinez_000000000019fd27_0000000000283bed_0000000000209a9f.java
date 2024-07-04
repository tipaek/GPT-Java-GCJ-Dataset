import java.util.Scanner;
import java.util.Stack;

public class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String matrix[] = new String[t];

        for(int i = 0 ; i< t ; i++){
            matrix[i] = scanner.next();
        }
        for(int i = 0; i < t ; i++){
            validateString(matrix[i], i);
        }
    }

    public static void validateString(String input, int testCase){
        final Stack<String> stack = new Stack<>();
        String currentN = String.valueOf(input.charAt(0));
        insertNParenthesis("(" , Integer.valueOf(currentN), stack);
        stack.push(currentN);

        for(int i = 1 ; i < input.length() ; i++){
            //
            int comparison = input.substring(i, i+1).compareTo(currentN);
            if( comparison == 0) {
                stack.push(input.substring(i, i+1));
            }else if(comparison > 0) {
                insertNParenthesis("(" , Integer.valueOf(input.substring(i,i+1)) - Integer.valueOf(currentN), stack);
                currentN = input.substring(i, i+1);
                stack.push(currentN);
            }else {
                insertNParenthesis(")" , Integer.valueOf(input.substring(i,i+1)) - Integer.valueOf(currentN), stack);
                currentN = input.substring(i, i+1);
                stack.push(currentN);
            }
        }
        insertNParenthesis(")" , Integer.valueOf(currentN), stack);

        String output = "";
        for(int i = 0 ; !stack.empty() ; i++){
            output = stack.pop() + output;
        }
        System.out.println("Case #" +(testCase + 1) + ": "+output);
    }

    private static void insertNParenthesis(String parenthesis, int n,final Stack<String> stack){
        for(int i = 0; i < Math.abs(n) ; i++){
            stack.push(parenthesis);
        }
    }
}