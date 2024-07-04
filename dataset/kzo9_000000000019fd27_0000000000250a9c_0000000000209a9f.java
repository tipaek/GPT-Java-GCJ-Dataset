
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		new Solver().run();
	}

}

class Solver{
	Scanner sc;

	public void run() {
		sc = new Scanner(System.in);
		
		int kazu = sc.nextInt();
		
		String pre = "(";
		String pos = ")";
		
		for(int i=0; i<kazu; i++) {
			
			int depth = 0;
			StringBuffer result = new StringBuffer();
			String str = sc.next();int x = str.length();
			int nums[] = new int[x];
			for(int nunu=0; nunu<x; nunu++) {
				nums[nunu] = Integer.parseInt(str.substring(nunu, nunu+1));
			}
			
			for(int k=0; k<x+1; k++) {
				if(k == x) {
					int sa = depth;
					for(int j=0;j<sa; j++) result.append(pos);
					break;
				}
				
				int sa = depth - nums[k]; depth = nums[k];
				int saabs = Math.abs(sa);
								
				if(sa < 0) {
					for(int j=0;j<saabs; j++) result.append(pre);
				}if(0 < sa){
					for(int j=0;j<saabs; j++) result.append(pos);
				}
				
				result.append(nums[k]);
			}
			
			
			System.out.println("Case #"+ (i+1) + ": " + result);
		}
		
	}
	
}