
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int k1=sc.nextInt();
		int flag=0;
	for(int t=1;t<=k1;t++)
	{
	    int n=sc.nextInt();
	    int k=sc.nextInt();
	    int flag2=0;
	    int flag3=0;
	    int flag4=0;
	    int flag5=0;
	    if(n==2)
	    {
	        if(k==2||k==4)
	        {
	            flag2=1;
	        }
	    }
	    else if(n==3)
	    {
	        if(k==3||k==6||k==9)
	        {
	            flag3=1;
	        }
	    }
	    else if(n==4)
	    {
	        if(k==4||k==6||k==8||k==10||k==12||k==14||k==16)
	        {
	            flag4=1;
	        }
	    }
	    else{
	        if(k==5||k==7||k==8||k==9||k==10||k==11||k==13||k==14||k==15||k==16||k==17||k==18||k==19||k==20||k==21||k==22||k==23||k==25)
	        {
	            flag5=1;
	        }
	    }
	    if(flag2==1||flag3==1||flag4==1||flag5==1)
	    {
	        System.out.println("Case #"+t+": "+"POSSIBLE");
	    }
	    else{
	        System.out.println("Case #"+t+": "+"IMPOSSIBLE");
	    }
	
	    
	}
	    
	}
}