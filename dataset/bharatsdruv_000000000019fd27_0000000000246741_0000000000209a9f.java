import java.util.*;
 class Solution
{
       
    public static String add(int choice,int diff)
    {
        String res="";
        if(choice==1)
        {
            for(int i=0;i<diff;i++)res+="(";
        }
        else
        {
            diff*=-1;
            for(int i=0;i<diff;i++)res+=")";
        }
        return res;
    }
	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        String S=in.next();
	        String result="";
	        int diff=0,prev=0;
	        int N=S.length();
	        for(int i=0;i<N;i++)
	        {
	            int a=Integer.parseInt(S.charAt(i)+"");
	            diff=a-prev;
	            if(diff>0)result+=add(1,diff);
	            else if(diff<0)result+=add(0,diff);
	            result+=a+"";
	            prev=a;
	        }
	             if(prev>0){for(int i=0;i<prev;i++)result+=")";}
	        
	        System.out.println(result);
	    }
	    
	}
}
