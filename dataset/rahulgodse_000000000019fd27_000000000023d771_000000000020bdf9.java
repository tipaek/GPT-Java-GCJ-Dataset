import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) {
		
		try {
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			int T = Integer.parseInt(bf.readLine());
			
			for (int i=0; i<T; i++) {
				
				int N = Integer.parseInt(bf.readLine());
				
				int A[][] = new int[N][2];
				int[] order = new int[N];
				boolean impossible = false;
				
				char[] output = new char[N];
				
				for(int j=0; j<N; j++) {
					
					String[] tempArr = bf.readLine().split(" ");
					A[j][0] = Integer.parseInt(tempArr[0]);
					A[j][1] = Integer.parseInt(tempArr[1]);
					
					order[j] = j;
					for (int k=j-1; k>=0; k--) {
						if (A[order[k+1]][0] < A[order[k]][0] || (A[order[k+1]][0] == A[order[k]][0] && A[order[k+1]][1] < A[order[k]][1]) ) {
							int x = order[k+1];
							order[k+1] = order[k];
							order[k] = x;
						} else break;
					}
				}
				
				int minC=0;
				int minJ = 0;
				
				for (int x=0; !impossible && x<N; x++) {
					if (minC <= A[order[x]][0]) {
						minC = A[order[x]][1];
						output[order[x]] = 'C';
					} else if (minJ <= A[order[x]][0]) {
						minJ = A[order[x]][1];
						output[order[x]] = 'J';
					} else {
						impossible = true;
						break;
					}
				}
				
				
				System.out.print("Case #" + (i+1) + ": ");
				if (impossible) {
					System.out.println("IMPOSSIBLE");
				} else {
					for (int x=0; x<N;x++) System.out.print(output[x]);
					System.out.println();
				}
			}
			
			
		} catch (Exception e) {
			
		}
		
	}
	
}
