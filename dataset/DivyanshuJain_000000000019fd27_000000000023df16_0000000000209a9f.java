import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		String s=sc.nextLine();
		String s1;
		for(int i=0;i<T;i++)
		{
		    s1="";
		   s1=sc.nextLine();
		   String s2="";
		  // String s3="";
		   char c='0';
		   int l=s1.length();
		   for(int j=0;j<l;j++){
		       char ch=s1.charAt(j);
		       if(c==ch)
		       s2=s2+Character.toString(c);
		       else if(ch>c){
		           
		           s2=s2+String.join("", Collections.nCopies((ch-c), "("))+Character.toString(ch);
		           c=ch;
		       }
		       else{
		           s2=s2+String.join("", Collections.nCopies((c-ch), ")"))+Character.toString(ch);
		           c=ch;
		       }
		   }
		   if(c>'0')
		   s2=s2+String.join("", Collections.nCopies((c-'0'), ")"));
		   System.out.println("Case #" + (i+1) + ": " + s2);
		}
	}
}
