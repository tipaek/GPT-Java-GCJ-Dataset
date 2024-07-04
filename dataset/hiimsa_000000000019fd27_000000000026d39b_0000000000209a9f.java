import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void AddParenthesis(String str, int t)
    {
        Stack<Character> stack  = new Stack<Character>();
        StringBuilder output = new StringBuilder();
        int st = (int)str.charAt(0) - 48;
        while(st>0)
        {
            output.append('(');
            stack.push(')');
            st--;
        }
        output.append(str.charAt(0));
        int prev = 0, curr =0;
        for(int i =1 ; i < str.length(); i++)
        {
            prev = (int)str.charAt(i-1) - 48;
            curr = (int)str.charAt(i) - 48;
            int diff = curr - prev;
            while(diff>0)
            {
                output.append('(');
                stack.push(')');
                diff--;
            }
            while(diff<0)
            {
                output.append(')');
                stack.pop();
                diff++;
            }
            output.append(str.charAt(i));
        }
        while(!stack.isEmpty())
        {
            output.append(')');
            stack.pop();
        }
        System.out.println("Case #" + t + ": " +output);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int NoOftest = in.nextInt();
        for (int t = 1; t <= NoOftest; ++t) {
            String str = in.next();
            AddParenthesis(str,t);
        }
    }
}
