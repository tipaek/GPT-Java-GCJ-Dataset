import java.util.*;
import java.io.*;
class vestigium
{
    public static void main(String args[])throws IOException
    {
      Scanner sc =new Scanner(System.in);
      int c =1;
      int t=sc.nextInt();
      while(t-->0){
          int sum=0,sumarr=0,col=0,row=0;
        int n=sc.nextInt();
        int nsum=(n*(n+1))/2;
        int arr[][] = new int[n][n];
        int arrs[] = new int[n];
        for(int i=0;i<n;i++)
        {for(int j=0;j<n;j++)
            {
            arr[i][j] = sc.nextInt();
            sumarr = sumarr+arr[i][j];
            arrs[j] = arrs[j]+arr[i][j];
            if(i==j)
            sum = sum+ arr[i][j];
        }
        if(sumarr!=nsum)
        row++;
        sumarr=0;
    }
        for(int i=0;i<n;i++){
        if(arrs[i]!=nsum)
        col++;
        }
        System.out.println("Case #"+c+": "+sum+" "+row+" "+col);
        c++;
        }}}