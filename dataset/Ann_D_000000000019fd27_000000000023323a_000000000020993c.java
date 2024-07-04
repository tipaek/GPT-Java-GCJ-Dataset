package latin;
import java.util.*;
class solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int arr[][] = new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    arr[j][k]=sc.nextInt();
                }
            }
            int trace=0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(j==k)
                    {
                        trace=trace+arr[j][k];
                    }
                }
            }
            
            int r=0,c=0;
            for(int j=0;j<n;j++)
            {
                Integer temp[] = new Integer[n];
                for(int k=0;k<n;k++)
                {
                    temp[k]=arr[j][k];
                }
                Set<Integer> set = new HashSet<Integer>(Arrays.asList(temp));
                
                
                //System.out.println(set);
                if(set.size()!=n)
                {
                    r++;
                }
            }
            //System.out.println(r);
            for(int j=0;j<n;j++)
            {
                Integer temp[] = new Integer[n];
                for(int k=0;k<n;k++)
                {
                    temp[k]=arr[k][j];
                }
                Set<Integer> set = new HashSet<Integer>(Arrays.asList(temp));
                if(set.size()!=n)
                {
                    c++;
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
            
        }
    }
}