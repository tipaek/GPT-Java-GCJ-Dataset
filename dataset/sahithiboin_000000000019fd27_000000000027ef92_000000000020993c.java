import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
           int[][] arr = new int[n][n]; 
           
           for(int row = 0; row< arr.length; row++){ 
                 for(int col = 0 ;col< arr[row].length; col++){ 
                     arr[row][col] = in.nextInt(); 
                  } 
             }
           int k=trace(arr,n);

           int r=row_duplicate(arr,n);

           int c=col_duplicate(arr,n);

           System.out.println("Case #" +i+ ":"+" " +k+ " " +r+ " " +c); 
           
        	}
        }

    public static int trace(int arr[][],int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                    sum=sum+arr[i][j];
            }
        }
        return sum;
    }
    public static int row_duplicate(int arr[][],int n)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            int row[]=arr[i];
            for(int j=0;j<row.length;j++)
            {
                if(h.containsKey(row[j]))
                {
                    count++;
                    break;
                }
                else
                {
                    h.put(row[j],1);
                }
            }
            h.clear();
        }
        return count;
    }

    public static int col_duplicate(int arr[][],int n)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int ele=arr[j][i];
                if(h.containsKey(ele))
                {
                    count++;
                    break;
                }
                else
                {
                    h.put(ele,1);
                }
            }
            h.clear();
        }
        return count;

    }
}