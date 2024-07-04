import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution
{
	static void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 
    static int gcd(int a, int b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
    static long power(long n,long m)
    {
    	if(m==0)
    		return 1;
    	long ans=1;
    	while(m>0)
    	{
    		ans=ans*n;
    		m--;
    	}
    	return ans;
    }
	static int binarySearch(int arr[], int x) 
    { 
        int l = 0, r = arr.length- 1,m=l + (r - l) / 2; 
        while (l <= r) { 
            m = l + (r - l) / 2; 
            if (arr[m] == x) 
                return m; 
            if (arr[m] < x) 
                l = m + 1; 
            else
                r = m - 1; 
        } 
        return (int)Math.max(l, m); 
    } 
	public static void main(String args[])throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
	    for(int i=1;i<=t;i++)
	    {
	    	String s=br.readLine();
	        String ss[]=s.split(" ");
	        int e=Integer.parseInt(ss[0]);
	        int n=Integer.parseInt(ss[1]);
	        String st=ss[2];
	        if(e>st.length()||n>st.length())
	        {
	        	System.out.println("Case #"+i+": "+"IMPOSSIBLE");
	        	continue;
	        }
	        int ans=e;
	        int temp=0;
	        while(e>0)
	        {
	        	e--;
	        	if(st.charAt(temp)=='S')
	        		n--;
	        	else
	        		n++;
	        	temp++;
	        }
	        for(int j=temp;j<st.length();j++)
	        {
	        	if(st.charAt(j)=='S')
	        		n--;
	        	else
	        		n++;
	        	if(n>0)
	        		n--;
	        	else if(n<0)
	        		n++;
	        	ans++;
	        	if(n==0)
	        		break;
	        }
	        if(n==0)
	        System.out.println("Case #"+i+": "+ans);
	        else
	        System.out.println("Case #"+i+": "+"IMPOSSIBLE");	
	    }
	}
}
