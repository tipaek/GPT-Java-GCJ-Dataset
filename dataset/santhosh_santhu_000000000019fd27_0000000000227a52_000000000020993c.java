import java.util.*;
class  Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[][] res=new int[t][t];
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt(); 
            int[][] arr=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                arr[j][k]=sc.nextInt();
            }
            int trace=0,flag,count=0,flag2,count2=0;
            for(int j=0;j<n;j++)
            {
                flag=0;
                flag2=0;
                for(int k=0;k<n;k++)
                {
                    if(k==j)
                    trace+=arr[j][k];
                    if(flag!=1){
                    for(int l=k+1;l<n;l++)
                    if(arr[j][k]==arr[j][l])
                    {
                        flag=1;
                        count++;
                        break;
                    }}
                    if(flag2!=1){
                    for(int l=k+1;l<n;l++)
                    if(arr[k][j]==arr[l][j])
                    {
                        flag2=1;
                        count2++;
                        break;}
                    }
                }
            }
            res[i][0]=trace;
            res[i][1]=count;
            res[i][2]=count2;
        }
        for(int i=0;i<t;i++)
        {for(int j=0;j<t;j++)
        System.out.print(res[i][j]+" ");
        System.out.println();}
    }
}