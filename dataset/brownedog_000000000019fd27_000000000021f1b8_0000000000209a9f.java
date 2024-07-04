import java.util.*;
import java.io.*;

public class Solution {
public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); //number of test cases

		for (int i = 1; i <= t; ++i) {
		String n = in.next();
		String answer = "";
		for (int j = 0; j< n.length(); j++) {
			String minians = "";
			int num = (n.charAt(j)-'0');

			if(j==0) {
				
			for(int k = 0; k < num; k++) {
				minians += '(';
			}
			}

			minians = minians + num;

			if((j+1)< n.length()) { //check we aren't at the end
				if(num < (n.charAt(j+1)-'0')) { //need opening
					for(int k = 0; k < ((n.charAt(j+1)-'0')-num); k++) {
						minians += '(';
					}
				}

				if(num > (n.charAt(j+1)-'0')) { // need closing
					for(int k = 0; k < (num- (n.charAt(j+1)-'0')); k++) {
						minians += ')';
					}
				}
			}
			
			if(j== (n.length()-1)) {
				for(int k = 0; k < num; k++) {
					minians += ')';
				}
			}
			answer = answer + minians ;
		}
		System.out.println("Case #" + i + ": " + answer);
		}
	}
}