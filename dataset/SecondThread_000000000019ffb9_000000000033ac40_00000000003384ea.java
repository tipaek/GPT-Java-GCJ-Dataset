import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			long l=fs.nextLong(), r=fs.nextLong();
			long prefix;
			if (l>r)
				prefix=bsFornC2(l-r);
			else 
				prefix=bsFornC2(r-l);
			if (l>r) l-=nC2(prefix);
			else r-=nC2(prefix);
			long minAdditional=0, maxAdditional=2_000_000_000;
			while (minAdditional!=maxAdditional) {
				long mid=(minAdditional+maxAdditional+1)/2;
				long[] afterServing=afterServingX(prefix, l, r, mid);
				if (Math.min(afterServing[0], afterServing[1])<0) {
					maxAdditional=mid-1;
				}
				else {
					minAdditional=mid;
				}
			}
			long[] res=afterServingX(prefix, l, r, minAdditional);
			System.out.println("Case #"+(tt+1)+": "+(prefix+minAdditional)+" "+res[0]+" "+res[1]);
		}
	}
	
	static long bsFornC2(long diff) {
		long min=0, max=2_000_000_000;
		while (min!=max) {
			long mid=(min+max+1)/2;
			long nC2=nC2(mid);
			if (nC2>diff) {
				max=mid-1;
			}
			else {
				min=mid;
			}
		}
		return min;
	}
	
	static long nC2(long n) {
		return n*(n+1)/2;
	}
	
	//0+2+4+///
	static long plus2C2(long n) {
		return n*(n-1);
	}

	static long[] afterServingX(long servedAlready, long l, long r, long x) {
		if (l>=r) {
			//start serving l
			//l gets servedAlready+1, servedAlready+3, servedAready+5 ...
			long nGiveToL=(x+1)/2;
			long lBonus=(1+servedAlready)*nGiveToL;
			//0+2+4+...
			long lC2=plus2C2(nGiveToL);
			
			//r gets servedAlready+2, servedAlready+4, servedAready+6 ...
			long nGiveToR=x/2;
			long rBonus=(2+servedAlready)*nGiveToR;
			long rC2=plus2C2(nGiveToR);
			
			long newL=l-lBonus-lC2;
			long newR=r-rBonus-rC2;
			return new long[] {newL, newR};
		}
		else {
			//start serving l
			//l gets servedAlready+1, servedAlready+3, servedAready+5 ...
			long nGiveToL=(x+1)/2;
			long lBonus=(1+servedAlready)*nGiveToL;
			//0+2+4+...
			long lC2=plus2C2(nGiveToL);
			
			//r gets servedAlready+2, servedAlready+4, servedAready+6 ...
			long nGiveToR=x/2;
			long rBonus=(2+servedAlready)*nGiveToR;
			long rC2=plus2C2(nGiveToR);
			
			long newL=l-rBonus-rC2;
			long newR=r-lBonus-lC2;
			return new long[] {newL, newR};
		}
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
