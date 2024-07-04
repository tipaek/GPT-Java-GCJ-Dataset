import java.util.*;
import java.io.*;

class Solution{
    
public static boolean check_col(int[][] arr,int r)
{
    Set<Integer> set =new HashSet<>();
    for(int j=0;j<arr[0].length;j++)
    {
        if(set.contains(arr[j][r]) == true)
        {
            return false;
        }
        set.add(arr[j][r]);
    }
    return true;
}

public static boolean check_row(int[][] arr,int r)
{
    Set<Integer> set =new HashSet<>();
    for(int j=0;j<arr[0].length;j++)
    {
        if(set.contains(arr[r][j]) ==true)
        {
            return false;
        }
        set.add(arr[r][j]);
    }
    return true;
}

public static void solution(int[][] arr,int ct)

{
    boolean[] row=new boolean[arr.length];
    boolean[] col=new boolean[arr.length];
    int sumc=0;
    int sumr=0;
    int trace=0;
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            if(i==j){
                trace+=arr[i][j];
                
            }
            if(row[i]==false && check_row(arr,i) == false){
                sumr++;
                row[i]=true;
            }
            
            if(col[j]==false && check_col(arr,j) == false){
                sumc++;
                col[j]=true;
            }
        }
    }
    System.out.println("Case #"+ct+ ":" +" "+trace+" "+sumr+" "+sumc);
    
}
public static void main(String[] args)
{
    Scanner scn=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t=scn.nextInt();
    
    int ct=1;
    while(ct<=t)
    {
        int n=scn.nextInt();
        
        int[][] arr=new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=scn.nextInt();
            }
        }
        solution(arr,ct);
        ct++;
    }
    
}
}