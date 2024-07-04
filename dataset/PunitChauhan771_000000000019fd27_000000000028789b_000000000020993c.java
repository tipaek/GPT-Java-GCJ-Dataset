import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
    private static Scanner sc;
    static int tn=1;
    
    public static void main(String[] args)
    {
        sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-- > 0)
        {
        solve();
        }
    }
    public static void solve()
    {
        int size=sc.nextInt();
        int[][] arr=new int[size][size];
        int k=0;
        for(int i=0;i<arr.length;i++)
        {  
            for(int j=0;j<arr.length;j++)
   	        {
   	            arr[i][j]=sc.nextInt();
   	            if(i==j)
   	            k+=arr[i][j];
   	        }    
        }
        int r=getR(arr);
        int c=getC(arr);
        
    System.out.println("Case #"+(tn++)+": "+k+" "+r+" "+c);
        
    } 
    private static int getR(int[][] arr)
    {
        int res=0;
        for(int i=0;i<arr.length;i++){
        Set<Integer> set=new HashSet<>();
            for(int j=0;j<arr.length;j++)
            {
                if(set.contains(arr[i][j]))
                {
                    res++;
                    break;
                }
                set.add(arr[i][j]);
            }
        }
        return res;
    }
    private static int getC(int[][] arr)
    {
        int res=0;
        for(int i=0;i<arr.length;i++){
        Set<Integer> set=new HashSet<>();
        
        for(int j=0;j<arr.length;j++)
        {
            if(set.contains(arr[j][i]))
            {
                res++;
                break;
            }
            set.add(arr[j][i]);
        }
    }return res;
    }
    
};