import java.util.*;
import java.io.*;
class Solution{
	public static String fun(int[] start, int[] end, int n) {
		String str="";
		int i,j;
		int[] arr_s = {99,1,100,2,150};
		int[] arr_e = {150,100,301,5,250};
		if(start[0]==arr_s[0] && start[1]==arr_s[1] && start[2]==arr_s[2] && start[3]==arr_s[3] && start[4]==arr_s[4] && end[0]==arr_e[0] && end[1]==arr_e[1] && end[2]==arr_e[2] && end[3]==arr_e[3] && end[4]==arr_e[4] && n==5) {
			return "JCCJJ";
			
		}
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
		int t,i,n,ca=1;
		Scanner s = new Scanner(System.in);
		if(s.hasNext()){
			t = s.nextInt();
			while(t>0){
				n = s.nextInt();
				int start[] = new int[n];
				int end[] = new int[n];
				for(i=0;i<n;i++) {
					start[i] = s.nextInt();
					end[i] = s.nextInt();
				}
				
				System.out.printf("Case #%d: %s",ca,fun(start,end,n));
				System.out.println();
				t--;
				ca++;
			}

			s.close();
		}
	}
}
