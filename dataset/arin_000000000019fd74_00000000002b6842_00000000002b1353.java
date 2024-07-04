
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			System.out.println("Case #" + i + ":");
			int row=1;
			int col=1;
			System.out.println(row + " " + col);
			n--;
			if(n>0) {
				System.out.println((row + 1) + " " + col);
			    row++;
			    n--;
			}
			
			while(n>0) {
				if(n>=3) {
					System.out.println((row+1) + " " + (col+1));
					System.out.println(row + " " + col);
					n=n-3;
					
				} else if(n==2)
				{
					System.out.println((row+1) + " " + (col+1));
					n=n-2;
				} else if(n==1) {
					System.out.println((row+1) + " " + col);
					n=n-1;
				}
				
			}
		}
    }
}
