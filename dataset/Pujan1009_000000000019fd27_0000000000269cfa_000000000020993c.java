import java.util.Scanner;
import java.util.HashSet;
public class Solution
{
    public static void main(String[] stp)
    {
        Scanner scan = new Scanner(System.in);

        int t=scan.nextInt(),i;
        int ncase=1;
        while(t-- > 0)
        {

            int n = scan.nextInt();
            int a[][] = new int[n][n];
            for(i=0;i<n;i++)
            {
                for(int j=0;j<n;j++) a[i][j]=scan.nextInt();
            }
            HashSet<Integer> hs1=new HashSet<>();
            HashSet<Integer> hs2=new HashSet<>();
            long sum=0,row=0,col=0;
            for(i=0;i<n;i++) sum+=a[i][i];
            for(i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    hs1.add(a[i][j]);
                    hs2.add(a[j][i]);
                }
                if(hs1.size()!=n) row++;
                if(hs2.size()!=n) col++;
                hs1.clear(); hs2.clear();
            }
            System.out.println("Case #"+ncase+": "+sum+" "+row+" "+col);
            ncase++;
        }
    }




}