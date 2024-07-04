import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static class SubStringStar {
		public String start;
		public boolean hasStart = true;
		public ArrayList<String> middle;
		public boolean hasMiddle = false;
		public String end;
		public boolean hasEnd = true;
	}
	
	public static String isPossible(ArrayList<String> start, ArrayList<String> end, ArrayList<ArrayList<String>> middles) {
		
		StringBuilder sb = new StringBuilder();
		if(start.size() > 0) {
			start.sort(Comparator.comparing(s -> s.length()));
			int i=0;
			while(i<start.size()-2 && start.get(i+1).indexOf(start.get(i)) == 0) {
				i++;
			}
			if(i==start.size()-2) {
				sb.append(start.get(start.size()-1));
			} else {
				return "*";
			}
		}
		// TODO middle
		if(end.size() > 0) {
			end.sort(Comparator.comparing(s-> s.length()));
			int i=0;
			boolean works = true;
			while(i<end.size()-1 && works) {
				int j=end.get(i+1).length()-1;
				int k=end.get(i).length()-1;
				while(k>=0) {
					if(end.get(i).charAt(k) == end.get(i+1).charAt(j)) {
						j--;
						k--;
					} else {
						works = false;
						break;
					}
				}
				i++;
			}
			if(works) {
				sb.append(end.get(end.size()-1));
			} else {
				return "*";
			}
		}
		if(sb.length() > 10000) {
			return "*";
		}
		return sb.toString();
	}
	
	public static SubStringStar splitString(String s) {
		SubStringStar substring = new SubStringStar();
		String[] s2 = s.split("\\*");
		if(s2.length>=1) {
			if(s2[0].equals("")) {
				substring.hasStart=false;
			} else {
				substring.start = s2[0];
			}
			if(s2[s2.length-1].equals("")) {
				substring.hasEnd=false;
			} else {
				substring.end = s2[s2.length-1];
			}
		} else {
			substring.hasEnd = false;
			substring.hasMiddle = false;
			substring.hasStart = false;
		}
		return substring;
	}

    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
    	PrintWriter out = new PrintWriter(System.out);
    	int tcs = sc.nextInt();
    	
    	
    	for (int tc = 1; tc <= tcs; tc++) {
    		int n = sc.nextInt();
    		ArrayList<String> start = new ArrayList<>();
    		ArrayList<String> end = new ArrayList<>();
    		ArrayList<ArrayList<String>> middles = new ArrayList<ArrayList<String>>();
    		
    		for(int j=0; j<n; j++) {
    			SubStringStar s1 = splitString(sc.next());
    			if(s1.hasStart) {
    				start.add(s1.start);
    			}
    			if(s1.hasEnd) {
    				end.add(s1.end);
    			}
    			if(s1.hasMiddle) {
    				middles.add(s1.middle);
    			}
    		}
    		out.printf("Case #%d: %s\n", tc, isPossible(start,end,middles));
    	}
    	out.close();
    	
	}

}