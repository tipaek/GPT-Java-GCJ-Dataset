import java.util.*;
class Solution
{
	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int N=in.nextInt();
	        String[] arr=new String[N];
	        int max_length=0,mL=0;
	        for(int i=0;i<N;i++)
	        {   
	            arr[i]=in.next();
    	        if(max_length<arr[i].length())
    	        {max_length=arr[i].length();mL=i;}
    	    }
    	    int f=1;
    	    for(int i=0;i<N;i++)
    	    {
    	        String s=arr[i].substring(1);
    	        if(!arr[mL].contains(s)){f=0;break;}
    	        
    	    }
    	    String res="*";
    	    if(f==1)
    	    {
    	        res=arr[mL].substring(1);
    	    }
    	    System.out.println("Case #"+tc+": "+res);
	    }
	    
	    
	}
}
