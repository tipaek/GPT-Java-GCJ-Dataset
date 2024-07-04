import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int l= 1; l <= t; ++l) {
      
	        String str=in.next();
	        
	        Stack<Character>st=new Stack<>();
	        int inx=0;
	        
	        StringBuffer sb=new StringBuffer();
	        while(inx<str.length()){
	            
	            int ch=str.charAt(inx)-'0';
	            int sz=st.size();
	            int rem=ch-sz;
	            if(rem>0){
	                for(int i=0;i<rem;i++){
	                    st.push('(');
	                    sb.append('(');
	                }
	            }else if(rem<0){
	                for(int i=0;i<Math.abs(rem);i++){
	                    st.pop();
	                    sb.append(')');
	                }
	            }
	            
	            sb.append(str.charAt(inx));
	            inx++;
	        }
	        
	        while(!st.isEmpty()){
	            st.pop();
	            
	            sb.append(')');
	        }
	        
	        System.out.println("Case #"+l+": "+sb);
	      
	    
    }
  }
}