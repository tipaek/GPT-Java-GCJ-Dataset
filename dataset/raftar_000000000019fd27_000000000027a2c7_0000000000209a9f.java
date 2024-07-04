import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution{

     public static void main(String []args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		int start = 0;
		int end = 0;
		int num = 0;
		StringBuilder answerStr = new StringBuilder(); 
		for(int i=1; i<=T; i++) {
			start = 0;
			answerStr = new StringBuilder(); 
			String S = in.next();
			for(int j = 0; j< S.length(); j++) {
				num = Integer.parseInt(String.valueOf(S.charAt(j)));
				if(start == num) {
					answerStr.append(String.valueOf(num));
				}
				else if(start > num) {
					for(int k = 0; k < (start - num); k++) {
						answerStr.append(')');
					}
					start = num;
					answerStr.append(String.valueOf(num));
				}
				else if(num > start) {
					for(int k = 0; k < (num - start); k++) {
						answerStr.append('(');
					}
					start = num;
					answerStr.append(String.valueOf(num));
				}
			}
			if(start > 0) {
				for(int k = 0; k < start; k++) {
					answerStr.append(')');
				}
			}
			System.out.print("Case #"+ i + ": " + answerStr.toString() + "\n");
		}
     }
}