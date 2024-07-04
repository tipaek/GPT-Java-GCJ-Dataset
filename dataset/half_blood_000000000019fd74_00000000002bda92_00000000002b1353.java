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
			int n = scn.nextInt();
			int k = (int)Math.sqrt((n-1)*2);
			System.out.println("Case #" + (p-t) + ":");
			if(k*k+1 > (n-1)*2) 
				k = k-1;
				System.out.println("1 1");
				for(int i=1; i<=k; i++) {
					System.out.println((i+1) + " 2");
				}
			int c = n-1 - k*(k+1)/2;
			for(int i=k+1; i<=k+c; i++)
				System.out.println(i + " 1");
			
		}
	}
	
 
}
