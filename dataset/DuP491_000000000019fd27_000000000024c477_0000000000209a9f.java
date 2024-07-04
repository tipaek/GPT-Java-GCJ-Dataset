/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t;
		StringBuffer fb[]={new StringBuffer(""),new StringBuffer("("),new StringBuffer("(("),new StringBuffer("((("),new StringBuffer("(((("),new StringBuffer("((((("),new StringBuffer("(((((("),new StringBuffer("((((((("),new StringBuffer("(((((((("),new StringBuffer("(((((((((")};
		StringBuffer pb[]={new StringBuffer(""),new StringBuffer(")"),new StringBuffer("))"),new StringBuffer(")))"),new StringBuffer("))))"),new StringBuffer(")))))"),new StringBuffer("))))))"),new StringBuffer(")))))))"),new StringBuffer("))))))))"),new StringBuffer(")))))))))")};
		t=Integer.parseInt(br.readLine());
		int i,j;
		for(i=1;i<=t;i++)
		{   int pf=0,pp=0; 
		    String s=br.readLine();
		    StringBuffer st=new StringBuffer(s);
		    StringBuffer ans =new StringBuffer("");
		    		       
            char ch=s.charAt(0);
		     int a=Character.getNumericValue(ch);
		     
		     ans.append(fb[a]);
		     ans.append(a);
		     ans.append(pb[a]);
		     //System.out.println(fb[a]);
		     pf=a;
		     pp=a;
		     //ystem.out.println(ans);
		    for(j=1;j<s.length();j++)
		    {
		        ch=s.charAt(j);
		        a=Character.getNumericValue(ch);
		       
		        if(a>pf)
		        {StringBuffer temp=new StringBuffer("");
		        temp.append(fb[a-pf]);
		        temp.append(ch);
		        temp.append(pb[a-pf]);
		         ans.insert(pp+1,temp);
		         pf=a;
		         pp=pp+(a-pf);
		         //System.out.println("Message"+j);
		        }
		        else
		        {ans.insert(pp+(pf-a+1),ch);
		        pp=pp+(pf-a+1);
		        pf=a;}
		        //System.out.println(pp);
		      }
		    System.out.println(ans);
		    //ans="";
		}
	}
}