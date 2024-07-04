import java.util.*;
import java.lang.*;
import java.io.*;
class gva
{
    

public static void main (String[] args) throws java.lang.Exception
{
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int i=1;i<=T;i++)
    {
        int sum = 0;
        int row = 0;
        int col = 0;
        int N = sc.nextInt();
        int arr[][] = new int[N][N];
        for(int j=0;j<N;j++)
        {
        
            for(int k=0;k<N;k++)
            {
                arr[j][k]=sc.nextInt();
                if(j==k)
                sum=sum+ arr[j][k];
            }
        }
        
        for(int j=0;j<N;j++)
        {
            int flag =0;
            for(int k=0;k<N;k++)
            {
                for(int l=k+1;l<N;l++)
                {
                    if(arr[j][k]==arr[j][l])
                    {
                        row = row + 1;
                        flag =1;
                    }
                }
                if(flag ==1)
                break;
            }
        }
        
        for(int j=0;j<N;j++)
        {
            int flag =0;
            for(int k=0;k<N;k++)
            {
                for(int l=k+1;l<N;l++)
                {
                    if(arr[j][k]==arr[j][l])
                    {
                        col = col + 1;
                        flag =1;
                    }
                }
                if(flag ==1)
                break;
            }
        }
        
        System.out.println("Case #"+ i+":"+" "+sum+" "+row+" "+col);
    }  
}
}