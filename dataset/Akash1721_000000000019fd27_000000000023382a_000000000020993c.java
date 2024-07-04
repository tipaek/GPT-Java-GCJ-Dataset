import java.util.*;
class Solution
{
    static int trace(int arr[][],int n)
    {
        int tr=0;
        for(int i=0;i<n;i++)
        {
            tr=tr+arr[i][i];
        }
        return tr;
    }
    static boolean checkDuplicatesWithinK(int arr[], int k) 
    { 
        HashSet<Integer> set = new HashSet<>(); 
  
        for (int i=0; i<arr.length; i++) 
        { 
            if (set.contains(arr[i])) 
               return true; 
  
            set.add(arr[i]); 
  
            if (i >= k) 
              set.remove(arr[i-k]); 
        } 
        return false; 
    } 
    static int hasDuplicatesInRows(int mat[][],int n)
    { 
        int arr[]=new int[n];
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[j]=mat[i][j];
            }
            
            if(checkDuplicatesWithinK(arr,n)==true )
                c++;
        }
        return c;
    }
    static int hasDuplicatesInCols(int mat[][],int n)
    { 
        int arr[]=new int[n];
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[j]=mat[j][i];
            }
            
            if(checkDuplicatesWithinK(arr,n)==true )
                c++;
        }
        return c;
    }
    public static void main (String args[])
    {
        Scanner sc= new Scanner(System.in);
        int test= sc.nextInt();
        for(int t=1;t<=test;t++)
        {
            int n= sc.nextInt();
            int a[][]= new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]= sc.nextInt();
                }
            }
            int tr = trace(a,n);
            int r = hasDuplicatesInRows(a,n);
            //int trans[][] = transposemat(a,n);
            int col = hasDuplicatesInCols(a,n);
            System.out.println("Case #"+t+": "+tr+" "+r+" "+col);
        }
        
    }
}