import java.util.*;
import java.io.*;
class Nesting_Depth
{
	public static String check(String s)
	{
		String c;
		String a=s.substring(s.length()-1,s.length());
		String converted="";
		boolean open=false;
		for (int i=0;i<s.length();i++)
		{
           c=s.substring(i,i+1);
		   if (c.compareTo("1")==0)
		   {
		       if (open==false)
		       {
                   converted=converted+"("+c;
                   open=true;
		       }
			   else
                   converted=converted+c;
		   }
		   else if (c.compareTo(".")==0)
		   {
			   if (open==false)
                   converted=converted+c;
			   else
			   {
                   converted=converted+")"+c;
				   open=false;
			   }
		   }
		   else
		   {
			   if (open==true)
			   {
				   converted=converted+")"+c;
				   open=false;
				   
			   }
			   else
			       converted=converted+c;
		   }
		}
        if (a.compareTo("1")==0)
		    converted=converted+")";
		return converted;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=input.nextInt();
		if ((T<1)&&(T>100))
		  return;
		for (int i=0;i<T;i++)
		{
			String s=input.next();
			if ((s.length()<1)&&(s.length()>100))
			   return ;
			System.out.println("Case #"+(i+1)+": "+check(s));
		}
		return ;
	}
}