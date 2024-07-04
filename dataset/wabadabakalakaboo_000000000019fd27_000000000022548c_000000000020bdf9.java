import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
	static int partition(int arr[], int low, int high, int[] arr2) 
    { 
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
                int temp2 = arr2[i];
                arr2[i] = arr2[j];
                arr2[j] = temp2;
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        int temp2 = arr2[i+1];
        arr2[i+1] = arr2[high];
        arr2[high] = temp2;
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    static void sort(int arr[], int low, int high, int[] arr2) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high, arr2); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1, arr2); 
            sort(arr, pi+1, high, arr2); 
        } 
    }  
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int queries = sc.nextInt();
        int caseNum = 0;
        while (queries --> 0) {
        	caseNum++;
        	int activities = sc.nextInt();
        	int[][] arr = new int[activities][2];
        	int[][] arr2 = new int[activities][2];
        	for (int i = 0; i < activities; i++) {
        		for (int j = 0; j < 2; j++) {
        			int temp = sc.nextInt();
        			arr[i][j] = temp;
        			arr2[i][j] = temp;
        		}
        	}
        	int[] a1 = new int[arr.length];
        	int[] a2 = new int[arr.length];
        	for (int i = 0; i < a1.length; i++) {
        		a1[i] = arr[i][0];
        		a2[i] = arr[i][1];
        	}
        	sort(a1, 0, a1.length-1, a2);
        	for (int i = 0; i < arr.length; i++) {
        		arr[i][0] = a1[i];
        		arr[i][1] = a2[i];
        	}
//        	pw.println(Arrays.deepToString(arr));
        	StringBuilder ans = new StringBuilder("C");
        	boolean possible = true;
        	int cEnd = arr[0][1];
        	int jEnd = 0;
        	hi:
        	for (int i = 1; i < arr.length; i++) {
        		if (cEnd <= arr[i][0]) {
        			ans.append("C");
        			cEnd = arr[i][1];
        		}
        		else if (jEnd <= arr[i][0]) {
        			ans.append("J");
        			jEnd = arr[i][1];
        		}
        		else {
        			possible = false;
        			break hi;
        		}
        	}
//        	pw.println(ans.toString());
        	StringBuilder toPrint = new StringBuilder("");
        	if (!possible) {
        		pw.println("Case #" + caseNum + ": IMPOSSIBLE");
        	}
        	else {
        		for (int i = 0; i < arr2.length; i++) {
        			for (int j = 0; j < arr.length; j++) {
        				if (arr2[i][0] == arr[j][0]) {
        					toPrint.append(ans.substring(j,j+1));
        				}
        			}
        		}
        		pw.println("Case #" + caseNum + ": " + toPrint.toString());
        	}
        }
        
        pw.close();
    }
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
}