
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		
	//	System.out.println("hi");
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); 
		for (int i = 0; i < t; ++i) {
			int length = in.nextInt();
			int[][] a = new int[length][length];
			for (int j = 0; j < length; j++) {
				for (int k = 0; k < length; k++) {
					a[j][k] = in.nextInt();
				}
			}
			int trace = trace (a);
			int counter = 0;

			for (int j = 0; j < length; j++) {
				HashSet <Integer> mySet = new HashSet <Integer> ();
				for (int k = 0; k < length; k++) {
					if (mySet.contains(a[j][k])){
						counter++;
						break;
						
					} else {
						mySet.add(a[j][k]);
					}
				}
			}	
			
			int rows = counter;
			counter = 0;
		   
			for (int j = 0; j < length; j++) {
				HashSet <Integer> mySet = new HashSet <Integer> ();
				for (int k = 0; k < length; k++) {
					if (mySet.contains(a[k][j])){
						counter++;
						break;
						
					} else {
						mySet.add(a[k][j]);
					}
				}
			}	
			int cols = counter;
			
			
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + rows + " " + cols);

			
			
			
		}
			
			
		
		
	}
	public static int trace (int [] [] a) {
		int counter = 0;
		for (int i = 0; i < a.length; i++) {
			counter += a[i][i];
			
		}
		return counter;
	}
	

}