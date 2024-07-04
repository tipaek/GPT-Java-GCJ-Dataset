
import java.util.*;

class Solution
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try{
        int t,n;
        
        t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            n=sc.nextInt();
            int ele;
            int[][] row=new int[n+1][n+1];
            int[][] col=new int[n+1][n+1];
            int trace=0;
            for(int p=1;p<=n;p++)
            {
                for(int q=1;q<=n;q++)
                {
                    ele=sc.nextInt();
                    row[p][ele]=row[p][ele]+1;
                    col[ele][q]=col[ele][q]+1;
                    if(p==q)
                        trace+=ele;
                }
            }
            
            int rowc=0,colc=0;
            for(int p=1;p<=n;p++)
            {
            	for(int q=1;q<=n;q++)
            	{
            		if (row[p][q]!=1)
            		{
            			rowc++;
            			break;
            		}
            			
            	}
            }
            for(int p=1;p<=n;p++)
            {
            	for(int q=1;q<=n;q++)
            	{
            		if (col[q][p]!=1)
            		{
            			colc++;
            			break;
            		}
            			
            	}
            }
            System.out.println("Case #"+i+":"+trace+" "+rowc+" "+colc);
            
        }
		}
		finally
		{
			sc.close();
		}
    }
}


	
