import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution{
	public static Scanner sc;
	public static PrintStream ps;
	public static void main(String[] args) throws IOException{
		 ps = new PrintStream(out);
		
		//1 =complemented
		//2 = reverse
		//3 = rev + comp
		//4 = none
		
		
		int keis = sc.nextInt();
		int B = sc.nextInt();
		
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
				ps.println(ansOut);
				ps.flush();
			}
		}
		else {
				
			
			boolean stop = false;
			
			
			for(int kei = 0; kei < keis; kei++){
			
				boolean twoIdxDone = false;
				int sameIdx = -1;
				int diffIdx = -1;
				int sameNum = -1;
				int diffNum = -1;
				ps.println("N");
				ps.flush();
				break;
				/*
				//find two pairs, same and diff
				//HashSet<Integer> hs = new HashSet<Integer>();
				int q10 = 0;
				int q1 = 0;
				for(q10 = 0; q10 < B/10; q10++) {
					sameIdx = -1;
					diffIdx = -1;
					for(q1 = 0; q1 < 5; q1++){
						int idx1 = q1;
						int idx2 = B - idx1 - 1;
						
						int rep1 = query(idx1);
						if(rep1 == -1){
							stop = true;
							break;
						}
						int rep2 = query(idx2);
						if(rep2 == -1){
							stop = true;
							break;
						}
						
						if((sameIdx == -1) && (rep1 == rep2)){
							sameIdx = idx1;
						}
						if((diffIdx == -1) && (rep1 != rep2)){
							diffIdx = idx1;
						}
						
						if((sameIdx != -1) && (diffIdx != -1)) {
							twoIdxDone = true;
							break;
						}
					}
					if(twoIdxDone){
						break;
					}
				}
				
				
				if(stop) break;
				
				if(twoIdxDone){
					
				}
				else{
					//either all are same, or all are different
					int[] ans = new int[B];
					boolean[] withVal = new boolean[B];
					for(int q = 0; q < B/2; q++){
						if((q % 10 == 0) && (q != 0)){
							//update, get 
						}
						int idx = q;
						int idx2 = B - idx - 1;
						int rep = query(q);
						if(rep == -1){
							stop = true;
							break;
						}
						ans[idx] = rep;
						if(sameIdx == -1){
							//diff
							ans[idx2] = (rep + 1)%2;
						}
						else{
							//same
							ans[idx2] = rep;
						}
					}
					
					String outAns = "";
					
					
				}
				*/
			}
		}
	}
	public static int query(int x){
		ps.println(x);
		ps.flush();
		String rep = sc.next();
		int repNum = -1;
		if(!rep.equals("N")){
			repNum = rep.charAt(0) - '0';
		}
		
		return repNum;
	}
}