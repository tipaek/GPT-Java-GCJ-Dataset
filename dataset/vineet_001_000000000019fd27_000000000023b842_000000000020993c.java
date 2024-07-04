import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=0;k<t;k++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int sum=((n*(n+1))/2);
            int trace=0;
            int sum2=0;
            int sum4=0;
            int r=0;
            int c=0;
            HashMap<Integer,Boolean> row=new HashMap<>();
            HashMap<Integer,Boolean> col=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                    if(i==j)
                    trace+=arr[i][j];
                }
                
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(row.containsKey(arr[i][j])==true)
                    {
                    r++;
                    break;
                    }
                    else
                
                    row.put(arr[i][j],true);
                }
                row.clear();
            }
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(col.containsKey(arr[j][i])==true)
                    {
                    c++;
                    break;
                    }
                    else
                
                    col.put(arr[j][i],true);
                }
                col.clear();
            }
            
            
            
            
            System.out.println("Case#"+k+": "+trace+" "+r+" "+c);
    }
    }
}
