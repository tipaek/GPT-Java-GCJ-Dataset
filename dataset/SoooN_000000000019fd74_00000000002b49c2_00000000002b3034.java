import java.util.*;
public class Solution {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int l = 0 ; l < t ; l++) {
			int n = s.nextInt();
			String arr[] = new String[n];
			for(int i = 0 ; i < n ; i++) {
				String temp = s.next();
				arr[i] = temp.substring(1);
			}
			String max = "";
			int flag = 0;
			for(int i = 0 ; i < n ; i++) {
				String temp = arr[i];
				if(temp.length() <= max.length()) {
					int index = max.indexOf(temp);
					if(index == -1) {
						flag = 1;
						break;
					}
				}else {
					int index = temp.indexOf(max);
					if(index == -1) {
						flag = 1;
						break;
					}else {
						max = temp;
					}
				}
			}
			if(flag == 1) {
				System.out.print("Case #" + (l + 1) + ": *");
			}else {
				System.out.print("Case #" + (l + 1) + ": " + max);
			}
		}
	}
}