import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution {
	public static BufferedReader br;
	public static PrintStream ps;
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
		else {
			//0 = 0, same
			//1 = 0, diff
			//2 = 1, same
			//3 = 1, diff
			boolean stop  = true;
			for(int kei = 0; kei < keis; kei++){
				int[] kind = new int[B];
				int[] prev = new int[B];
				int sameIdx = -1;
				int diffIdx = -1;
				Group[] groups = new Group[B/10];
				for(int i = 0; i < B/10; i++){
					groups[i] = new Group();
				}
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
						groups[(idx1-1)/10].same[rep1].add(idx1-1);
						if(sameIdx == -1){
							sameIdx = idx1;
						}
					}
					else {
						kind[idx1-1] = 2;
						groups[(idx1-1)/10].diff[rep2].add(idx1-1);
						if(diffIdx == -1){
							diffIdx = idx1;
						}
					}
				}
				
				//already known all pair kinds
				if(sameIdx != -1 && diffIdx != -1){
					int prevSame = -1;
					int prevDiff = -1;
					for(int i = 0; i < 5; i++){
						int idx1 = sameIdx;
						int idx2 = diffIdx;
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
						prevSame = rep1;
						prevDiff = rep2;
					}
					
				}
				else if(sameIdx != -1){
					
				}
				else{
					//diffIdx != -1
					
				}
				ps.println(0);
				ps.flush();
				br.readLine().trim();
				break;
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