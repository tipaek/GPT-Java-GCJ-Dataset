import java.util.*;
class Solution
{
   public static void main(String[]args)
   {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int c=0;
    while(t-->0)
    {
        c++;
        int n=sc.nextInt();
        String p[]=new String[n];
        for(int i=0;i<n;i++)
        {
            p[i]=sc.next();
        }
        String y="";
        for(int i=0;i<n;i++)
        {
            String y1="";
            for(int j=0;j<p[i].length();j++)
            {
                if(p[i].charAt(j)!='*')
                {
                    y1=y1+String.valueOf(p[i].charAt(j));
                }
            }
            if(y.length()<y1.length())
            {
                y=y1;
            }
			
        }
		int k=0;
		int flag=0;
		for(int i=0;i<n && flag==0;i++)
		{
		   k=0;
			for(int j=0;j<p[i].length() && flag==0;j++)
			{
			      if(p[i].charAt(j)=='*')
				  { 
				  	k=k+y.length()-p[i].length();
				  }
				  else if(p[i].charAt(j)!=y.charAt(k))
				  {
				  y="*";
				  	flag=1;
				  }
				  k++;
		     }
			 }
				System.out.println("Case #"+c+": "+y);
		
		}
    }
}