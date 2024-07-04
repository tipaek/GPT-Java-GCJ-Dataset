
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static int diagnol(int [][]arr, int n)
    {
        int sum=0;
        for(int i=0;i<n;i++) {
		    sum+=arr[i][i];
		}
		return sum;
    }
    public static int checkR(int [][]arr, int n)
    {
        int []temp = new int[n+1];
        boolean flag=true;
        int count=0;
        for(int i=0;i<n;i++) {
            flag = true;
		    for(int j=0;j<n;j++) {
		        temp[j+1] = arr[i][j];        
		    }
		    Arrays.sort(temp);
		    for(int k=1;k<=n;k++) {
		        if((1+temp[k-1]) != temp[k]) {
		            flag = false;
		            break;
		        }
		    }
		    if(flag) 
		       count++;
		}
		return n-count;
    }
    public static int checkC(int [][]arr, int n)
    {
        int []temp = new int[n+1];
        boolean flag=true;
        int count=0;
        for(int i=0;i<n;i++) {
            flag = true;
		    for(int j=0;j<n;j++) {
		        temp[j+1] = arr[j][i];        
		    }
		    Arrays.sort(temp);
		    for(int k=1;k<=n;k++) {
		        if(temp[k] != 1+temp[k-1]) {
		            flag = false;
		            break;
		        }
		    }
		    if(flag) 
		       count++;
		}
		return n-count;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		int test = sc.nextInt();
		int temp=1;
		while(temp<=test)
		{
		    int n = sc.nextInt();
		    int [][]arr = new int[n][n];
		    for(int i=0;i<n;i++) {
		        for(int j=0;j<n;j++) {
		            arr[i][j] = sc.nextInt();
		        }
		    }
		    
		    int k = diagnol(arr, n);
		    int r = checkR(arr, n);
		    int c = checkC(arr, n);
		    
		    System.out.println("Case #"+temp+": "+k+" "+r+" "+c);
		    temp++;
		}
	}
}





















