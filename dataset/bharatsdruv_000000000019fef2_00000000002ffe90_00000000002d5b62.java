import java.util.*;
 class Solution
{
    public static String exchangeWE(String input)
    {
        String res="";
        for(int i=0;i<input.length();i++)
        {
            char c=input.charAt(i);
            if(c=='W' || c=='E')
                res+=c=='W'?'E':'W';
            else res+=c;        
        }
        return res;
    }
    
    
    public static String exchangeNS(String input)
    {
        String res="";
        for(int i=0;i<input.length();i++)
        {
            char c=input.charAt(i);
            if(c=='N' || c=='S')
                res+=c=='N'?'S':'N';
            else res+=c;    
        }
        return res;
    }
    
	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int X=in.nextInt();
	        int Y=in.nextInt();
	        int x=X,y=Y;
	        int sum=Math.abs(X)+Math.abs(Y);
	        String res="";
	        if((sum)%2!=0)
	        {
	            X=X>0?X:-1*X;
	            Y=Y>0?Y:-1*Y;
	            
	           if(X==1 && Y==0)res="E";
	           else if(X==3 && Y==0)res="EE";
	           else if(X==0 && Y==1)res="N";
	           else if(X==2 && Y==1)res="NE";
	           else if(X==4 && Y==1)res="SNE";
	           else if(X==1 && Y==2)res="EN";
	           else if(X==3 && Y==2)res="WNE";
	           else if(X==0 && Y==3)res="NN";
	           else if(X==2 && Y==3)res="SEN";
	           else if(X==4 && Y==3)res="NNE";
	           else if(X==1 && Y==4)res="WEN";
	           else if(X==3 && Y==4)res="EEN";
	           if(x>0 && y<0) // N S
	                res=exchangeNS(res);
	           else if(x<0 && y>0)// W E
	                res=exchangeWE(res);
               else if(x<0 && y<0)// W E , N S 	            
	                {
	                    res=exchangeWE(res);
	                    res=exchangeNS(res);
	                }
	            System.out.println("Case #"+tc+": "+res);
	        }
	        else
	        System.out.println("Case #"+tc+": IMPOSSIBLE");
	    }
	    
	}
}
