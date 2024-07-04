import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =0; i<t; i++) {
            String S = sc.next();
            System.out.print("Case #"+(i+1)+": ");
            nestingDepth(S);
        }
    }

    public static void nestingDepth (String S) {
        StringBuilder sb = new StringBuilder();
        int current = (int)S.charAt(0)-'0';
        int prev = current;
        addOpenParenthesis(sb, current);
        sb.append(current);
        for(int i = 1; i<S.length(); i++) {
            current = (int)S.charAt(i)-'0';
            if(current>prev){
                addOpenParenthesis(sb,current-prev);
            }
            if(current<prev) {
                addClosedParenthesis(sb, prev-current);
            }
            sb.append(current);
            prev = current;
        }
        addClosedParenthesis(sb, current);
        System.out.println(sb.toString());
    }

    public static void addOpenParenthesis(StringBuilder sb, int n) {
        for(int i = 0; i<n; i++) sb.append('(');
    }

    public static void addClosedParenthesis(StringBuilder sb, int n) {
        for(int i = 0; i<n; i++) sb.append(')');
    }



}
