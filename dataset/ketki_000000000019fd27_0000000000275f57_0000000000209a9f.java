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
	                st=st+"o";
	            }
	            st=st+n;
	            for(int j=0;j<n;j++)
	            {
	                st=st+"c";
	            }
	        }
	        while(st.contains("co"))
	        {
	            st=st.replaceAll("co","");
	            
	        }
	        st=st.replaceAll("o","(");
	        st=st.replaceAll("c",")");
	        System.out.println("Case #"+": "+st);
	    }

	}
}