/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void printSteps(int x, int y, String mov, int t) {
		for(int i=0;i<mov.length();i++){
			// System.out.println(x + " " + y + " " + i + " " + mov.charAt(i));
			if(Math.abs(x)+Math.abs(y)<=i){
				System.out.println("Case #" + t + ": " + i);
				return;
			}
			if(mov.charAt(i) == 'S'){
				y--;
			}
			else if(mov.charAt(i) == 'N'){
				y++;
			}
			else if(mov.charAt(i) == 'E'){
				x++;
			}
			else{
				x--;
			}
			if(Math.abs(x)+Math.abs(y)<=i+1){
				System.out.println("Case #" + t + ": " + (i+1));
				return;
			}

		}
		System.out.println("Case #" + t + ": IMPOSSIBLE");
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			String mov = sc.nextLine();
			mov = mov.trim();
			// System.out.println(mov);
			printSteps(x, y, mov, i);
		}
	}
}