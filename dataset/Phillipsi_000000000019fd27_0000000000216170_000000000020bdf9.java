import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for(int counter = 1; counter <= n; counter++){
		    st = new StringTokenizer(br.readLine());
		    int m = Integer.parseInt(st.nextToken());
		    int[][] times = new int[m][3];
		    for(int i = 0; i<m; i++){
		        st = new StringTokenizer(br.readLine());
		        times[i][0]=Integer.parseInt(st.nextToken());
		        times[i][1]=Integer.parseInt(st.nextToken());
              times[i][2]=i;
		    }
		    mergeSort(times, 0, m-1);
		    boolean cWorking = false;
		    boolean jWorking = false;
          char[] assigns = new char[m];
          int cEndTime = 0;
		    int jEndTime = 0;
		    String finalString = "";
		    for(int i = 0; i<m; i++){
		        if(cEndTime <= times[i][0])
		            cWorking = false;
		        if(jEndTime <= times[i][0])
		            jWorking = false;
		        if(cWorking){
		            if(jWorking){
		                finalString = "IMPOSSIBLE";
		                break;
		            }else{
		                jWorking = true;
		                jEndTime = times[i][1];
		                assigns[times[i][2]]='J';
		            }
		        }else{
		            cWorking = true;
		            cEndTime = times[i][1];
		            assigns[times[i][2]]='C';
		        }
		    }
          if(!finalString.equals("IMPOSSIBLE")){
            finalString = new String(assigns);
          }
		    System.out.println("Case #"+counter+": " + finalString);
		}
	}
	/**Modified geeksforgeeks merge sort by first entry**/
	static void merge(int arr[][], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 =  r - m; 
      
        int[][] L = new int[n1][3];
        int[][] R = new int[n2][3]; 
      
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) 
        { 
            if (L[i][0] <= R[j][0]) 
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
    static void mergeSort(int arr[][], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = l+(r-l)/2; 
            mergeSort(arr, l, m); 
            mergeSort(arr, m+1, r); 
      
            merge(arr, l, m, r); 
        } 
    }
}
		