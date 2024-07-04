import java.util.*;
class Solution
{
    public static void main(String s[])
    {
        Scanner sc = new Scanner(System.in);
        int no_of_testcase = sc.nextInt();
        int count=1;
        while(count++<=no_of_testcase)
        {
            int n = sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    a[i][j]=sc.nextInt();
            
            int trace=0;
            for(int i=0;i<n;i++)
                trace=trace+a[i][i];
                
            int r=0,c=0;
            
            for (int i = 0; i <n; i++)
            { 
                HashSet<Integer> h = new HashSet<>();
                HashSet<Integer> h1 = new HashSet<>();
                for (int j = 0; j <n; j++)
                {
                    h.add(a[i][j]);
                    h1.add(a[j][i]);
                }
                    
                if (h.size() < n) 
                    r++;
                if (h1.size() < n) 
                    c++;
            }
            System.out.println("Case #"+(count-1)+": "+trace+" "+r+" "+c);
        }
    }
    
}