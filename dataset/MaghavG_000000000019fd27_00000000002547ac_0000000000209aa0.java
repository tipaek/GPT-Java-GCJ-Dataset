import java.io.*;
import java.util.*;
public class Solution{
    
    private static int Trace(int[][]helper)
    {
        int ans=0;
        
        for(int i=0,j=0;i<helper.length && j<helper.length;i++,j++)
        {
            ans=ans+helper[i][j];
        }
        return ans;
    }
    private static void Helper(int[][]ans,int[][]helper,int count, 
    int[] rows, int[] cols,int check)
    {
        if(count==helper.length*helper.length)
        {
            if(Trace(helper)==check)
            {
                flag=1;
                for(int i=0;i<helper.length;i++)
                {
                    for(int j=0;j<helper.length;j++)
                    {
                        ans[i][j]=helper[i][j];
                    }
                }
                return;
            }
        }
        
        int i=count/helper.length;
        int j=count%helper.length;
        
        for(int k=1;k<=helper.length;k++)
        {
            if( ((rows[i]&(1<<k))!=(1<<k)) && ((cols[j]&(1<<k))!=(1<<k)) )
            {
                helper[i][j]=k;
                
                rows[i]=rows[i]^(1<<k);
                cols[j]=cols[j]^(1<<k);
                
                Helper(ans,helper,count+1,rows,cols,check);
                
                rows[i]=rows[i]^(1<<k);
                cols[j]=cols[j]^(1<<k);
                
                helper[i][j]=0;
                
            }
        }
    }
    static int flag;
	public static void main(String[]args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		
		for(int t=0;t<tc;t++)
		{
    		int n=sc.nextInt();
    		int k=sc.nextInt();
    		
    		int[][]ans=new int[n][n];
    		int[][]helper=new int[n][n];
    		
    		String temp="";
    		flag=0;
    		Helper(ans,helper,0,new int[n+1],new int[n+1],k);
    		    
    		if(flag==1)
    		{
    		    System.out.println("Case #"+(t+1)+":"+" POSSIBLE");
    		    
    		    for(int i=0;i<helper.length;i++)
    		    {
    		        for(int j=0;j<helper.length;j++)
    		        {
    		            System.out.print(ans[i][j]+" ");
    		        }
    		        System.out.println();
    		    }
    		    
    		}
    		else
    		{
    		      System.out.println("Case #"+(t+1)+":"+" IMPOSSIBLE");

    		}
    		
    	}
    }
}