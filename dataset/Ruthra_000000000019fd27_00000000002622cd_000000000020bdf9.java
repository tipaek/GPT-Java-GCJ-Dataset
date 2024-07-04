public class Solution {
	static Scanner s = new Scanner(System.in);
	static int t = s.nextInt();
	public static void main(String[] args) {
		
		int i, m;
		int[] b = new int[t];
		String[] task = new String[t];
		for (i = 1; i <= t; i++) {
			b[i-1] = s.nextInt();
			int[] c = new int[b[i-1]];
			int[] d = new int[b[i-1]];
			for (m = 0; m < b[i-1]; m++) {
				c[m] = s.nextInt();
				d[m] = s.nextInt();
			}
			String name = sortTime(c, d);
			task[i-1] = name;

		}
		for (i = 0; i < t; i++) {
			System.out.println("Case #" + (i + 1) + ": " + task[i]);
		}
	}

	private static String sortTime(int[] c, int[] d) {
		int i, j, temp = 0, cameroo = 0, james = 0, skip = 0;
		String[] sel = new String[c.length];
		String[] sel2 = new String[c.length];
		String[] sel3 = new String[c.length];
		for (i = 0; i < c.length ; i++) {
			sel[i] = String.valueOf(c[i])+String.valueOf(d[i]);
		}
		for (i = 0; i < c.length ; i++) {
			for (j = 0; j < c.length - 1; j++) {
				if (c[j] > c[j + 1]) {
					temp = c[j];
					c[j] = c[j + 1];
					c[j + 1] = temp;
					temp = d[j];
					d[j] = d[j + 1];
					d[j + 1] = temp;
				}
			}
		}
		
		String name = "";
		for (i = 0; i < c.length; i++) {
			if (i == 0) {
				cameroo = d[i];
				sel2[i] = String.valueOf(c[i])+String.valueOf(d[i]);
				sel3[i] = "C";
				continue;
			}
			if (cameroo <= c[i]) {
				cameroo = d[i];
				sel2[i] = String.valueOf(c[i])+String.valueOf(d[i]);
				sel3[i] = "C";
				continue;
			}
			if (james == 0) {
				james = d[i];
				sel2[i] = String.valueOf(c[i])+String.valueOf(d[i]);
				sel3[i] = "J";
				continue;
			}
			if (james <= c[i]) {
				james = d[i];
				sel2[i] = String.valueOf(c[i])+String.valueOf(d[i]);
				sel3[i] = "J";
				continue;
			}
			skip = 1;
			break;
		}
		if (skip == 1) {
			name = "IMPOSSIBLE";
		}else{
			for(i=0;i<c.length;i++){
				for(j=0;j<c.length;j++){
					if(sel2[j].equals(sel[i])){
						name += sel3[j];
					}
				}
			}
		}
		return name;
	}
}