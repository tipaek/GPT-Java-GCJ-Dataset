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
	        int D=in.nextInt();
	        long[] arr=new long[N];
	        for(int i=0;i<N;i++)arr[i]=in.nextLong();
	        Arrays.sort(arr);
	        int f=-1;
	        int ans=0;
	        for(int i=0;i<N-D-1;i++)
	        {
	            long a=arr[i],c=1;
	            for(int j=i;j<i+D;j++,c++)
	            {
	                if(arr[i]!=a){f=0;break;}
	            }
	            if(c>D){f=1;break;}
	        }
	        if(f!=1)
	        {
	            if(D==2)ans=1;
	            else if(D==3 && N==1)ans=2;
	            else 
	            {
	                 f=0;
	                for(int i=0;i<N-1;i++)
	                {
	                    long a=arr[i];
	                    for(int j=i+1;j<N;j++)
	                    {
	                        if(arr[j]%a==0){ans=1;f=1;break;}
	                    }
	                    if(f==1)break;
	                }
	                if(f==0)ans=2;
	            }
	        }
	        System.out.println("Case #"+tc+": "+ans);
	    }
	    
	}
}
