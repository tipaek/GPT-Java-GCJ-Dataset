import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t,i,cou,i1,j,j1=0;
        t=sc.nextInt();
        int n[] = new int[t];
        int k[] = new int[t];
        for(i=0;i<t;i++)
        {
            n[i]=sc.nextInt();
            k[i]=sc.nextInt();
        }
        for(i1=0;i1<t;i1++)
        {
            boolean possible=false;
            int a[][] = new int[n[i1]][n[i1]];
            for(int t1=0;t1<n[i1];t1++)
            {
                int counter=t1;
                for(int t2=0;t2<n[i1];t2++)
                {
                    a[t1][counter] = t2+1;
                    counter++;
                    if(counter == n[i1])
                        counter=0;
                }
            }
            int z[][] = new int[(int)(Math.pow(n[i1],n[i1]))][n[i1]];
            i=0;
            j=0;
            int d=1;
            cou = (int)(Math.pow(n[i1],n[i1]-1));
            while(true)
            {
                z[i][j] = d;
                i++;
                if(i%cou==0)
                    d++;
                if(d>n[i1])
                    d=1;
                if(i == (int)(Math.pow(n[i1],n[i1])))
                {
                    j++;
                    i=0;
                    d=1;
                    cou = cou/n[i1];
                    if(j==n[i1])
                        break;
                }
            }
            boolean found=false;
            for(i=0;i<(int)(Math.pow(n[i1],n[i1]));i++)
            {
                for(j=0;j<n[i1];j++)
                {
                    found = false;
                    for(j1=0;j1<n[i1];j1++)
                    {
                        if(j+1 == z[i][j1])
                        {
                            found = true;
                            break;
                        }
                    }
                    if(found == false)
                    {

                        break;
                    }
                }
                if(found == false)
                    continue;
                else if(found)
                {
                    int sum=0;
                    for(j=0;j<n[i1];j++)
                    {
                        sum=sum+a[z[i][j]-1][j];
                    }
                    if(sum == k[i1])
                    {
                        possible = true;
                        System.out.println("Case #"+(i1+1)+": POSSIBLE");
                        for(j=0;j<n[i1];j++)
                        {
                            for(int w=0;w<n[i1];w++)
                            {
                                System.out.print(a[z[i][j]-1][w]+" ");
                            }
                            System.out.println();
                        }
                        break;
                    }
                }
            }
            if(possible == false)
                System.out.println("Case #"+(i1+1)+": IMPOSSIBLE");
        }
    }
}