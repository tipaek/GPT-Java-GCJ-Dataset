//CodeJam Problem 1//

import java.util.*;

class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext())
		{
			int T = sc.nextInt();
			while(T>0)
			{
				int n = sc.nextInt();
				int ar[][] = new int[n][n];
				int trace = 0;
				for(int i = 0;i<n;i++)
				{
					for(int j = 0;j<n;j++)
					{
						ar[i][j] = sc.nextInt();
						if(i==j)
							trace+= ar[i][j];
					}
				}

				//so we have already calculated the trace//

				int rows = getRowCount(ar,n);
				int cols = getColCount(ar,n);

				System.out.println("Case #"+T+": "+trace+" "+rows+" "+cols);
				T--;
			}
		}
		else
			sc.close();
	}

	 public static int getRowCount(int a[][], int n)
    {
        boolean flag;
        int count=0;
        for(int i=0; i<n; i++)
        {
            flag=false;
            for(int j=0; j<n-1; j++)
            {
                int first = a[i][j];
                for(int k=j+1; k<n; k++)
                {
                    if(first==a[i][k])
                    {
                        count++;
                        flag=true;
                        break;
                    }
                }
               
                if(flag==true)
                {
                    break;
                }
            }

           
        }
       
        return count;
       
    }// countrows closing
   
   
    public static int getColCount(int a[][], int n)
    {
        boolean flag;
        int count=0;
        for(int i=0; i<n; i++)
        {
            flag=false;
            for(int j=0; j<n-1; j++)
            {
                int first = a[j][i];
                for(int k=j+1; k<n; k++)
                {
                    if(first==a[k][i])
                    {
                        count++;
                        flag=true;
                        break;
                    }
                }
               
                if(flag==true)
                {
                    break;
                }
            }

           
        }
       
        return count;
       
    }
}