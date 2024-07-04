import java.lang.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc =new Scanner(System.in);
	    int t=sc.nextInt();
	    sc.nextLine();
	    for(int tt=1;tt<=t;tt++)
	    {
	        String s=sc.nextLine();
	        String st="";
	        for(int i=0;i<s.length();i++)
	        {
	            int n=Integer.parseInt(s.charAt(i)+"");
	            for(int j=0;j<n;j++)
	            {
	                st=st+"a";
	            }
	            st=st+n;
	            for(int j=0;j<n;j++)
	            {
	                st=st+"b";
	            }
	        }
	        while(st.contains("ba"))
	        {
	            st=st.replaceAll("ba","");
	            
	        }
	        st=st.replaceAll("a","(");
	        st=st.replaceAll("b",")");
	        System.out.println("Case #"+tt+": "+st);
	    }
	}
}
