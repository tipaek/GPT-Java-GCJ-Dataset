import java.util.Scanner;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    arr[j][k]=sc.nextInt();
                }
            }
            
            
    System.out.println("Case #"+""+(i+1)+": "+ trace(arr)+" "+getrowcount(arr,n)+" "+getcolumncount(arr,n));
            
            
            
            
            
        }
    }
    
    
    public static int getrowcount(int arr[][],int n)
    {  int rowcount=0;
    
                for(int k=0;k<n;k++)
                {
                    if(repeatrow(arr,k))
                    {
                        rowcount++;
                    }
                }
            return rowcount;
    }
    public static int getcolumncount(int arr[][],int n)
    {  int columncount=0;
    
                for(int k=0;k<n;k++)
                {
                    if(repeatcolumn(arr,k))
                    {
                        columncount++;
                    }
                }
                return columncount;
            
    }
    public static boolean repeatrow(int arr[][],int i)
    {    
        for(int j=0;j<arr.length-1;j++)
        {
            for(int k=j+1;k<arr.length;k++)
            {
                if(arr[i][j]==arr[i][k])
                {
                    return true;
                }
            }
        }  
        return false;
    }
    
    
    public static boolean repeatcolumn(int arr[][],int i)
    {
        for(int j=0;j<arr.length-1;j++)
        {
            for(int k=j+1;k<arr.length;k++)
            {
                if(arr[j][i]==arr[k][i])
                {
                    return true;
                }
            }
        }  
        return false;
        
        
    }
    
    public static int trace(int arr[][])
    {  int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(i==j)
                sum=sum+arr[i][j];
                
            }
        }
        return sum;
    }
}