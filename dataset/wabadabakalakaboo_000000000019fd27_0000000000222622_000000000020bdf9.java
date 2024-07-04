import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
	public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
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
        	sortbyColumn(arr, 0);
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