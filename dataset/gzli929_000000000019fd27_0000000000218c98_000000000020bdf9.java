import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static int[] nums;
	static int len;

	public static void main(String[] args) {
		int tC = sc.nextInt();
		//sc.nextLine();

		for (int t = 1; t <= tC; t++) {
			
			System.out.print("Case #" + t + ": ");
			int d = sc.nextInt();
			
			nums = new int[2*d];
			for(int i = 0; i < d; i++) {
				nums[2*i] = sc.nextInt();
				nums[2*i+1] = sc.nextInt();
			}
			boolean a = exp(new int[2*d],new int[2*d],0,0,"",d);

			if(!a) {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
	
	public static boolean exp(int[] c, int[] j, int cL, int jL, String print, int depth) {
		if(depth == 0) {
			System.out.println(print);
			return true;
		}
		
		int start = nums[nums.length-2*depth];
		int end = nums[nums.length-2*depth+1];
		boolean yes = true;
		
		for(int i = 0; i < cL; i+=2) {
			if(start < c[i+1] && end > c[i]){
				yes = false;
				break;
			}
		}
		
		boolean worked = false;
		
		if(yes) {
			c[cL] = start;
			c[cL+1] = end;
			cL+=2;
			print += "C";
			worked = exp(c,j,cL,jL,print,depth-1);
		}
		
		if(worked) {
			return true;
		}
		
		yes = true;
		
		for(int i = 0; i < jL; i+=2) {
			if(start < j[i+1] && end > j[i]){
				yes = false;
				break;
			}
		}
		
		if(yes) {
			j[jL] = start;
			j[jL+1] = end;
			jL+=2;
			print += "J";
			worked = exp(c,j,cL,jL,print,depth-1);
		}
		
		
		return worked;
	}
}
