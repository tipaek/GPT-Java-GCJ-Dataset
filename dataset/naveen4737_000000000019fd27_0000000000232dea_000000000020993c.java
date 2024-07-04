import java.util.*;
public class matrix2
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t,i,i1,j1,cou;
        t=sc.nextInt();
        int n[] = new int[t];
        int o[][] = new int[t][3];
        for(i=0;i<t;i++)
        {
            n[i] = sc.nextInt();
            int a[][] = new int[n[i]][n[i]];
            for(i1=0;i1<n[i];i1++)
            {
                for(j1=0;j1<n[i];j1++)
                {
                    a[i1][j1] = sc.nextInt();
                }
            }
            for(j1=0;j1<n[i];j1++)
            {
                int d1=0,d2=0;
                for(cou=1;cou<=n[i];cou++)
                {
                    int dec=0,ced=0;
                    for(i1=0;i1<n[i];i1++)
                    {
                        if(cou == a[i1][j1])
                            dec=1;
                        if(cou == a[j1][i1])
                            ced=1;
                    }
                    if(dec == 0 && d1 == 0)
                    {
                        o[i][2]++;
                        d1=1;
                    }
                    if(ced == 0 && d2 == 0)
                    {
                        o[i][1]++;
                        d2=1;
                    }
                }
                o[i][0] = o[i][0] + a[j1][j1];
            }
        }
        for(i=0;i<t;i++)
        {
            System.out.println("Case #"+i+" : "+o[i][0]+" "+o[i][1]+" "+o[i][2]);
        }
    }
}