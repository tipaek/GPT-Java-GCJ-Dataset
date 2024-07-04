import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{
    private static Scanner sc;
    static int t=1;
    
    public static void main(String []args)
    {
        sc=new Scanner (System.in);
        int test=sc.nextInt();
        sc.nextLine();
        while(test-- >0)
        {
            verdict();
        }
    }
private static void verdict()
{
    int n=sc.nextInt();
    int [][] arr= new int [n][n];
    int k=0;
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[i].length;j++)
        {
            arr[i][j]=sc.nextInt();
            if(i==j) k+=arr[i][j];
            
        }
    }
    int row=rowd(arr);
    int col=cold(arr);
    
    System.out.println("Case #"+(t++)+": "+k+" "+row+" "+col);
}
private static int rowd(int [][] arr)
{
    int result=0;
    for(int i=0;i<arr.length;i++){
        Set<Integer> set =new HashSet<>();
        
        for(int j=0;j<arr[i].length;j++)
        {
            if(set.contains(arr[i][j]))
            {
                result++;
                break;
            }
            set.add(arr[i][j]);
        }
    }
    return result;
}
private static int cold(int [][] arr)
{
    int result=0;
    for(int i=0;i<arr.length;i++){
        Set <Integer> set =new HashSet<>();
        
        for(int j=0;j<arr.length;j++)
        {
            if(set.contains(arr[j][i]))
            {
                result++;
                break;
            }
            set.add(arr[j][i]);
        }
    }
    return result;
}
}