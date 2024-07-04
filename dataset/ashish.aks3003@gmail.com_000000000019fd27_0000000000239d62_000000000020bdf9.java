import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int t = scan.nextInt();
		for(int i = 0; i<t; i++) {
			int n = scan.nextInt();
			ArrayList<Indexer> startList = new ArrayList<Indexer>();
			ArrayList<Indexer> endList = new ArrayList<Indexer>();
			for(int j=0; j<n; j++) {
				int start = scan.nextInt();
				int end = scan.nextInt();
				Indexer strt = new Indexer(start, j);
				startList.add(strt);
				Indexer nd = new Indexer(end, j);
				endList.add(nd);
			}
			Collections.sort(startList, new SortIndexer());
			Collections.sort(endList, new SortIndexer());
			int ei = 0, si =1 , overlap=1;
			boolean impossible = false;
			StringBuilder res = new StringBuilder();
			
			ArrayList<Integer> freePerson = new ArrayList<Integer>();
			freePerson.add(startList.get(0).index);
			freePerson.add(-1);	
			res.append("C");
			
			while(si<n && ei<n) {
				if(startList.get(si).value<endList.get(ei).value) {
					overlap++;
					if(overlap > 2) {
						impossible = true;
						break;
					}
					if(freePerson.get(0) == -1) {
						freePerson.set(0, startList.get(si).index);
						res.append("C");
					}
					else if(freePerson.get(1) == -1) {
						freePerson.set(1, startList.get(si).index);
						res.append("J");
					}
					si++;
				}else {
					int clearIndex = endList.get(ei).index;
					if(freePerson.get(0) == clearIndex)
						freePerson.set(0, -1);
					else if(freePerson.get(1) == clearIndex) {
						freePerson.set(1, -1);
					}
					ei++;
					overlap--;
				}
			}
			
			StringBuilder result = new StringBuilder();
			
			if(impossible == true)
				result.append("IMPOSSIBLE");
			else {
				for(int j=0; j<n; j++)
					result.append("D");
				for(int j=0; j<n; j++)
					result.replace(startList.get(j).index, startList.get(j).index+1,
							Character.toString(res.charAt(j)));
			}
			
			System.out.println("Case #"+(i+1)+": "+result);
		}
		
	}
	
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));			
		}
		
		String next(){
			while(st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
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
class Indexer {
	 Integer value;
	 Integer index;
	 Indexer() { 
		 value = 0; index = -1;
	}
	 Indexer(int value, int index) { 
		 this.value = value; this.index = index; 
	}
}

class SortIndexer implements Comparator<Indexer>{

	@Override
	public int compare(Indexer o1, Indexer o2) {
		return o1.value.compareTo(o2.value);
	}
}
