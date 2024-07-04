
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {

            String str = s.next();
            String ans = check(str);
            System.out.println("case #" + i + ": " + ans);

        }
    }

    private static String check(String str) {
        String s = "";
        if(str.length()==0){
            return null;
        }
        Stack<Character> stack = new Stack<>();
        int val = Integer.parseInt(String.valueOf(str.charAt(0)));
        for (int j = 0; j < val; j++) {
            stack.push('(');
            s += '(';
        }
        s += val;
        for (int i = 1; i < str.length(); i++) {
            int v = Math.abs(Integer.parseInt(String.valueOf(str.charAt(i))) - Integer.parseInt(String.valueOf(str.charAt(i - 1))));
            int c = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (stack.size() != 0) {
                for (int j = 0; j < v; j++) {
                    stack.pop();
                    s += ')';
                }
            }

            if (stack.size() == 0) {
                for (int j = 0; j < c; j++) {
                    stack.push('(');
                    s += '(';
                }
            }
            s += c;
        }
        while (stack.size()!=0){
            stack.pop();
            s+=')';
        }
        return s;
    }
}
