import java.lang.*;
import java.util.*; 
class Solution
{
    public static void main(String[] args)
    {
        Scanner k=new Scanner(System.in);
        int t=k.nextInt();
        for(int tt=1;tt<=t;tt++)
        {
            int n=k.nextInt();
            int[][] m=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    m[i][j]=k.nextInt();
                }
            }
            int d=0;
            int r=0;
            int c=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                    {
                        d=d+m[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                ArrayList<Integer> mm=new ArrayList<>();
                for(int j=0;j<n;j++)
                {
                     int s=m[i][j];
                     if(!mm.contains(s))
                     {
                         mm.add(s);
                     }
                 }
                 if(mm.size()!=n)
                 {
                    //  System.out.println("r"+ mm.size());
                     r++;
                 }
            }
            for(int i=0;i<n;i++)
            {
                ArrayList mn=new ArrayList();
                for(int j=0;j<n;j++)
                 {
                     int s=m[j][i];
                     if(!mn.contains(s))
                     {
                         mn.add(s);
                     }
                 }
                 if(mn.size()!=n)
                 {
                     c++;
                    //  System.out.println("c"+ mn.size());
                 }
             }
            System.out.println("Case #"+tt+": " +d+" "+ r+" "+ c);
            System.out.flush();
        }
    }
}
