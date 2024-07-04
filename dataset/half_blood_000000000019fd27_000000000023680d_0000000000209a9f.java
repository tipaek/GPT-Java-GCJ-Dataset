import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int p = t;
		while(t-->0) {
			StringBuilder str = new StringBuilder(scn.next());
			int n = str.length();
			int a = Character.getNumericValue(str.charAt(0));
			for(int i=0; i<a; i++)
				str = str.insert(0, "(");
			n += a;
			int i=a+1;
			while(i<n) {
				int b = Character.getNumericValue(str.charAt(i));
				if(b<a) {
					for(int j=0; j<a-b; j++)
						str.insert(i, ")");
					i += a-b+1;
					n += a-b;
					a = b;
				}else {
					for(int j=0; j<b-a; j++)
						str.insert(i, "(");
					i += b-a+1;
					n+=b-a;
					a = b;
				}
			}
			for(int j=0; j<a; j++)
				str.insert(n, ")");
			System.out.println("Case #" + (p-t) + ": " + str);
		}
	}
	

}

