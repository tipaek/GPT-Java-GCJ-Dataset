import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		int tcase = 1;
		while(t-- > 0) {
			int n = Integer.valueOf(br.readLine());
			int[] start = new int[n];
			int[] end = new int[n];
			int[] allocationCam = new int[1440];
			Arrays.fill(allocationCam, 0);
			int[][] task = new int[n][2];
			StringBuilder out = new StringBuilder();
			for(int i=0; i<n; i++) {
				String[] s = br.readLine().split(" ");
				start[i] = Integer.valueOf(s[0]);
				end[i] = Integer.valueOf(s[1]);
				task[i][0] = start[i];
				task[i][1] = end[i];
			}
			
			Arrays.sort(start);
			Arrays.sort(end);
			int k,j,i;
			i=j=k=0;
			boolean flag = true;
			while(i<n && j<n) {
				if(start[i]<end[j]) {
					i++;
					k++;
					if(k>2) {
						System.out.println("Case #"+tcase+": IMPOSSIBLE");
						flag = false;
						break;
					}
				}else {
					j++;
					k--;
				}
			}
			
			if(flag) {
				for(i=0; i<n; i++) {
					boolean assignToJam = false;
					for(j = task[i][0]; j<task[i][1]; j++) {
						if(allocationCam[j]==1) {
							assignToJam = true;
							break;
						}
					}
					if(assignToJam) {
						out.append("C");
					}else {
						out.append("J");
						for(j = task[i][0]; j<task[i][1]; j++) {
							allocationCam[j]=1;
						}
					}
				}
				System.out.println("Case #"+tcase+": "+out.toString());
			}
			
			tcase++;
		}
	}
}
