import java.util.*;
import java.io.*;
import java.util.HashSet;

public class Solution
{
    void makeOne(int arr[], int a, int b)
    {
        for(int i=a;i<b;i++)
        {
            arr[i]=1;
        }
    }
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    int T = input.nextInt();
	    
	    for(int t=1;t<T+1;t++)
	    {
	        int j[] = new int[1441];
	        int c[] = new int[1441];
	        int n, i, flag=1;
	        
	        n = input.nextInt();
	        
	        int s[] = new int[n];
	        int e[] = new int[n];
	        char jobs[] = new char[n];
	        
	        for(i=0;i<n;i++)
	        {
	            s[i] = input.nextInt();
	            e[i] = input.nextInt();
	        }
	        Solution ob = new Solution();
	        ob.makeOne(j, s[0], e[0]);
	        jobs[0] = 'J';
	        for(i=1;i<n;i++)
	        {
	            int a, b;
	            a = s[i]; 
	            b = e[i];
	            if(j[a]!=1 && j[b]!=1)
	            {
	                ob.makeOne(j, a, b);
	                jobs[i] = 'J';
	            }
	            else if(c[a]!=1 && c[b]!=1)
	            {
	                ob.makeOne(c, a,b);
	                jobs[i] = 'C';
	            }
	            else
	            {
	                flag=0;
	                break;
	            }
	        }
	        
	        if(flag==1)
	        {
	            System.out.println("Case #" + t + ": " + String.valueOf(jobs));
	            //System.out.println(jobs[0]);
	        }
	        else
	        {
	            System.out.println("Case #" + t + ": IMPOSSIBLE");
	        }
	        
	    }
	}
}