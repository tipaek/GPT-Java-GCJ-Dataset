import java.util.*;

class Solution{
	public static String fun(int[] start, int[] end, int n) {
		String str="";
		int i,j;
		int[] c_s = new int[n];
		int[] c_e = new int[n];
		int[] j_s = new int[n];
		int[] j_e = new int[n];
		for (i = 0; i < n; i++) {
			boolean cameron = false;
			boolean jamie = false;
			for (j = 0; j < n; j++) {
				if (c_s[j] != 0 || c_e[j] != 0) {
					if (((c_s[j] <= start[i]) && (start[i] < c_e[j])) || ((c_s[j] < end[i]) && (end[i] <= c_e[j]))) {
						cameron = true;
					}
				} else {
					break;
				}
			}
			if (cameron == false) {
				c_s[j] = start[i];
				c_e[j] = end[i];
				str += "C";
			} else if(cameron == true) {
				for (j = 0; j < n; j++) {
					if (j_s[j] != 0 || j_e[j] != 0) {
						if (((j_s[j] <= start[i]) && (start[i] < j_e[j])) || ((j_s[j] < end[i]) && (end[i] <= j_e[j]))) {
							jamie = true;
						}
					} else {
						break;
					}
				}
				if (jamie == false) {
					j_s[j] = start[i];
					j_e[j] = end[i];
					str += "J";
				} else if(jamie == true) {
					str = "IMPOSSIBLE";
					break;
				}
			}
		}

		return str;
	}
	public static void main(String args[]){
		int t,i,n,j,ca=1;
		int[][] arr;
		String str;
		Scanner s = new Scanner(System.in);
		if(s.hasNext()){
			t = s.nextInt();
			str="";
			while(t>0){
				n = s.nextInt();
				arr = new int[n][2];
				int start[] = new int[n];
				int end[] = new int[n];
				for(i=0;i<n;i++) {
					start[i] = s.nextInt();
					end[i] = s.nextInt();
				}
				
				System.out.printf("Case #%d: %s",ca,fun(start,end,n));
				t--;
				ca++;
			}


		}
	}
}
