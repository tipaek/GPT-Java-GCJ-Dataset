import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
            int t=Integer.parseInt(br.readLine());
            for(int p=1;p<=t;p++){
                String s=br.readLine();
                char[] ar=s.toCharArray();
                StringBuilder sb=new StringBuilder("");
                for(int i=0;i<ar.length;i++){
                    for(int j=0;j<ar[i]-'0';j++) sb.append("(");
                    sb.append(ar[i]);
                    for(int j=0;j<ar[i]-'0';j++) sb.append(")");
                }
                
                
                Stack<Character> st=new Stack<>();
                int n=sb.length();
                st.push(sb.charAt(n-1));
                for(int i=n-2;i>=0;i--){
                    if(sb.charAt(i)==')' && st.peek()=='(') st.pop();
                    else st.push(sb.charAt(i));
                }
                
                StringBuilder ans=new StringBuilder("");
                while(st.size()>0){
                    ans.append(st.pop());
                }
                bw.write("Case #"+p+": "+ans+"\n");
            }
            bw.flush();
        }
        catch(Exception e){System.out.println(e);}
    }
}