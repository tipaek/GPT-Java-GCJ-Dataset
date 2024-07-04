import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            StringBuilder sb=new StringBuilder("");
            String s=sc.next();
            Stack<Character> st=new Stack<>();
            int i=0;
            int n=s.length();
            while(i<n){
                int x=s.charAt(i)-'0';
                int l=st.size();
                int r=x-l;
                if(r>0){
                    for(int j=0;j<r;j++){
                        st.push('(');
                        sb.append('(');
                    }
                }
                else if(r<0){
                    for(int j=0;j<Math.abs(r);j++){
                        st.pop();
                        sb.append(')');
                    }
                }
                sb.append(s.charAt(i));
                i++;
            }
           while(st.size()>0){
               st.pop();
               sb.append(')');
           } 
           System.out.println("Case #"+t+": "+sb);
        }
    }
}