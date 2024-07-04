import java.util.*;
class Calculate
{
     static boolean ir(int arr[], int size) 
    { 
        int i; int g=0;
        for (i = 0; i < size; i++) 
        { 
            if (arr[ Math.abs(arr[i])] >= 0) 
                arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])]; 
            else
            g++;
        }     
        if(g>0)
        return true;
        else
        return false;
    }  
  
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        Calculate please=new Calculate();
        while(t-->0)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];int sum=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                   arr[i][j]=sc.nextInt();
                   if(i==j)
                   sum=sum+arr[i][j];
                }
            }
            int r=0;
            int c=0;
            for(int i=0;i<n;i++)
            {
                int a[]=new int[n];
                for(int j=0;j<n;j++)
                {
                    a[j]=arr[i][j];
                }
                if(please.ir(a,n));
                r++;
            }
            for(int j=0;j<n;j++)
            {
                int a[]=new int[n];
                for(int i=0;i<n;i++)
                {
                    a[i]=arr[i][j];
                }
                if(please.ir(a,n));
                c++;
            }
            System.out.println(sum+" "+r+" "+c);
        }
    }
}