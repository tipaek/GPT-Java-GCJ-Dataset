import java.util.*;

public class Solution
{
    public static void main(String []arg)
    {
        int i,t,n,j,tr,r,c;
        boolean bc,br;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            n=sc.nextInt();
            tr=0;
            r=0;
            c=0;
            int mat[][]=new int[n][n];
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    mat[i][j]=sc.nextInt();
                }
            }
            for(i=0;i<n;i++)
            {
                tr=tr+mat[i][i];
                bc=true;
                br=true;
                Set<Integer> rfinddup=new HashSet<>();
                Set<Integer> cfinddup=new HashSet<>();
                for(j=0;j<n;j++)
                {
                    if(bc && rfinddup.add(mat[i][j])==false)
                    {
                        r++;
                        bc=false;
                    }
                    if(br && cfinddup.add(mat[j][i])==false)
                    {
                        c++;
                        br=false;
                    }
                }
                rfinddup.clear();
                cfinddup.clear();
            }
            System.out.println("Case #"+k+": "+tr+" "+r+" "+c);
        }
    }
}