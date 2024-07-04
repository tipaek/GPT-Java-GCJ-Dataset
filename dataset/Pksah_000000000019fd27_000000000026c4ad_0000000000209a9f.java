import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int k=1;k<=t;k++)
		{
		    String s=sc.next();
		    StringBuffer str=new StringBuffer();
		    
		    int r=Character.getNumericValue(s.charAt(0));
		   int f=r;
		   int b=r;
		    for(int j=0;j<r;j++)
		        {
		            str.append('(');
		            
		        }
		        str.append(r);
		       
		    for(int i=1;i<s.length();i++)
		    {  int w=Character.getNumericValue(s.charAt(i));
		      if(w==f)
		      {
		        str.append(w);
		    }
		    else if(w>f){
		       int sub=w-f;
		       for(int j=0;j<sub;j++)
		       {
		           str.append('(');
		           
		           b++;
		       }
		       str.append(w);
		    }
		    else{
		        int dif=f-w;
		         for(int j=0;j<dif;j++)
		       {
		           str.append(')');
		           b--;
		       }
		        str.append(w);
		        
		    }
		   f= Character.getNumericValue(s.charAt(i));
		}
		while(b-->0)
		{
		    str.append(')');
		}
		         
		 System.out.println("Case #"+k+": "+str);
		}
	}
}