import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution {
	public static Scanner sc;
	public static BufferedReader br;
	public static PrintStream ps;
	public static void main(String[] args) throws IOException{
		 ps = new PrintStream(out);
		
		//1 =complemented
		//2 = reverse
		//3 = rev + comp
		//4 = none
		
		
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
}