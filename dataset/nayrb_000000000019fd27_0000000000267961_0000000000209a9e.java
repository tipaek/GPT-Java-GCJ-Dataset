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
			boolean stop  = false;
			boolean done = false;
			for(int kei = 0; kei < keis; kei++){
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
						g[(idx1-1)/10].same[rep1].add(idx1-1);
					}
					else {
						kind[idx1-1] = 2;
						g[(idx1-1)/10].diff[rep2].add(idx1-1);
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