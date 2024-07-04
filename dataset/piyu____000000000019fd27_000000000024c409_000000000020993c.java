import java.util.*;

public class Solution{
    public static void main(String ard[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tt=1;tt<=t;tt++){
            int n=sc.nextInt();
            int arr[][]=new int [n][n];
            int r[][]=new int [n][n];
            int c[][]=new int [n][n];
            int trace=0,row=0,col=0;
            for(int i=0;i<n;i++)for(int j=0;j<n;j++)arr[i][j]=sc.nextInt();
            
            for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                if(i==j)
                    trace+=arr[i][j];
                r[i][arr[i][j]-1]++;
                c[j][arr[i][j]-1]++;
            }
            for(int i=0;i<n;i++){
                int count=0;
                for(int j=0;j<n;j++)
                    if(r[i][j]!=1)
                        count++;
                if(count!=0)
                    row++;
            }
            for(int i=0;i<n;i++){
                int count=0;
                for(int j=0;j<n;j++)
                    if(c[i][j]!=1)
                        count++;
                if(count!=0)
                    col++;
            }
            System.out.println("Case #"+tt+": "+trace+" "+row+" "+col);
        }
    }
}