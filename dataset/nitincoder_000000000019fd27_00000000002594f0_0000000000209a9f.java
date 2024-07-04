

import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution obj = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for( int t=1; t<=test;t++) {
            char[] st = br.readLine().toCharArray();
            StringBuilder ans = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for( int i=0; i<st.length;i++) {
                int val = st[i]-'0';

                int crntStackVal = 0;
                if( !stack.isEmpty() ) {
                    crntStackVal = stack.pop();
                }

                if(crntStackVal < val) {
                    int openingBracket = val-crntStackVal;
                    while(openingBracket-->0) {
                        ans.append("(");
                    }

                } else if( crntStackVal > val){
                    int closingBracket = crntStackVal-val;
                    while(closingBracket-->0) {
                        ans.append(")");
                    }

                }
                stack.push(val) ;
                ans.append(st[i]);
            }
            if(!stack.isEmpty()) {
                int val =stack.pop();
                while(val-->0) {
                    ans.append(')');
                }
            }
            System.out.println("Case #"+t+": "+ans.toString());
        }
    }
}
