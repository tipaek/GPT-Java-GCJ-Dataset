import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb =new StringBuilder();
        int t = in.nextInt();
        for(int i=1;i<=t;i++){
            String res = "";
            Stack<Character> o = new Stack();
            String s = in.next();
            for(int j=0;j<s.length();j++){
                while(o.size() < Character.getNumericValue(s.charAt(j))) {
                    o.push('(');
                    res+="(";
                }
                while(o.size() > Character.getNumericValue(s.charAt(j))) {
                    o.pop();
                    res+=")";
                }
                res+=s.charAt(j);
            }
            while(!o.empty()) {
                res+=")";
                o.pop();
            }
            sb.append("Case #").append(i).append(": ").append(res).append("\n");
        }
        System.out.println(sb);
    }     
}