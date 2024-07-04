import java.util.*;
import java.io.*;
public class PatternMatching {
	public static void main(String [] args) throws IOException{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(cin.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(cin.readLine());
			ArrayList<String> beg = new ArrayList<>();
			ArrayList<String> end = new ArrayList<>();
			for(int n = 0; n < N; n++) {
				String s = cin.readLine();
				if(s.charAt(0) == '*')
					end.add(s.substring(1));
				else if(s.charAt(s.length()-1) == '*')
					beg.add(s.substring(0,s.length()-1));
				else {
					beg.add(s.substring(0,s.indexOf('*')));
					end.add(s.substring(s.indexOf('*') +1));
				}
			}
			beg.sort((s1, s2) -> s1.length() - s2.length());
			end.sort((s1, s2) -> s1.length() - s2.length());
			boolean breakCase = true;
			while(beg.size() > 1 && breakCase) {
				String last = beg.get(beg.size()-1);
				String first = beg.get(0);
				if(last.indexOf(first) == 0)
					beg.remove(0);
				else breakCase = false;
			}
			while(end.size() > 1 && breakCase) {
				String last = end.get(end.size()-1);
				String first = end.get(0);
				if(last.lastIndexOf(first) == last.length()-first.length())
					end.remove(0);
				else breakCase = false;
			}
			if(breakCase) {
				String E = "", B = "";
				if(end.size() > 0) E = end.get(0);
				if(beg.size() > 0) B = beg.get(0);
				int tLen = E.length() + B.length();
				if(tLen > 10000)
					System.out.println("Case #" + t + ": *");
				else
					System.out.println("Case #" + t + ": " + B + E);
			}else
				System.out.println("Case #" + t + ": *");
		}
	}
}