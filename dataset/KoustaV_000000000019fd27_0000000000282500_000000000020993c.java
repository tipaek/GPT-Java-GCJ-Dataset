import java.util.*;
class testOK
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[] sol1=new int[t];
        int[] sol2=new int[t];
        int[] sol3=new int[t];
        for(int u=0;u<t;u++)
        {
            
        	int n=sc.nextInt();
            int i;
            int j;
            int[][] m=new int[n][n];
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    int p=sc.nextInt();
                    m[i][j]=p;
                    
                }
            }
            
            int k=0;
            
            for( i=0;i<n;i++)
            {
               k=k+m[i][i];
            }
            
            int r=0;
            int c=0;
            int flag=0; 
     
            	for (int v = 0; v <n; v++) 
            	{
            		for(int q=0;q<n-1;q++)
            		{
            			for(int z=q+1;z<n;z++)
            			{
            				if(m[v][z]==m[v][q])
            				{
            					r++;
            					flag=1;
            					break;
            				}
            				
            			}
            			if(flag==1)
            			{
            				break;
            			}
            		}
            		
            	}
            	for (int v = 0; v <n; v++) 
            	{
            		for(int q=0;q<n-1;q++)
            		{
            			for(int z=q+1;z<n;z++)
            			{
            				if(m[z][v]==m[q][v])
            				{
            					c++;
            					flag=1;
            					break;
            				}
            				
            			}
            			if(flag==1)
            			{
            				break;
            			}
            		}
            		
            	}


            sol1[u]=k;
            sol2[u]=r;
            sol3[u]=c;

        
        }
        for(int g=1;g<=t;g++)
        {
            System.out.println("Case #"+g+": "+sol1[g-1]+" "+sol2[g-1]+" "+sol3[g-1]);
        }
        
        
    }
}