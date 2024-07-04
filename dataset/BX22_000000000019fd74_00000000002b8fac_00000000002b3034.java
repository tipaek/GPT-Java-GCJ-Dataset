import java.util.*;
import java.io.*;
/*
 * combine start end middle
 * for each incoming thing, scan to see if it includes anything at the start -> determine its type
 * find the longest in start and end and see if it manages to include all
 * if does, print longest start, middle, and longest end
 */
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			ArrayList <String> start=new ArrayList <String> ();
			ArrayList <String> middle=new ArrayList <String> ();
			ArrayList <String> end=new ArrayList <String> ();
			String longStart="";
			String longEnd="";
			for (int j=0; j<n; j++) {
				String pt=in.next();
				boolean open=false;
				int k=0;
				String tp="";
				while (k<pt.length()) {
					String str=Character.toString(pt.charAt(k));
					if (str.equals ("*")&&open&&tp.length()>0) {
						middle.add(tp);
						tp="";
					}
					else if (str.equals ("*")&&!open&&tp.length()>0) {
						if (tp.length()>longStart.length()) longStart=tp;
						start.add(tp);
						tp="";
						open=true;
					}
					else if (str.equals ("*")&&tp.length()==0){
						open=true;
					}
					else if (!str.equals ("*")) {
						tp+=str;
						if (k==pt.length()-1) {
							if (tp.length()>longEnd.length()) longEnd=tp;
							end.add(tp);
						}
					}
					k++;
				}
			}
			boolean st=checkStart (longStart, start);
			boolean ed=checkEnd (longEnd, end);
			if (st&&ed) {
				StringBuilder sb=new StringBuilder();
				sb.append (longStart);
				for (String temp: middle) sb.append(temp);
				sb.append (longEnd);
				System.out.println("Case #" + i + ": "+sb.toString());
			}
			else {
				System.out.println("Case #" + i + ": *");
			}
		}
	}
	public static boolean checkStart (String longest, ArrayList <String> start) {
		for (String t: start) {
			if (!checkFront(longest, t)) return false;
		}
		return true;
	}
	public static boolean checkEnd (String longest, ArrayList <String> start) {
		for (String t: start) {
			if (!checkBack(longest, t)) return false;
		}
		return true;
	}
	public static boolean checkBack (String l, String s) {
		int lr=l.length()-1;
		int st=s.length()-1;
		while (lr>=0&&st>=0) {
			if (l.charAt(lr)!=s.charAt(st)) return false;
			lr--;
			st--;
		}
		return true;
	}
	public static boolean checkFront (String l, String s) {
		int index=0;
		while (index<s.length()) {
			if (l.charAt(index)!=s.charAt(index)) return false;
			index++;
		}
		return true;
	}
}