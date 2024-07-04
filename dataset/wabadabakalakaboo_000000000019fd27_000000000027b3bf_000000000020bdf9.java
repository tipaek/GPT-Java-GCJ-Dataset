import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
	public static void sorte(int arr[], int arr2[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int key2 = arr2[i];
            int j = i - 1; 
            while (j >= 0 && arr[j] > key || (j >= 0 && arr[j] == key && arr2[j] > key2)) { 
                arr[j + 1] = arr[j]; 
                arr2[j+1] = arr2[j];
                j = j - 1; 
            } 
//            while (j >= 0 && arr[j] == key && arr2[j] > arr2[i]) {
//            	arr[j+1] = arr[j];
//            	arr2[j+1] = arr2[j];
//            	j--;
//            }
            arr[j + 1] = key;
            arr2[j+1] = key2;
        } 
    } 
	public static void sort(int[] a1, int[] a2) {
		for (int i = 1; i < a1.length; ++i) {
			int key = a1[i];
			int j = i-1;
			while (j >= 0 && a1[j] > a1[i]) {
				a1[j+1] = a1[j];
//				a2[j+1] = a2[j];
				j--;
			}
//			while (j >= 0 && a1[j] == a1[i] && a2[j] > a2[i]) {
//				a1[j+1] = a1[j];
//				a2[j+1] = a2[j];
//				j--;
//			}
			a1[j+1] = a1[i];
//			a2[j+1] = a2[i];
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
//        	pw.println(Arrays.toString(a1));
//        	pw.println(Arrays.toString(a2));
//        	sort(a1, a2);
        	sorte(a1, a2);
        	for (int i = 0; i < arr.length; i++) {
        		arr[i][0] = a1[i];
        		arr[i][1] = a2[i];
        	}
//        	pw.println(Arrays.toString(a1));
//        	pw.println(Arrays.toString(a2));
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
        				if (arr2[i][0] == arr[j][0] && arr2[i][1] == arr[j][1]) {
        					toPrint.append(ans.substring(j,j+1));
        					break;
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