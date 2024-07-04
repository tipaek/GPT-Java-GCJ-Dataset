import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test=sc.nextInt();
		for(int k=1;k<=test;k++){
		   String s=sc.next();
		   String st="";
            for(int i=0;i<s.length();i++){
                if((s.charAt(i)=='1' && st.equals("")) ||(s.charAt(i)=='1' && s.charAt(i-1)=='0')  )
                    st= st+"("+s.charAt(i);
                    
                 else if(s.charAt(i)=='0' &&!st.equals("") && s.charAt(i-1)=='1')
                    st=st+")"+s.charAt(i);
                else{
                    st=st+s.charAt(i);
                }
            }
		   if(s.charAt(s.length()-1)=='1')
		    st=st+")";
		   System.out.println("Case #"+k+": "+st);
		}
	
	}

}
