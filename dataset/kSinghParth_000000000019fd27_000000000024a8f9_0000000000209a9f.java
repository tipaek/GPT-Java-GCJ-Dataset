import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int k=1;k<=t;k++) {
            StringBuilder st = new StringBuilder(sc.next());
            StringBuilder sp = process(st,0);
            System.out.println("Case #"+k+": "+sp);
            //process(r,b,c);
        }
    }
    static StringBuilder process(StringBuilder st, int off){
        int min = 11;
        for(int i=0;i<st.length();i++){
            min=Math.min(min, st.charAt(i)-'0');
        }
        StringBuilder ans = new StringBuilder();
        int prev=0;
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)-'0'==min){
                if(prev != i){
                    ans = ans.append(process(new StringBuilder(st.substring(prev,i)),min));
                }

                ans.append(min);
                prev = i+1;
            }
        }
        if(prev!=st.length()){
            ans = ans.append(process(new StringBuilder(st.substring(prev, st.length())),min));
        }
        for(int i=0;i<min-off;i++){
            ans = new StringBuilder("(").append(ans).append(")");
        }
        return ans;
    }
}
