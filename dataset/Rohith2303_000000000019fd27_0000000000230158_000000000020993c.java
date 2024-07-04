import java.util.*;
class A{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int h=1;h<=t;h++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    arr[i][j]=sc.nextInt();
                    int row=0;
                    int col=0;
                    int diag=0;
            int c[]=new int[c];
            int cmp=1;
                for(int i=0;i<n;i++){
                    c[i]=1;
                    cmp*=(i+1);
                }
            for(int i=0;i<n;i++)
            {
               int s=1;
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                    diag+=arr[i][j];
                    s*=arr[i][j];
                    c[j]*=arr[i][j];
                }
                if(s!=cmp)
                row++;
            }
            for(int i=0;i<n;i++)
                if(c[i]!=n)
                col++;
            System.out.println("Case #"+h+": "+diag+" "+row+" "+col);
        }
    }
}