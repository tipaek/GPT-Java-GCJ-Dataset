// Working program with FastReader 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Arrays; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

public class Solution 
{ 

    static int partition(int arr[], int low, int high,int brr[],int crr[]) 
    { 
        int pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
                 temp = brr[i]; 
                brr[i] = brr[j]; 
                brr[j] = temp; 
                 temp = crr[i]; 
                crr[i] = crr[j]; 
                crr[j] = temp; 
                
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
         temp = brr[i+1]; 
        brr[i+1] = brr[high]; 
        brr[high] = temp; 
         temp = crr[i+1]; 
        crr[i+1] = crr[high]; 
        crr[high] = temp; 

  
        return i+1; 
    } 
  
    static void sort(int arr[], int low, int high,int brr[],int crr[]) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high,brr,crr); 
            sort(arr, low, pi-1,brr,crr); 
            sort(arr, pi+1, high,brr,crr); 
        } 
    } 
    public static void main(String[] args) 
	{ 
		FastReader sc=new FastReader(); 
        // int arr[]={4,1,3,6};
        // int brr[]={2,1,9,3};
        // sort(arr,0,3,brr);
        // for(int i:arr) System.out.print(i+" ");
        // System.out.println();
        // for(int i:brr) System.out.print(i+" ");
        int test=sc.nextInt();
        for(int t=1;t<=test;t++){
            int n=sc.nextInt();
            boolean flag=false;
            int start[]=new int[n+1];
            int end[]=new int[n+1];
            int index[]=new int[n+1];
            char ans[]=new char[n+1];
            for(int i=1;i<=n;i++){
                start[i]=sc.nextInt();
                end[i]=sc.nextInt();
                index[i]=i;
            }
            sort(start,1,n,end,index);
            int c=-1;
            int j=-1;
            for(int i=1;i<=n;i++){
                int s=start[i];
                int e=end[i];
                int in=index[i];

                if(c<=s){
                    ans[in]='C';
                    c=e;
                }
                else if(j<=s){
                    ans[in]='J';
                    j=e;
                }
                else{
                    flag=true;
                    break;
                }
            }
            System.out.print("Case #"+t+": ");
            if(flag) System.out.println("IMPOSSIBLE");
            else{
                for(int i=1;i<=n;i++) System.out.print(ans[i]);
                System.out.println();
            }
        }
	
	} 
	
	
	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 

		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 


} 

            