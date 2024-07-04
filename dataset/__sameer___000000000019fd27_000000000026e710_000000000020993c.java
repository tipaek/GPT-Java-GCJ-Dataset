/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
 Scanner p= new Scanner(System.in);
 int t= p.nextInt();
 int cs=1;
 ab: while(--t>=0)
 {
     int n=p.nextInt();
     int x1=0,x=0,y=0;
     long arr[][]=new long[n][n];
     long sum=0;
     for(x1=0;x1<n;x1++)
     {
      
       for(x=0;x<n;x++)
        { 
          arr[x1][x]=p.nextLong();
          if(x1==x)
          sum+=arr[x][x];
        }
        
     }
     long row[]=new long[n],col[]=new long[n];
   a:for(x1=0;x1<n;x1++)
     {
         for(x=0;x<n;x++)
         {
             long num=arr[x1][x];
             for(y=x+1;y<n;y++)
             {
                 if(num==arr[x1][y])
                 {
                     row[x1]=-1;
                     continue a;
                 }
             }
         }
     }

b:   for(x1=0;x1<n;x1++)
     {
         for(x=0;x<n;x++)
         {
             long num1=arr[x][x1];
             for(y=x+1;y<n;y++)
             {
                 if(num1==arr[y][x1])
                 {
                     col[x1]=-1;
                     continue b;
                 }
             }
         }
     }     
     long r=0,c=0;
     for(x=0;x<n;x++)
     {
         if(row[x]==-1)
         ++r;
         if(col[x]==-1)
         ++c;
     }
     System.out.println("Case #"+cs+": "+sum+" "+r+" "+c);
++cs; }}
void merge(long arr[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		long L[] = new long [n1]; 
		long R[] = new long [n2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; 


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] >= R[j]) 
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

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(long arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 
}