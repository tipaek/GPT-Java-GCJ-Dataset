import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution {
	public static BufferedReader br;
	public static PrintStream ps;
	public static void f (LL list, boolean same, int B) throws IOException{
		if(list.size() == 0) return;
		int x = list.removeFirst();
		int rep = query(x + 1); 
		
		list.addFirst(x);
		
		for(int idx : list){
			ans[idx] = rep;
			ans[B - idx - 1] = same ? rep : (rep + 1) %2;
		}
		return;
	}
	
	public static int getType(int a1, int b1, int a2, int b2){
		if(a1 == a2){
			if(b1 == b2){
				return 4;
			}
			return 2;
		}
		
		//a1 != a2
		if(b1 == b2){
			return 1;
		}
		return 3;
	}
	public static int[] ans;
	public static void main(String[] args) throws IOException{
		 ps = new PrintStream(out);
		
		//1 =complemented
		//2 = reverse
		//3 = rev + comp
		//4 = none
		
		//kind
		// 1 = same
		// 2 = diff
		
		// int keis = sc.nextInt();
		// int B = sc.nextInt();
		br = new BufferedReader(new InputStreamReader(in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int keis = Integer.valueOf(st.nextToken());
		int B = Integer.valueOf(st.nextToken());
		
		if(B == 10){
			
			boolean stop = false;
			for(int kei = 0; kei < keis; kei++){
				int[] ans = new int[B];
				for(int q = 0; q < B/2; q++){
					int idx1 = q + 1;
					int idx2 = B - idx1 + 1;
					
					int rep1 = query(idx1);
					if(rep1 == -1) {
						stop = true;
						break;
					}
					int rep2 = query(idx2);
					if(rep2 == -1) {
						stop = true;
						break;
					}
					ans[idx1-1] = rep1;
					ans[idx2-1] = rep2;
				}
				
				if(stop) break;
				String ansOut = "";
				for(int i = 0; i < B; i++){
					ansOut += ""+ans[i];
				}
				int rep = printAns(ansOut);
				if(rep == -1) break;
			}
		}
		else if(B == 20){
			//0 = 0, same
			//1 = 0, diff
			//2 = 1, same
			//3 = 1, diff
			boolean stop  = true;
			boolean done = true;
			for(int kei = 0; kei < keis; kei++){
				int[] kind = new int[B];
				int[] prev = new int[B];
				int sameIdx = -1;
				int diffIdx = -1;
				Group g = new Group();
				ans = new int[B];
				for(int idx1 = B/2; idx1 > 0 ; idx1--){
					int idx2 = B - idx1 + 1;
					
					int rep1 = query(idx1);
					if(rep1 == -1) {
						stop = true;
						break;
					}
					int rep2 = query(idx2);
					if(rep2 == -1) {
						stop = true;
						break;
					}
					if(rep1 == rep2) {
						kind[idx1-1] = 1;
						g.same[rep1].add(idx1-1);
						if(sameIdx == -1){
							sameIdx = idx1;
						}
					}
					else {
						kind[idx1-1] = 2;
						g.diff[rep2].add(idx1-1);
						if(diffIdx == -1){
							diffIdx = idx1;
						}
					}
				}
				
				//already known all pair kinds
				// if(sameIdx != -1 && diffIdx != -1){
					// int prevSame = -1;
					// int prevDiff = -1;
					// for(int i = 0; i < 1; i++){
						// int idx1 = sameIdx;
						// int idx2 = diffIdx;
						// int rep1 = query(idx1);
						// int rep2 = query(idx2);
						// prevSame = rep1;
						// prevDiff = rep2;
					// }
					
					// int idx1 = sameIdx;
					// int idx2 = diffIdx;
					// int rep1 = query(idx1);
					// int rep2 = query(idx2);
					
					// int type = getType(prevSame, prevDiff, rep1, rep2);
					
					
					
				// }
				// else if(sameIdx != -1){
					
				// }
				// else{
					// diffIdx != -1
					
				// }
				
				f(g.same[0], true, B);
				f(g.same[1], true, B);
				f(g.diff[0], false, B);
				f(g.diff[1], false, B);
				String ansOut = "";
				for(int i = 0; i < B; i++){
					ansOut += ""+ans[i];
				}
				
				int rep = printAns(ansOut);
				if(rep == -1) break;
			}
		}
		else{
			
			ps.println(0);
			ps.flush();
			br.readLine().trim();
		}
	}
	public static int query(int x) throws IOException{
		ps.println(x);
		ps.flush();
		// String rep = sc.next();
		String rep = br.readLine().trim();
		int repNum = -1;
		if(!rep.equals("N")){
			repNum = rep.charAt(0) - '0';
		}
		
		return repNum;
	}
	public static int printAns(String x) throws IOException{
		ps.println(x);
		ps.flush();
		// String rep = sc.next();
		String rep = br.readLine().trim();
		int repNum = -1;
		if(!rep.equals("N")){
			repNum = rep.charAt(0) - '0';
		}
		
		return repNum;
	}
	public static class Group{
		LL[] same;
		LL[] diff;
		public Group(){
			same = new LL[2];
			diff = new LL[2];
			for(int i = 0; i < 2; i++){
				same[i] = new LL();
				diff[i] = new LL();
			}
		}
	}
	public static class LL extends LinkedList<Integer>{}
}