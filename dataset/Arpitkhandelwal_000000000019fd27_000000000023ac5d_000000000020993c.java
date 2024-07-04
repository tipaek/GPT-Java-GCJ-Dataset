import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        String ans[]=new String[t];
        for(int x=1;x<=t;x++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            int trace=0,col=0,row=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                if(i==j) trace+=arr[i][j];
            }
            for(int i=0;i<n;i++)
            {
                int check1=0,check2=0;
                for(int j=0;j<n;j++)
                {
                    for(int k=j+1;k<n;k++)
                    {
                        if(arr[i][j]==arr[i][k]) 
                        {
                            check1=1;break;
                        }
                    }
                    for(int k=i+1;k<n;k++) if(arr[i][j]==arr[k][j]) {check2++;break;}
                }
                if(check1==1) col++;
                if(check2==1) row++;
            }
            ans[x-1]="Case #"+x+": "+trace+" "+row+" "+col;
        }
        for(int x=0;x<t;x++)System.out.println(ans[x]);
    }
}