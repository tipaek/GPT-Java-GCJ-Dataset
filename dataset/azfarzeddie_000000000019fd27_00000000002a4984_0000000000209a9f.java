import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= T; i++) {
            String S = sc.nextLine();
            //System.out.println("calling T=" + i + " S is " + S);
            System.out.println(nestingDepth(i, S));
        }
    }

    private static String nestingDepth(int T, String S) {
        int len = S.length();
        Stack<String> stack = new Stack<>();
        //System.out.println("S[0] is " + S);
        int lastPushedNum = Integer.MIN_VALUE;
        for (int j = 0; j < Character.getNumericValue(S.charAt(0)); j++)
            stack.push("(");
        if (S.charAt(0) != '(' && S.charAt(0) != ')') {
            stack.push(String.valueOf(S.charAt(0)));
            lastPushedNum = Integer.parseInt(stack.peek());
        }
        for (int i = 1; i < len; i++) {
            //System.out.println("stack :: " + stack);
            int currNum = Character.getNumericValue(S.charAt(i));
            if (!stack.isEmpty() && stack.peek() != String.valueOf(currNum) && currNum > lastPushedNum) {
                //System.out.println("stack.peek() :: " + stack.peek());
                int currPeek = Integer.parseInt(stack.peek());
                for (int j = 0; j < currNum - currPeek; j++)
                    stack.push("(");
            }
            //System.out.println("stack2 :: " + stack);
            int currPeek = lastPushedNum;
            //System.out.println("currNum :: "+currNum+" currPeek ::"+currPeek);
            if (!stack.isEmpty() && stack.peek() != String.valueOf(currNum) && currNum < lastPushedNum && !stack.peek().equals(")"))
                for (int j = 0; j < currPeek - currNum; j++)
                    stack.push(")");
            //System.out.println("pushing into stack :: " + currNum);
            stack.push(String.valueOf(currNum));
            lastPushedNum = currNum;
            if (i == len - 1) {
                currPeek = Integer.parseInt(stack.peek());
                for (int j = 0; j < currPeek; j++)
                    stack.push(")");
            } else {
                int nextNum = Character.getNumericValue(S.charAt(i + 1));
                int lastNum = -1;
                if (nextNum < Integer.parseInt(stack.peek()))
                    for (int j = 0; j < lastPushedNum - nextNum; j++)
                        stack.push(")");
            }
        }
        if(S.length()==1)
            for (int j = 0; j < Character.getNumericValue(S.charAt(0)); j++)
                stack.push(")");
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        String res = "Case #"+T+": "+sb.toString();
        return res;
    }
}
