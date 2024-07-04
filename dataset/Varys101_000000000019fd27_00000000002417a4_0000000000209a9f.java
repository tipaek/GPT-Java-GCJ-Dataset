//string of S digits 
//nesting -every parenthesis in their nesting 
//          matches || nesting is empty
//nesting depth(p)- number of matching parenthesis m with p included
//
//((((4))))- 4 is depth so digits match their nesting depth
//min length - string generated should be of min length
//output - generate string
//
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int x = 1; x <= t; x++) {

			String s=in.nextLine();
			int ar[]=new int[s.length()];

			for (int i = 0; i < ar.length; i++) {
				ar[i]=Character.getNumericValue(s.charAt(i));
			}																		
			/* for (int i = 0; i < ar.length; i++) {
		System.out.print(ar[i]+" | ");
	}
      System.out.println();*/
			
			int curptr=0;//counts no of parenthesis

			for (int i = 0; i < ar.length; i++) {
				if(i==0) {
					int tem=ar[i];
					while(tem-->0) {
						s="("+s;
						curptr++;
					}
					continue;
				}

				int diff=ar[i]-ar[i-1];
				
				//if +ve						// 0((2)1), (((3))1(2)), ((((4)))), ((2))((2))(1)				
				if(diff>0) {											// 021
					int temp=diff;
					//System.out.println(diff+" | "+i);
					while(temp-->0) {
						s=s.substring(0,i+curptr)+"("+s.substring(i+curptr);
						curptr++;
					}
					continue;
				}
				
				//if negative
				if(diff<0) {
					int temp=-diff;
					//System.out.println(diff+" | "+i);
					while(temp-->0) {
						s=s.substring(0,i+curptr)+")"+s.substring(i+curptr);
						curptr++;
					}
				}

			}
			//add remaining brackets
			int br=0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='(')
					br++;
				else if(s.charAt(i)==')')
					br--;
			}
			while(br-->0) {
				s=s+")";
			}

			// System.out.println(s);



			System.out.println("Case #" + x + ": " + (s) );
		}
	}
}