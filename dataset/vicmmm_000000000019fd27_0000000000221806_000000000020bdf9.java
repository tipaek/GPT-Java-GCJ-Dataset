import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fst = reader.readLine();
		int T = Integer.parseInt(fst);

		StringBuffer sb = new StringBuffer();
		
		Comparator<int[]> comp = new Comparator<int[]>(){
			@Override
			public int compare(int[] p1, int[] p2) {
				int diff = p1[1]-p2[1];
				if(diff==0) return p1[0]-p2[0];
				return diff;
			}
		};
		
		
		for(int i=0;i<T;i++) {
			String s = reader.readLine();
			int n = Integer.parseInt(s);
			
			int[][] intvs = new int[n][3];
			
			for(int k=0;k<n;k++) {
				String str = reader.readLine();
				String[] ss = str.split(" ");
				int[] intv = new int[3];
				intv[0] = Integer.parseInt(ss[0]);
				intv[1] = Integer.parseInt(ss[1]);
				intv[2] = k;
				
				intvs[k] = intv;
			}
			
			Arrays.sort(intvs, comp);
			
			String prev = "C";
			String[] arrange = new String[n];
			arrange[intvs[0][2]] = "C";
			
			int lastEnd = intvs[0][1];
			String arr = "";
			
//			sb.append("\n"+intvs[0][0]+" "+intvs[0][1]+" "+intvs[0][2]);
			
			for(int j=1;j<n;j++) {
				int[] intv = intvs[j];
				int start = intv[0];
				int idx = intv[2];
//				sb.append("\n"+intv[0]+" "+intv[1]+" "+intv[2]);
				
				if(start>=lastEnd) arrange[idx] = prev;
				else {
					intvs[j-1][1] *= (-1); // mark the last end as overlapped
					if(j-2>=0 && intvs[j-2][1]<0 && start<-intvs[j-2][1]) {
						arr = "IMPOSSIBLE";
						break;
					}
					prev = prev.equals("C") ? "J" : "C";
					arrange[idx] = prev;
				}
			}
			
			if(arr.equals("")) {
				for(int k=0;k<n;k++) arr += arrange[k];
			}
			
			sb.append("Case #"+(i+1)+": "+arr+"\n");
		}
		
		System.out.println(sb.toString());
	}

//	public static String addParens(String s) {
//		char[] chs = s.toCharArray();
//		int n = s.length();
//		
//		Comparator<int[]> comp = new Comparator<int[]>(){
//			@Override
//			public int compare(int[] p1, int[] p2) {
//				int diff = p1[0]-p2[0];
//				if(diff==0) return p1[1]-p2[1];
//				return diff;
//			}
//		};
//		
//		PriorityQueue<int[]> pq = new PriorityQueue<>();
//
//		for(int i=0;i<n;i++) {
//			int[] pair = new int[2];
//			pair[0] = chs[i]-'0';
//			pair[1] = i;
//			
//			pq.add(pair);
//		}
//		
//		
//		int[] leftParens = new int[n+1];
//		int[] rightParens = new int[n+1];
//		
////		int low = 0, high = n-1;
//		List<Integer> cuts = new ArrayList<>();
//		cuts.add(-1);
//		cuts.add(n);
//		
//		while(!pq.isEmpty()) {
//			int[] pair = pq.peek();
//			int min = pair[0];
//			
//			int i = 0; // index in cuts, always make sure i < cuts.size()-1
//			List<Integer> newCuts = new ArrayList<>();
//			
//			while(!pq.isEmpty() && pq.peek()[0]==min) {
//				int[] p = pq.poll();
//				int idx = p[1];
//				
//				boolean toNext = false;
//				while(idx>cuts.get(i)) {
//					newCuts.add(cuts.get(i));
//					i ++;
//					toNext = true;
//				} // after loop, cuts.get(i-1)<idx<cuts.get(i)
//				newCuts.add(idx);
//				if(toNext) {
//					int lower = cuts.get(i-1);
//					int upper = cuts.get(i)-1;
//					leftParens[lower+1] += min;
//					rightParens[upper] += min;
//				}
//			}	
//			
//		}
//			
//	}

}
