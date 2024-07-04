import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(f.readLine());
        int tt = t;
        while(tt-- > 0){
            String str = f.readLine();
            StringBuilder outstr = new StringBuilder();
            int paren = 0;
            for(int i = 0; i < str.length(); i++){
                int curr = (int)str.charAt(i)-(int)'0';
                if(curr > paren){
                    for(int j = 0; j < curr-paren; j++){
                        outstr.append('(');
                    }
                    paren = curr;
                }else if(curr < paren){
                    for(int j = 0; j < paren-curr; j++){
                        outstr.append(')');
                    }
                    paren = curr;
                }
                outstr.append(str.charAt(i));
            }
            while(paren-- > 0) outstr.append(')');
            StringBuilder ans = new StringBuilder("Case #");
            ans.append(t-tt);
            ans.append(": ");
            ans.append(outstr.toString());
            out.println(ans.toString());


        }
        out.close();
    }
}
