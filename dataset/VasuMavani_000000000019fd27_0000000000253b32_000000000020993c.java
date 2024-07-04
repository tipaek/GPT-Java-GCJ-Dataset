import java.util.*;

public class van
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		int c=1;
		while(test-->0)
		{
			int diag=0;
			int c1=0,c2=0;
			int n=sc.nextInt();
			int a[][]=new int[n][n];
			Set<Integer> s = new HashSet<Integer>();
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j]=sc.nextInt();
				}
			}
			for(int i=0;i<n;i++)
			{
				diag=diag+a[i][i];
			}
			
			for (int i=0;i<n;i++)
			{
              for (int j=0;j<n;j++)
			  {
                 int CN=a[j][i];
                 if(!s.add(CN))
				 {
					c2++;
                    break;
                 }
              }
			  s.clear();
           }
			
			for (int i=0;i<n;i++)
			{
              for (int j=0;j<n;j++)
			  {
                int CN=a[i][j];
                if(!s.add(CN))
				{
					c1++;
                    break;
                }
              }
			  s.clear();
           }
		   
		   System.out.println("Case #"+c+": "+diag+" "+c1+" "+c2);
			c++;
		}
	}
} 