import java.io.*;
import java.util.*;

class Act implements Comparable<Act> {
	int idx, start, end;
	char whoWork;
	Act(int i, int s, int e) {
		idx = i; start = s; end = e;
	}
	
	public int compareTo(Act a) {
		return (this.start - a.start);
	}
	
}
public class Solution {
	static int T, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			ArrayList<Act> al = new ArrayList<>();
			String ans = "";
			StringBuilder sb = new StringBuilder(ans);
			boolean isPossible = true;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				al.add(new Act(i, start, end));
			}
			
			Collections.sort(al);
			
			boolean isCWork = false;
			boolean isJWork = false;
			int cStart=0, cEnd=0, jStart=0, jEnd=0;
			
			for(int i=0; i<al.size(); i++) {
				Act tmp = al.get(i);
				if(cEnd <= tmp.start) isCWork = false;
				if(jEnd <= tmp.start) isJWork = false;
				
				if(!isCWork || !isJWork) {
					if(!isCWork) {
						isCWork = true;
						cStart = tmp.start;
						cEnd = tmp.end;
						tmp.whoWork = 'C';
					}
					else if(!isJWork) {
						isJWork = true;
						jStart = tmp.start;
						jEnd = tmp.end;
						tmp.whoWork = 'J';
					}
				}				
				else {
					isPossible = false;
					break;
				}
			}
			
			Collections.sort(al, new Comparator<Act>() {
				public int compare(Act a1, Act a2) {
					return a1.idx - a2.idx;
				}
				
			});
			
			for(int i=0; i<al.size(); i++) {
				sb.append(al.get(i).whoWork);
			}
			
			if(isPossible) System.out.println("Case #"+t+": "+sb.toString());
			else System.out.println("Case #"+t+": "+"IMPOSSIBLE");
		}

	}

}
