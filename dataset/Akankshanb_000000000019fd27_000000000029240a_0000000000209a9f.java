import java.util.*;
import java.io.*;
class Solution{
    public static String maxDepth(String S) {
        int n = S.length();
        int count_open = 0;
        Stack<String> st = new Stack<>();
        for(int i=0;i<S.length();i++){
            int val = S.charAt(i) - '0';
            if(st.isEmpty()){
                for(int k=0;k<val;k++){
                    st.push("(");
                    count_open++;
                }
                st.push(String.valueOf(val));
                for(int k=val;k>0;k--){
                    st.push(")");
                    count_open--;
                }
                continue;
            }
            while(!st.isEmpty() && st.peek()==")" && val>0){
                st.pop();
                count_open++;
                val--;
            }
            if(val>count_open){
                for(int k=0;k<val;k++){
                    st.push("(");
                    count_open++;
                }
            }
            st.push(String.valueOf(S.charAt(i) - '0'));
            while (count_open>0){
                st.push(")");
                count_open--;
            }
        }
        return Stringify(st);

    }
    public static String Stringify(Stack<String> st){
        StringBuilder sb = new StringBuilder();
        for(String s: st){
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String S = in.next();
            System.out.println("Case #" + i + ": " + maxDepth(S));
        }
    }
}