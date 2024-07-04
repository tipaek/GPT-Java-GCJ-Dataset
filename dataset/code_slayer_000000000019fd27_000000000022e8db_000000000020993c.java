import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int x=1;
        while(T>0)
        {
            int n=sc.nextInt();
            int [][]a=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                   a[i][j]=sc.nextInt();
            int r=0;
            
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(set.contains(a[i][j]))
                    {
                        r++;
                        set.clear();
                        break;
                    
                    }
                    else
                        set.add(a[i][j]);
                }
            }
            
            int c=0;
            for(int j=0;j<n;j++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int i=0;i<n;i++)
                {
                    if(set.contains(a[i][j]))
                    {
                        c++;
                        set.clear();
                        break;
                    }
                    else
                        set.add(a[i][j]);
                }
            }
            
            int k=0;
            for(int i=0;i<n;i++)
            k+=a[i][i];
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
            T--;
            x++;
        }
    }
}