import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in))) ;
		int T = s.nextInt() ;
		StringBuilder  strb = new StringBuilder() ;
		for(int t=1;t<=T;t++) {
			int N = s.nextInt() ;
			BitSet row = new BitSet(N) ;
			BitSet col[] = new BitSet[N] ;
			
			long trace = 0 ;
			long rowCount = 0;
			long colCount = 0 ;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int num = s.nextInt() ;
					if(i==j)
						trace+=num ;
					if(i==0) {
						col[j] = new BitSet(N);
					}
					if(j==0) {
						row = new BitSet();
					}
					row.set(num);
					col[j].set(num);
					if(j==N-1) {					
						if(row.cardinality()!= N)
							rowCount++ ;
					}
					
				}
			}
			for(BitSet i: col) {
				if(i.cardinality() != N)
					colCount++ ;
			}
			strb.append("Case #");
			strb.append(t) ;
			strb.append(": ");
			strb.append(trace);
			strb.append(" ");
			strb.append(rowCount) ;
			strb.append(" ");
			strb.append(colCount) ;
			strb.append("\n");
		}
		System.out.println(strb.toString());
	}

}
