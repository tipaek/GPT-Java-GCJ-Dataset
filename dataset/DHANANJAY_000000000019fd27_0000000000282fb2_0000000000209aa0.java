import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		int t=kb.nextInt();
		for(int i=1;i<=t;i++)
		{
		    int n=kb.nextInt();
		    int k=kb.nextInt();
		    int r=k/n;
		    int[][] arr=new int[n][n];
		    if(k%n!=0)
		    {
		        System.out.println("Case #"+i+": IMPOSSIBLE");
		        continue;
		    }
		    else
		    {    
		        for(int j=0;j<n;j++)
		        {   int m=1;
		            for(int l=0;l<n;l++)
		            {
		                if(j==l)
		                {
		                    arr[j][l]=r;
		                }
		                else
		                {
		                    if(m!=r)
		                    {
		                        arr[j][l]=m;
		                        m=m+1;
		                    }
		                    else
		                    {
		                        arr[j][l]=m+1;
		                    }
		                }
		            }
		        }
		    }
		    arr[1][0]=3;
		    arr[1][2]=1;
		    System.out.println("Case #"+i+": POSSIBLE");
		    for(int x=0;x<n;x++)
		    {
		        for(int y=0;y<n;y++)
		        {
		            System.out.print(arr[x][y]+" ");
		        }
		        System.out.println();
		    }
		}
	}
}
