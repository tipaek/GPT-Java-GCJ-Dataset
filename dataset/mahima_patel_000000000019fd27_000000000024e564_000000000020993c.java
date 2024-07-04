import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    int n=sc.nextInt();
		    int a[][]=new int[n][n];
		    for(int j=0;j<n;j++)
		        for(int k=0;k<n;k++)
		            a[j][k]=sc.nextInt();
		    int tr=0;
		    for(int j=0,k=0;j<n;j++,k++)
		    {
		        tr+=a[j][k];
		    }
		    System.out.print("Case #"+(i+1)+": "+tr+" ");
		    int r=0;
		    for(int j=0;j<n;j++)
		    {
		        for(int k=0;k<n;k++)
		        {
		            int flag=0;
		            for(int l=k+1;l<n;l++)
		            {
		                if(a[j][k]==a[j][l])
		                {
		                    r++;
		                    flag=1;
		                    break;
		                }
		                
		            }
		            if(flag==1)
		                break;
		        }
		    }
		    System.out.print(r+" ");
		    int c=0;
		    for(int j=0;j<n;j++)
		    {
		        for(int k=0;k<n;k++)
		        {
		            int flag=0;
		            for(int l=k+1;l<n;l++)
		            {
		                if(a[k][j]==a[l][j])
		                {
		                    c++;
		                    flag=1;
		                    break;
		                }
		                
		            }
		            if(flag==1)
		                break;
		        }
		    }
		    System.out.println(c);
		    
		}
	}
}
