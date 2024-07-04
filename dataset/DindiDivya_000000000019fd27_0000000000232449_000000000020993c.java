import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int c1=0,c2=0,tr=0,c3=0,c4=0;
        int t=sc.nextInt();
        int n;
        for(int z=1;z<=t;z++)
        {
            n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k]=sc.nextInt();
                }
            }
            for(int l=0;l<n;l++)
            {
                tr=tr+a[l][l];
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    for(int k=j+1;k<n;k++)
                {
                    if(a[i][j]==a[i][k]){
                    c1++;
                        break;
                    }
                }
                if(c1>0)
                { c2++;
                break;
                }
                }
            }
            
        for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    for(int k=j+1;k<n;k++)
                {
                    if(a[j][i]==a[k][i]){
                    c3++;
                        break;
                    }
                }
                if(c3>0)
                { c4++;
                break;
                }
                }
            }
            System.out.println("Case #"+z+":  "+tr+" "+c1+" "+c3);
            tr=0;
            c1=0;
            c3=0;
        }
    }
}
        
    