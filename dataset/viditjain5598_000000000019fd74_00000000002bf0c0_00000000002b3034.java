import java.util.*;
import java.math.*;

public class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int tt=1; tt<=T; tt++){
			int n = in.nextInt();
			String meh = in.nextLine();
			String[] strs = new String[n];
			for(int i=0; i<n; i++){
				strs[i] = in.nextLine();
			}
			// for (int i=0; i<n; i++) {
			// 	Arrays.sort(strs);
			// 	System.out.println(strs[i]);
			// }
			Arrays.sort(strs);
			String answer = "";
			// StringBuilder left_sb = new StringBuilder();
			// StringBuilder right_sb = new StringBuilder();
			for(int i=0; i<n; i++){
				if(i==0 && strs[i].charAt(0)=='*'){
					answer = strs[0].substring(1);
					for(int j=1; j<n; j++){
						if(!answer.contains(strs[j].substring(1))){
							answer = "*";
							break;
						} 
					}
					break;
				}
				// String[] m = strs[i].split("*", -1);
			}
			System.out.println("Case #" + tt + ": " + answer);
		}
	}
}