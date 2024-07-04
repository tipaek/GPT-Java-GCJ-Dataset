import java.util.*;
import java.io.*;

public class Solution {
	
	public static int sum (ArrayList<Integer> arr) {
		int sum = 0;
		for (int i = 0; i < arr.size(); i++) 
			sum += arr.get(i);
		
		return sum;
	}
	
	public static void main (String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = in.nextInt();
		in.nextLine();
		for (int i = 0; i < t; i++) {
			String nums = in.nextLine();
			ArrayList<Integer> arr = new ArrayList<Integer>();

			int[] par = new int[nums.length() + 1];
			
			for (int a = 0; a < nums.length(); a++) {
				arr.add(Integer.parseInt(nums.substring(a, a+1)));
			}
			
			arr.add(0, 0);
			arr.add(0);
			ArrayList<Integer> arr1 = new ArrayList<Integer>(arr);
			while (sum(arr) != 0) {
				for (int check = 0; check < arr.size() - 1; check++) {
					if (arr.get(check) == 0 && arr.get(check + 1) != 0) 
						par[check] += 1;
					if (arr.get(check) != 0 && arr.get(check + 1) == 0) 
						par[check] += -1;
					
					arr.set(check, Math.max(0, arr.get(check) - 1));
				}
			}
			
			System.out.print("Case #" + (i+1) + ": ");
			for (int a = 0; a < nums.length(); a++) {
				if (par[a] > 0) {
					for (int p = 0; p < par[a]; p++)
						System.out.print("(");
				}
				if (par[a] < 0) {
					for (int p = 0; p > par[a]; p--)
						System.out.print(")");
				}
				System.out.print(arr1.get(a+1));
			}
			for (int p = 0; p > par[nums.length()]; p--)
				System.out.print(")");
			System.out.println();
		}
		
	}
}	
