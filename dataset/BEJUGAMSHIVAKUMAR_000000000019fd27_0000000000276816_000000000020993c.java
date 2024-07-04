import java.util.*;

class Test
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int z=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            int m[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    m[i][j]=sc.nextInt();
                }
            }
        
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=m[i][i];
        }
        int r=0;
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            { boolean flag=false;
              int kk=m[i][j];
			  for(int k=j+1;k<n;k++)
				{
				  if(kk==m[i][k])
					{
					  r++;
					  flag=true;
					  break;
					}
				}
				if(flag==true)
					break;
			}
		}
		for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            { boolean flag=false;
              int kk=m[j][i];
			  for(int k=j+1;k<n;k++)
				{
				  if(kk==m[k][i])
					{
					  c++;
					  flag=true;
					  break;
					}
				}
				if(flag==true)
					break;
			}
		}
              
                    
				
							

                
           
           System.out.println("Case #"+(z)+": "+(sum)+" "+(r)+" "+(c)) ;  
        z++;
            
        }
    }
    
}