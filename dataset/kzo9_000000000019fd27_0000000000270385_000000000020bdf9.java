
import java.util.ArrayList;
import java.util.Collections;
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
		
		
		for(int i=0; i<kazu; i++) {
			int n = sc.nextInt();
			int[] sch = new int[24*60];
			for(int j=0; j<(24*60); j++) sch[j] = 0;
			int flag = 0;
			StringBuffer result = new StringBuffer();
			
			int[][] acts = new int[n][3];
			ArrayList array = new ArrayList<Integer>();
			for(int j=0; j<n; j++) {
				//for(int k=0; k<2; k++) {
					acts[j][0] = sc.nextInt();
					acts[j][1] = sc.nextInt();
					acts[j][2] = j;
				//}	
				
				array.add(acts[j][0]);
			}
			Collections.sort(array);
			for(int j=0; j<n; j++) {
				for(int k=0;k<n;k++) {
					if(array.get(j).equals(acts[k][0])) {
						int[] temp = new int[3];
						temp[0] = acts[j][0];
						temp[1] = acts[j][1];
						temp[2] = acts[j][2];
						acts[j][0] = acts[k][0];
						acts[j][1] = acts[k][1];
						acts[j][2] = acts[k][2];
						acts[k][0] =temp[0];
						acts[k][1] =temp[1];
						acts[k][2] =temp[2];
					}
				}
				
				
			}
			
			for(int j=0; j<n; j++) {
				int x = acts[j][0];
				int y = acts[j][1];
				int z = acts[j][2];
				flag = 0;
				
				for(int k=x; k<y;k++) {
					sch[k] ++;
					if(sch[k] == 3) {
						flag = 3;
						break;
					}
					if(sch[k] == 2) flag = 2;
				}
				if(flag == 3) break;
				if(flag == 2) result.append("J");
				if(flag == 0) result.append("C");
			}
			
			if(flag ==3) {
				result = new StringBuffer("IMPOSSIBLE");
				System.out.println("Case #"+ (i+1) + ": " + result);
			}
			else {
				StringBuffer result2 = new StringBuffer();
				for(int j=0; j<n; j++) {
					for(int k=0;k<n;k++) {
						if(j == acts[k][2]) result2.append(result.charAt(k));
					}
				}
				
				System.out.println("Case #"+ (i+1) + ": " + result2);
			}
		}
		
	}
	
}