

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static char rev(char c){
        if(c=='(')
            return ')';
        return '(';
    }
    public static String balance(String s){
        Stack<Character> stack = new Stack<>();
        char r;
        String st="";
        char p;
        for(int i=0;i<s.length();i++) {

            if (s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == ')')
                    p = stack.pop();

            st=st.concat(String.valueOf(s.charAt(i)));
        }

            if(stack.isEmpty()==false)
                st=st.concat(String.valueOf(rev(stack.pop())));

        return st;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());

        for(int q = 0;q<t;q++){
            String str = sc.next();

            String s="";
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                int n = Integer.parseInt(String.valueOf(c));
                if(n>0){
                    for(int j=0;j<n;j++)
                        s=s.concat(String.valueOf('('));
                    s=s.concat(String.valueOf(n));
                    for(int j=i+1;j<str.length();j++){
                        if(str.charAt(j)!=str.charAt(i)) {
                            for (int k = 0; k < n; k++)
                                s = s.concat(String.valueOf(')'));
                            break;
                        }
                        else
                            s=s.concat(String.valueOf(str.charAt(i++)));
                    }
                }
                else
                    s=s.concat(String.valueOf(n));

            }
            s=""+balance(s);
            System.out.println("Case #"+(q+1)+": "+s);
        }
    }
}
