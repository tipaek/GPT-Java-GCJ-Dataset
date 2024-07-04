
import java.util.*;
public class Solution {

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int k=0;k<T;k++)
		{
			int x=k+1;
			int n=s.nextInt();
			s.nextLine();
			String[] arr=new String[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=s.nextLine();
				//System.out.println("before val at "+i+" "+arr[i]);
			}
			
			int[] arr1=new int[n];
			for(int i=0;i<n;i++)
				arr1[i]=arr[i].length();
			//for(int i=0;i<n;i++)
				//System.out.println("before "+arr[i]);
		    sort(arr,arr1,0,n-1);
		    //for(int i=0;i<n;i++)
				//System.out.println("after "+arr[i]);
			String ans="";
			int c=0;
			for(int i=0;i<n-1;i++)
			{
				String a=arr[i];
				String b=arr[i+1];
				if(checkvalid(a,b))
				{
					ans=b;
					//System.out.println("in true i="+i+" ans= "+ans);
					c=0;
				}
				else
				{
					//System.out.println("in flase i="+i+" ans= "+ans);
					c=1;
					ans="*";
					System.out.println("Case #"+x+": "+ans);
					break;
				}
			}
			if(c==0)
			{
			  String ans_f="";
			  for(int i=1;i<ans.length();i++)
				  ans_f+=ans.charAt(i);
			  System.out.println("Case #"+x+": "+ans_f);
			}
			
			
		}
	}

	private static boolean checkvalid(String a, String b) {
		int a1=0;
		//System.out.println(a+" "+b);
		int j=b.length()-1;
		for(int i=a.length()-1;i>=1;i--)
		{
			if(a.charAt(i)==b.charAt(j))
			{
				j--;
				//System.out.println(" match"+a.charAt(i)+" b="+b.charAt(i));
				a1=0;
			}
			else
			{
				//System.out.println("not match"+a.charAt(i)+" b="+b.charAt(i));
				a1=1;
				break;
			}
		}
		if(a1==0)
			return true;
		else
			return false;
	}

	private static void sort(String[] arr, int[] arr1,int low, int high) {
		
		if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr,arr1, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr,arr1, low, pi-1); 
            sort(arr,arr1, pi+1, high); 
        } 
	}

	private static int partition(String[] arr1,int[] arr, int low, int high) {
		int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        String temp1=arr1[i+1];
        arr1[i+1] = arr1[high]; 
        arr1[high] = temp1;
        
        return i+1; 

	}
}
