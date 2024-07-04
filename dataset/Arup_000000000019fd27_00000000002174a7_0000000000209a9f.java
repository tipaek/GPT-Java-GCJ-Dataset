import java.util.*;

public class Solution {

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		
		for (int loop=1; loop<=nC; loop++) {
		
			char[] line = stdin.next().toCharArray();
			
			int n = line.length;
			int[] nums = new int[n];
			for (int i=0; i<n; i++)
				nums[i] = line[i] - '0';
				
			System.out.println("Case #"+loop+": ");
			int cur = 0;
			
			// Go to each #.
			for (int i=0; i<n; i++) {
			
				// Need to add greedily.
				if (nums[i] > cur) {
					for (int z=cur; z<nums[i]; z++) System.out.print("(");
				}
				
				// Need to close greedily.
				else if (nums[i] < cur) {
					for (int z=nums[i]; z<cur; z++) System.out.print(")");
				}
				
				// Print our number and update cur.
				System.out.print(nums[i]);
				cur = nums[i];	
			}
			
			// Close off everything.
			for (int i=0; i<cur; i++)
				System.out.print(")");
			System.out.println();
		}
	}
}