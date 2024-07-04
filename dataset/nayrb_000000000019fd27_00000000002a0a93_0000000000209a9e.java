import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution {
	public static BufferedReader br;
	public static PrintStream ps;
	public static int f (LL list, boolean same, int B) throws IOException{
		if(list.size() == 0) return 0;
		int x = list.removeFirst();
		int rep = query(x + 1); 
		
		list.addFirst(x);
		
		for(int idx : list){
			ans[idx] = rep;
			ans[B - idx - 1] = same ? rep : (rep + 1) %2;
			updated.add(idx);
		}
		return 1;
	}
	
	public static void update (int type, int B) throws IOException{
		if(updated.size() == 0) return;
		for(int i : updated){
			int ii = B - i - 1;
			int x = ans[i];
			int y = ans[ii];
			
			if(type == 1){
				ans[i] = (x + 1)%2;
				ans[ii] = (y + 1)%2;
			}
			else if(type == 2){
				ans[i] = x;
				ans[ii] = y;
			}
			else if(type == 3){
				ans[i] = (y + 1)%2;
				ans[ii] = (x + 1)%2;
			}
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
	public static LinkedList<Integer> updated;
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
				updated = new LinkedList<Integer>();
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
		/*
		else if(B == 20){
			//0 = 0, same
			//1 = 0, diff
			//2 = 1, same
			//3 = 1, diff
			boolean stop  = false;
			boolean done = false;
			for(int kei = 0; kei < keis; kei++){
				updated = new LinkedList<Integer>();
				int[] kind = new int[B];
				Group[] g = new Group[2];
				g[1] = new Group();
				g[0] = new Group();
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
						g[(idx1-1)/5].same[rep1].add(idx1-1);
					}
					else {
						kind[idx1-1] = 2;
						g[(idx1-1)/5].diff[rep2].add(idx1-1);
					}
				}
				
				
				for(int gg = 0; gg < 2; gg++){
					for(int y = 0; y < 2; y++){
						f(g[gg].same[y], true, B);
						f(g[gg].diff[y], false, B);
					}
				}
				
				String ansOut = "";
				for(int i = 0; i < B; i++){
					ansOut += ""+ans[i];
				}
				
				int rep = printAns(ansOut);
				if(rep == -1) break;
			}
		}*/
		else{
			//100
			//0 = 0, same
			//1 = 0, diff
			//2 = 1, same
			//3 = 1, diff
			boolean stop  = false;
			boolean done = false;
			
			
			for(int kei = 0; kei < keis; kei++){
				updated = new LinkedList<Integer>();
				int[] kind = new int[B];
				Group[] g = new Group[B/10];
				ans = new int[B];
				
				for(int i = 0; i < B/10; i++){
					g[i] = new Group();
				}
				
				int sameIdx = -1;
				int diffIdx = -1;
				
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
						g[(idx1-1)/5].same[rep1].add(idx1-1);
						if(sameIdx == -1) sameIdx = idx1;
					}
					else {
						kind[idx1-1] = 2;
						g[(idx1-1)/5].diff[rep2].add(idx1-1);
						if(diffIdx == -1) diffIdx = idx1;
					}
				}
				
				if(sameIdx != -1 && diffIdx != -1) {
					
					int prevSame = query(sameIdx);
					int prevDiff = query(diffIdx);
					
					//-2 queries
					
					int groupNum = 0;
					
					int doneCnt = 0;
					while(true){
						int qCnt = 0;
						while(true){
							for(int y = 0; y < 2; y++){
								qCnt += f(g[groupNum].same[y], true, B);
								doneCnt += 20;
								if(doneCnt >= B) break;
								qCnt += f(g[groupNum].diff[y], false, B);
								doneCnt += 20;
								if(doneCnt >= B) break;
							}
							if(doneCnt >= B) break;
							groupNum++;
							if(qCnt > 4) break;
						}
						if(doneCnt >= B) break;
						
						// use all query until 8
						for(int i = 0; i < (8 - qCnt); i++){
							query(sameIdx);
						}
						qCnt = 8;
						
						//get type and update
						
						int rep1 = query(sameIdx);
						int rep2 = query(diffIdx);
						int type = getType(prevSame, prevDiff, rep1, rep2);
						update(type, B);
						prevSame = rep1;
						prevDiff = rep2;
					}
				}
				else if(sameIdx != -1) {
					int prevSame = query(sameIdx);
					
					//-1 queries
					
					int groupNum = 0;
					
					int doneCnt = 0;
					while(true){
						int qCnt = 0;
						while(true){
							for(int y = 0; y < 2; y++){
								qCnt += f(g[groupNum].same[y], true, B);
								doneCnt += 20;
								if(doneCnt >= B) break;
							}
							if(doneCnt >= B) break;
							groupNum++;
							if(qCnt > 7) break;
						}
						if(doneCnt >= B) break;
						
						// use all query until 9
						for(int i = 0; i < (9 - qCnt); i++){
							query(sameIdx);
						}
						qCnt = 9;
						
						
						//get type and update
						
						int rep1 = query(sameIdx);
						int type = getType(prevSame, 10, rep1, 10);
						update(type, B);
						prevSame = rep1;
					}
				}
				else{
					//diffIdx != -1
					int prevDiff = query(diffIdx);
					
					//-1 queries
					
					int groupNum = 0;
					
					int doneCnt = 0;
					while(true){
						int qCnt = 0;
						while(true){
							for(int y = 0; y < 2; y++){
								qCnt += f(g[groupNum].same[y], true, B);
								doneCnt += 20;
								if(doneCnt >= B) break;
							}
							if(doneCnt >= B) break;
							groupNum++;
							if(qCnt > 7) break;
						}
						if(doneCnt >= B) break;
						
						// use all query until 9
						for(int i = 0; i < (9 - qCnt); i++){
							query(diffIdx);
						}
						qCnt = 9;
						
						
						//get type and update
						
						int rep2 = query(diffIdx);
						int type = getType(10, prevDiff, 10, rep2);
						update(type, B);
						prevDiff = rep2;
					}
				}
				
				
				String ansOut = "";
				for(int i = 0; i < B; i++){
					ansOut += ""+ans[i];
				}
				
				int rep = printAns(ansOut);
				if(rep == -1) break;
			}
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