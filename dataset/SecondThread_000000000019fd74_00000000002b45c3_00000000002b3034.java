import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		outer:for (int tt=1; tt<=T; tt++) {
			int n=fs.nextInt();
			ArrayList<char[]> suffixes=new ArrayList<>();
			ArrayList<char[]> prefixes=new ArrayList<>();
			ArrayList<char[]> centers=new ArrayList<>();
			for (int st=0; st<n; st++) {
				String line=fs.next();
				int firstInd=0, lastInd=0;
				for (int i=0; i<line.length(); i++) if (line.charAt(i)=='*') lastInd=i;
				for (int i=line.length()-1; i>=0; i--) if (line.charAt(i)=='*') firstInd=i;
				prefixes.add(line.substring(0, firstInd).toCharArray());
				suffixes.add(line.substring(lastInd+1).toCharArray());
				for (int i=firstInd+1; i<line.length(); i++) {
					if (line.charAt(i)=='*') {
						centers.add(line.substring(firstInd+1, i).toCharArray());
						firstInd=i;
					}
				}
			}
			System.out.print("Case #"+tt+": ");
			Collections.sort(suffixes, (a, b) -> {
				return Integer.compare(a.length, b.length);
			});
			Collections.sort(prefixes, (a, b) -> {
				return Integer.compare(a.length, b.length);
			});
			char[] lastPre=prefixes.get(prefixes.size()-1);
			char[] lastSuf=suffixes.get(prefixes.size()-1);
			for (int i=0; i+1<prefixes.size(); i++) {
				for (int x=0; x<prefixes.get(i).length; x++) {
					if (prefixes.get(i)[x]!=lastPre[x]) {
						System.out.println('*');
						continue outer;
					}
				}
			}
			for (int i=0; i+1<suffixes.size(); i++) {
				for (int x=0; x<suffixes.get(i).length; x++) {
					int ind1=suffixes.get(i).length-1-x;
					int ind2=lastSuf.length-1-x;
					if (suffixes.get(i)[ind1]!=lastSuf[ind2]) {
						System.out.println('*');
						continue outer;
					}
				}
			}
			for (char c:lastPre) System.out.print(c);
			for (char[] a:centers) for (char c:a) System.out.print(c);
			for (char c:lastSuf) System.out.print(c);
			System.out.println();
		}
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreElements()) {
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
