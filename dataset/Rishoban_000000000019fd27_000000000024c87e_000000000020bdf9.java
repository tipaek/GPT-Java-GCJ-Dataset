import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.List;

public class Solution {
	
	public static String shedlues(int[][]arr, int len) {
		
		int[][] arrClone = arr.clone();
		
		java.util.Arrays.sort(arr, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		
		List f = new ArrayList();
		for(int[] array:arr) {
			f.add(array);
		}
		
		
		String out = "CJ";
		int occupyC = 0;
		int occupyJ = 1;
		
		
		for(int g = 2; g < len; g++) {
			int min = arr[occupyJ][1];
			
			String addes = "J";
			if(arr[occupyC][1] < arr[occupyJ][1]) {
				min = arr[occupyC][1];
				occupyC = g;
				addes = "C";
			}else {
				occupyJ = g;
			}
			if(min > arr[g][0]) {
				return "IMPOSSIBLE";
			}else {
				
				out = out + addes;
				
			}	
		}
		String original = "";
		for(int[] sea:arrClone) {
			int h = f.indexOf(sea);
			original = original + out.charAt(h);
		}
		
		
		return original;
	}
	
	
	

	public static void main(String[] args) {

		
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int t = in.nextInt();
		 for (int i = 1; i <= t; ++i) {
			 int n = in.nextInt();
			 int[][] arr = new int[n][2];
		      for (int a = 0; a < n; a++) {
		      	for (int b = 0; b < 2; b++) {
		      		arr[a][b] = in.nextInt();
		      	}
		      }System.out.println("Case #" + i + ": " + shedlues(arr,n));
		 }

	}

}
