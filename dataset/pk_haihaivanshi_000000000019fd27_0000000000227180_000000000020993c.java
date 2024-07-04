import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int m=1; m<=t; m++)
        {
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            int k=0;
            for(int i=0; i<n; i++)
            {
                k = k+arr[i][i];
            }
            int r=0,c=0;
            for(int i=0; i<n; i++)
            {
                int count=0;
                for(int j=0; j<n-1; j++)
                {
                    for(int l=j+1; l<n; l++)
					{
						if(arr[i][j]==arr[i][l])
						{
							count++;
							break;
						}
					}	
					if(count>0)
						break;
                }
                if(count>0)
                {
                    r++;
                }
            }
            int rotated[][] = new int[n][n];
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    rotated[i][j] = arr[(n-j-1)][i];
                }
            }
            for(int i=0; i<n; i++)
            {
                int count=0;
                for(int j=0; j<n-1; j++)
                {
                    for(int l=j+1; l<n; l++)
					{
						if(rotated[i][j]==rotated[i][l])
						{
							count++;
							break;
						}
					}	
					if(count>0)
						break;
                }
                if(count>0)
                {
                    c++;
                }
            }
            System.out.print("Case #"+m+": ");
            System.out.print(k+" ");
            System.out.print(r+" ");
            System.out.println(c);
        }
    }
}