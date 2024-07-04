import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader (System.in));
		int no_test;
		String notest;
		notest = input.readLine();
		if(notest == null)
			return;
		no_test = Integer.parseInt(notest);
		int k=0;
		while(k < no_test){
			int pren = 0;
			int prev = 0;
			int cur;
			String str = input.readLine();
			//System.out.println(str.length());
			String ans = "";
			for(int i=0;i<str.length();i++){
				cur = Integer.parseInt(Character.toString(str.charAt(i)));
				if(prev < cur){
					for(int j=0;j<cur-prev;j++){
						ans += '(';
					}
					pren += (cur-prev);
					ans += Integer.toString(cur);
					prev = cur;
				}
				else if(prev > cur){
					for(int j=0; j< prev-cur;j++){
						ans += ')';
					}
					pren -= (prev-cur);
					ans += Integer.toString(cur);
					prev = cur;
				}
				else{
					ans += Integer.toString(cur);
					prev = cur;
				}
			}
			if(pren != 0){
				for(int j=0;j<pren;j++){
					ans += ')';
				}
			}
			System.out.println("Case #"+Integer.toString(k+1) + ": "+ans);
			k++;
		}
	}
	//private static String solve(double a){
	//	return "";
	//}
}