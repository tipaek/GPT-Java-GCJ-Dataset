/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    
    
    
    // Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(int arr[], int l, int m, int r,int arrk[]) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 
		int Lk[] = new int [n1]; 
		int Rk[] = new int [n2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i){ 
			L[i] = arr[l + i];
				Lk[i] = arrk[l + i];}
		for (int j=0; j<n2; ++j){ 
			R[j] = arr[m + 1+ j];
		    	Rk[j] = arrk[m + 1+ j];
		} 


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i];
					arrk[k] = Lk[i];
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
					arrk[k] = Rk[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i];
			arrk[k] = Lk[i];
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
				arrk[k] = Rk[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(int arr[], int l, int r,int arrk[]) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m,arrk); 
			sort(arr , m+1, r,arrk); 

			// Merge the sorted halves 
			merge(arr, l, m, r,arrk); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

    
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i =0;i<t;i++){
		    int n = sc.nextInt();
		    int []arrs = new int[n];
		     int []arre = new int[n];
		    for(int j=0;j<n;j++){
		        int s = sc.nextInt();
		         int e = sc.nextInt();
		          arrs[j] = s;
		          arre[j] = e;
		        
		    }
		    
		    //	Map<Integer, Integer> hm1 = sortByValue(hm); 
		    	Solution ob = new Solution(); 
		ob.sort(arrs, 0, arre.length-1,arre); 
         int c=0,j=0;
         boolean posible = true;
         ArrayList<String> sol = new ArrayList<String>();
		// print the sorted hashmap 
		for (int x=0;x<n;x++) { 
		//	System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue()); 
		if(c>arrs[x]&&j>arrs[x]){
		    
		    posible = false;
		    
		}else{
		    if(c<=arrs[x]){
		        c = arre[x];
		        sol.add("C");
		    }else{
		         j = arre[x];
		        sol.add("J");
		    }
		    
		    
		    
		}
		} 
		    
		
		
		if(posible){
		    System.out.print("Case #" + (i + 1) + ": ");
		    for(int k =0;k<n;k++)
		    System.out.print(sol.get(k));
		    
		}else{
		    System.out.print("Case #" + (i + 1) + ": "+"IMPOSSIBLE");
		}
		System.out.println();
	}
}}
