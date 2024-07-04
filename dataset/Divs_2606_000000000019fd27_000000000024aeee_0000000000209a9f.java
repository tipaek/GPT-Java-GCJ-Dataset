import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t,cno=1;
	    t=sc.nextInt();
	    for(int j=0;j<t;j++)
	    {
	        String s1=new String();
	        s1=sc.next();
	        int l;
	        l=s1.length();
	        //System.out.println(l);
	        char[] ch=new char[l];
	        for(int i=0;i<l;i++)
	        {
	            ch[i]=s1.charAt(i);
	        }
	        String paro= "";
	        int left=0,right=0;
	        left=ch[0]-48;
	        right=ch[l-1]-48;
	        for(int i=0;i<left;i++)
	        {
	            paro=paro+"(";
	        }
	        paro=paro+ch[0];
	        int m1=0,m2=0;
	        for(int i=1;i<l;i++)
	        {
	            if(ch[i]>ch[i-1])
	            {
	                m1=ch[i]-ch[i-1];
	                for(int k=0;k<m1;k++)
	                {
	                    paro=paro+"(";
	                }
	            }
	            else if(ch[i]<ch[i-1])
	            {
	                m2=ch[i-1]-ch[i];
	                for(int k=0;k<m2;k++)
	                {
	                   paro=paro+")"; 
	                }
	            }
	            paro=paro+ch[i];
	        }
	        for(int i=0;i<right;i++)
	            paro=paro+")";
	        System.out.println("Case #"+cno+": "+paro);
	        cno++;
	    }
	}
}