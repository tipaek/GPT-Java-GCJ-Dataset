import java.util.*;

public class Solution 
{
 	public static boolean repeatC(int j, int num, int arr[][]){
        int i=0;
        while(i<arr.length && arr[j][i]!=0)
        {
            if(arr[j][i]==num)
            {
                return true;
            }
            i++;
        }
        return false;
    }
    	public static boolean repeatR(int j, int num, int arr[][]){
        int i=0;
        while(i<arr.length && arr[i][j]!=0)
        {
            if(arr[i][j]==num)
            {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=1; k<=t; k++)
        {
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
 	    boolean rc[] = new boolean[n];
            int sum=0,r=0,c=0;
            for(int i=0; i<n; i++)
            {
                boolean rr = true;
                for(int j=0; j<n; j++)
                {
                    int num = sc.nextInt();
                    if(rr && repeatC(i, num, arr))
                    {
                        rr=false;
                        c++;
                    }
                    if(!rc[j] && repeatR(j, num, arr))
                    {
                        rc[j]=true;
                        r++;
                    }
                    arr[i][j] = num;
                    if(i==j)
                    {
                        sum+= num;
                    }
                }
            }
            System.out.println("Case #"+(k)+": "+sum+" "+c+" "+r);
        }
    }
   
}