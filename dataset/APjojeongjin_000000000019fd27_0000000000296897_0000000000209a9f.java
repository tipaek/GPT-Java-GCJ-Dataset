import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = scan.nextInt();
		
		
		for(int i=0; i<T; i++) {
			int now_size = 0;
			String number = scan.next();
			String answer = "";
			
			for(int j=0; j<number.length(); j++) {
				int num = number.charAt(j)-48;
				if(now_size<num) {
					for(int try_=0; try_<num-now_size; try_++) {
						answer+="(";
					}
					answer+=num;
					now_size = num;
					continue;
				}else if(now_size>num) {
					for(int try_=0; try_<now_size-num; try_++) {
						answer+=")";
					}
					answer+=num;
					now_size = num;
					continue;
				}else {
					answer+=now_size;
					continue;
				}
			}
			
			if(now_size>0) {
				for(int al=0; al<now_size; al++) {
					answer+=")";
				}
			}
			
			System.out.println("Case #" + (i + 1) + ": " + answer);
		}

	}
}
