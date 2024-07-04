import java.util.*;
import java.io.*;

public class Solution {

    public static String nestingdepth(String s){
        String res = "";
        Stack<Character> st = new Stack<>();
        int i = 0;

        while(i < s.length()){
            String temp = String.valueOf(s.charAt(i));
            while(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                temp += String.valueOf(s.charAt(i));
                i++;
            }
            int c = s.charAt(i) - 48;
            if(st.isEmpty()){
                int cnt = 0;
                while(cnt < c){
                    st.push('(');
                    res+="(" ;
                    cnt++;
                }
                res+= temp;
                i++;
            }
            else{
                int cnt = c - st.size();
                while(cnt >= 0 && cnt < c){
                    st.push('(');
                    res+="(" ;
                    cnt++;
                }
                while(st.size() != c){
                    res += ")";
                    st.pop();
                }
                res += temp;
                i++;
            }

        }

        while(!st.isEmpty()){
            res += ")";
            st.pop();
        }

        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            String res = nestingdepth(s);
            System.out.println("Case #" + i + ": "+res);
        }

    }
}