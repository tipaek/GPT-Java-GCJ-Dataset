import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
                
        for(int i=0;i<tc;i++)
        {
            int N = in.nextInt();
            int a[][] = new int[N][N];
            int temp,sum=0;;
            
            for(int p=0;p<N;p++)
                for(int q=0;q<N;q++)
                    {
                        temp = in.nextInt();
                        a[p][q] = temp;
                        if(p == q)
                           sum = sum + temp;
                    }
            
            int r=0,c=0; 
            HashSet<Integer> hs = new HashSet<>();  
            
            for(int p=0;p<N;p++)
            {
                for(int q=0;q<N;q++)   
                    hs.add(a[p][q]);
                if(hs.size() != N)
                   r++;
                hs.clear();   
            }       
            
            for(int p=0;p<N;p++)
            {
                for(int q=0;q<N;q++)   
                    hs.add(a[q][p]);
                if(hs.size() != N)
                   c++;
                hs.clear();   
            }  
            System.out.println("Case #" + (i+1) + ": " + sum + " " + r + " " + c);
        }
    }
}