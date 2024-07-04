import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i=1; i<=t; i++) {
			String str = in.next();
			System.out.println("Case #"+i+": "+ nesting_depth(str));
		}
	}
	public static String nesting_depth(String input){
		int[] S = new int[input.length()];
		String temp = "";
		for(int x=0; x<S.length; x++) {
			S[x] = input.charAt(x) - '0';
		}
		
		int o = S[0];	int n = o;	int k = 0;
		while(n!=0){
			temp = temp + '(';
			--n;
		}
		temp = temp + o;
		for (int i=0 ; i < S.length-1 ; ++i ) {
			if( S[i]>S[i+1])
			{
				n = S[i]-S[i+1];
				o = o-n;
				while(n!=0){
					temp = temp + ')';
					--n;
				} 
				temp = temp + S[i+1];
			}
			else if (S[i]<S[i+1]) 
			{
				n = S[i+1]-S[i];
				o = o+n;
				while(n!=0){
                 temp = temp + '(';
					--n;
				} 
				temp = temp + S[i+1];
			}	
			else {
				temp = temp + S[i];
			}
		}
			n=o;
			while(n!=0){
				temp = temp + ')';
				--n;
			}

			return temp;
	}
}
