import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<T;i++){
            String input = scanner.nextLine();
            int[] arr = new int[input.length()];
            Stack<Character> stack = new Stack<>();
            for(int j=0;j<input.length();j++){
                arr[j]=Character.getNumericValue(input.charAt(j));
            }

            for(int j=0;j<input.length();j++){
                int len = 0;
                if(!stack.isEmpty()){
                    while(stack.peek()==')'&&len<arr[j]){
                        stack.pop();
                        len++;
                    }
                }
                int max = arr[j];
                for(int n=0;n<max-len;n++){
                    stack.push('(');
                }
                stack.push((char)(arr[j]+'0'));
                for(int n=0;n<max;n++){
                    stack.push(')');
                }
            }
            System.out.print("Case #"+i+": ");
            for(int j=0;j<stack.size();j++){
                System.out.print(stack.elementAt(j));
            }
            System.out.println();
        }
    }
}
