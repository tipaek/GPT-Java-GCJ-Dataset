import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test=scn.nextInt();while(test-->0){
		int u = scn.nextInt();
		int[] chr = new int[26];
		Arrays.fill(chr, 10);
		for (int i = 0; i < 10000; i++) {
			int v = scn.nextInt();
			String s = scn.next();

			if (s.length() == 1) {
				chr[s.charAt(0) - 'A'] = Math.min(chr[s.charAt(0) - 'A'], v);
			}
		}
		char []ans=new char[10];
		for(int i=0;i<26;i++){
			if(chr[i]!=Integer.MAX_VALUE){
				ans[chr[i]-1]=(char)(i+'A');
			}
		}
		for(int i=0;i<ans.length;i++){
			System.out.print(ans[i]);
		}
		System.out.println();}
	}

}
