import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Rename to Solution!!!
/*
1
2 2
0 1
184 330

1
3 2
0 1
184 330

1
10 3
1 5 9
184 200 330

1
3 2
0 1
184 330

1
20 4
0 3 5 7
1 2 1 2

1
20 4
0 3 8 15
1 2 1 2

1
22 4
0 1 11 12
0 1 0 1

1
3 2
0 1
184 330
 */
public class BBrute {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			int size=fs.nextInt(), n=fs.nextInt();
			int[] positions=fs.readArray(n);
			fs.readArray(n);
			size*=2;
			for (int i=0; i<n; i++) positions[i]*=2;
			int ans=1000000;
//			System.out.println("size: "+size);
//			System.out.println("Positions: "+Arrays.toString(positions));
			for (int mask=0; mask<1<<size; mask++) {
				if (Integer.bitCount(mask)<ans && works(mask, positions, size, n)) {
//					System.out.println("got it with mask: "+Integer.toBinaryString(mask));
					ans=Math.min(ans, Integer.bitCount(mask));
				}
			}
			System.out.println("Case #"+(tt+1)+": "+ans);
		}
	}
	
	static boolean works(int mask, int[] positions, int size, int n) {
		
		boolean print=false;//mask==10;
		
		boolean[] oneHere=new boolean[size];
		for (int i=0; i<size; i++) oneHere[i]=(mask&(1<<i))!=0;
		for (int i:positions) if (oneHere[i]) {
			return false;
		}
		if (mask==0) return false;
		
		//needs to be one in every range
		outer:for (int lInd=0; lInd<n; lInd++) {
			int l=positions[lInd];
			int r=positions[(lInd+1)%n];
			for (int i=l+1; i!=r; i=(i+1)%size) {
				if (oneHere[i]) continue outer;
			}
			return false;
		}
		
		int[] firstBefore=new int[size], firstAfter=new int[size];
		int first=0, last=0;
		for (int i=0; i<size; i++) if (oneHere[i]) last=i;
		for (int i=size-1; i>=0; i--) if (oneHere[i]) first=i;
		int seen=first+size;
		for (int i=size-1; i>=0; i--) {
			if (oneHere[i]) seen=i;
			firstAfter[i]=seen;
		}
		seen=last-size;
		for (int i=0; i<size; i++) {
			if (oneHere[i]) seen=i;
			firstBefore[i]=seen;
		}
		
		if (print) {
			System.out.println("First before "+Arrays.toString(firstBefore));
			System.out.println("First after "+Arrays.toString(firstAfter));
		}
		for (int i:positions) {
			if (firstAfter[i]-i!=i-firstBefore[i]) {
				return false;
			}
		}
		return true;
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

	
}
