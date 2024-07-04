import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int testCaseNum = 0;
        while(T != 0) {
            T--;
            testCaseNum++;
            String inputStr = reader.readLine();
            int[] ints = new int[inputStr.length()];
            for(int i = 0; i < ints.length; i++) {
                ints[i] = inputStr.charAt(i) - '0';
            }
            StringBuilder sb = new StringBuilder();
            Stack<Character>  stacks = new Stack<>();
            for(int i = 0; i < inputStr.length(); i++) {
                int count = inputStr.charAt(i) - '0';
                for(int j = 0; j < count; j++) {
                    addCharToStack(stacks, '(');
                }
                addCharToStack(stacks, inputStr.charAt(i));
                for(int j = 0; j < count; j++) {
                    addCharToStack(stacks, ')');
                }
            }
            for(int i = 0; i < stacks.size(); i++) {
                sb.append(stacks.get(i));
            }
            System.out.println("Case #" + testCaseNum + ": " + sb.toString());
        }
    }

    public static void addCharToStack(Stack<Character> stack, Character c) {
        if(stack.empty()) {
            stack.add(c);
            return;
        }
        if(c == '(') {
            if(stack.lastElement() == ')') {
                stack.pop();
                return;
            }
            if(stack.lastElement() == '(') {
                stack.add(c);
                return;
            }
            stack.add(c);
            return;
        }
        if(c == ')') {
            stack.add(c);
            return;
        }
        stack.add(c);
        return;
    }
}
