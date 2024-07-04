import java.math.BigInteger;
import java.util.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<T;i++) {
			
			String n = sc.nextLine();
			int N = Integer.parseInt(n);
			BigInteger trace = new BigInteger("0");
			int r = 0;
			int c = 0;
			boolean [][] cols = new boolean[N][N];
			boolean[] duplCol = new boolean[N];
			for(int j=0;j<N;j++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				boolean [] row = new boolean[N];
				boolean dupl = false;
				for(int k=0;k<N;k++) {
					
					int element = Integer.parseInt(st.nextToken());
					
					if(j==k) {
						trace = trace.add(BigInteger.valueOf(element));
					}
					if(row[element-1]&&!dupl) {
						dupl = true;
						r++;
					}else if(!row[element-1]){
						row[element-1]=true;
					}
					
					if(cols[k][element-1]&&!duplCol[k]) {
						duplCol[k] = true;
						c++;
					}else if(!cols[k][element-1]) {
						cols[k][element-1] = true;
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
		
		}
	}
}
