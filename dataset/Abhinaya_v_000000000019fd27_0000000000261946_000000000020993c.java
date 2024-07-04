import java.util.Scanner;
public class cj11 {
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int h=0;
        int ti[][]=new int[t][3];
        while(h<t)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n]; 
            int i=0,j=0,k;
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    k=sc.nextInt();
                    arr[i][j]=k;
                }
            }
            int trace=0;
            for(i=0;i<n;i++)
                trace+=arr[i][i];
            ti[h][0]=trace;
            int count,cr=0;
            for(i=0;i<n;i++)
            {
                count=0;
                int scr[]=arr[i];
                for(j=0;j<n-1;j++)
                {
                    int eq=scr[j];
                    for(k=j+1;k<n;k++)
                    {
                        if(eq==arr[i][k])
                        {
                            count+=1;
                            break;
                        }
                    }
                }
                if(count>0){cr=cr+1;}
            }
            ti[h][1]=cr;
            int cc=0;
            count=0;
            for(i=0;i<n;i++)
            {
                count=0;
                int scr[]=new int[n];
                for(int d=0;d<n;d++)
                {
                    scr[d]=arr[d][i];
                }
                for(j=0;j<n-1;j++)
                {
                    int eq=scr[j];
                    for(k=j+1;k<n;k++)
                    {
                        if(eq==arr[k][i])
                        {
                            count+=1;
                            break;
                        }
                    }
                }
                if(count>0){cc=cc+1;}
            }
            ti[h][2]=cc;
            h++;
        }
        for(int i=0;i<t;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(ti[i][j]+" ");
            }
            System.out.println();
        }
    }
}