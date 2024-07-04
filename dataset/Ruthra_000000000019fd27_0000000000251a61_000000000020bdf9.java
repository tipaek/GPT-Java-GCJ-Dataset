import java.util.Scanner;

public class Solution {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t = s.nextInt();
		int i, m;
		int[] b = new int[t];
		String[] task = new String[t];
		for (i = 0; i < t; i++) {
			b[i] = s.nextInt();
			int[] c = new int[b[i]];
			int[] d = new int[b[i]];
			for (m = 0; m < b[i]; m++) {
				c[m] = s.nextInt();
				d[m] = s.nextInt();
			}
			String name = sortTime(c, d, i);
			task[i] = name;
		}
		for (i = 0; i < t; i++) {
			System.out.println("Case #" + (i + 1) + ": " + task[i]);
		}
	}

	private static String sortTime(int[] c, int[] d, int caseNo) {
		int i, j, temp,cameroo=0,james=0,skip=0;
		String name ="";
		for (i = 0; i < c.length; i++) {
			for (j = 0; j < c.length-1; j++) {
				if (c[j] > c[j + 1]) {
					temp = c[j];
					c[j] = c[j + 1];
					c[j + 1] = temp;
					temp = d[j];
					d[j] = d[j+1];
					d[j+1] = temp;
				}
			}

		}
		for(i=0;i<c.length;i++){
			if(i==0){
				name += "C";
				cameroo = d[i];
				continue;
			}if(cameroo <= c[i]){
				name += "C";
				cameroo = d[i];
				continue;
			}if(james == 0){
				name += "J";
				james = d[i];
				continue;
			}if(james <= c[i]){
				name += "J";
				james = d[i];
				continue;
			}skip=1;
			break;
		}
		if(skip==1){
			name = "IMPOSSIBLE";
		}
		return name;
	}
}