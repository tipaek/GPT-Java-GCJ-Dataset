import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	InputStream in;
	PrintStream out;
	Scanner scanner;

	class Variant implements Comparable<Variant>{
		long x;
		long xminus;
		long y;
		long yminus;
		long bits;
		public Variant(long x, long y, long xminus, long yminus, long bits) {
			super();
			this.x = x;
			this.y = y;
			this.xminus = xminus;
			this.yminus = yminus;
			this.bits = bits;
		}
		
		public boolean possible() {
			return (((x|xminus)&(y|yminus)) ==0);
		}

		@Override
		public int compareTo(Variant arg0) {
			// TODO Auto-generated method stub
			return (int)(this.bits - arg0.bits);
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			long bit = 1;
			long nbits = bits;
			while (nbits>0) {
				if((x&bit) !=0) {
					sb.append(echar);
					nbits--;
				}
				if((xminus&bit) !=0) {
					sb.append(wchar);
					nbits--;
				}
				if((y&bit) !=0) {
					sb.append(nchar);
					nbits--;
				}
				if((yminus&bit) !=0) {
					sb.append(schar);
					nbits--;
				}
				bit*=2;
			}
			return sb.toString();
		}
	}
	
	Solution(InputStream in, PrintStream out){
		this.in = in;
		this.out=out;
		scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
	}
	
	char schar, wchar, nchar, echar;
	long x,y;
	String result;
	boolean isPossible;
	
	private void readTest() {
		x = scanner.nextLong();
		y = scanner.nextLong();
	}


	private long bitCount(long n) {
		long c = 0;
		while(n!=0) {
			if((n&1) == 1)
				c++;
			n/=2;
		}
		return c;
	}
	
	private long big(long n) {
		long c = 1;
		while(c <= n)
			c*=2;
		return(c);
	}

	private void calculate() {
		if(y<0) {
			schar = 'N';
			nchar = 'S';
			y = -y;
		}else {
			schar='S';
			nchar='N';
		}
		if(x<0) {
			echar = 'W';
			wchar = 'E';
			x = -x;
		}else {
			wchar='W';
			echar='E';
		}
		
		Variant[] v = new Variant[4];
		long bigx = big(x);
		long bigy = big(y);
		long xcnt = bitCount(x);
		long ycnt = bitCount(y);
		long bigxcnt = 1 + bitCount(bigx - x);
		long bigycnt = 1 + bitCount(bigy - y);
		
		v[0] = new Variant(x, y, 0, 0, xcnt+ycnt);
		v[1] = new Variant(bigx, y, bigx - x, 0, bigxcnt+ycnt);
		v[2] = new Variant(x, bigy, 0, bigy-y, xcnt+bigycnt);
		v[3] = new Variant(bigx, bigy, bigx-x, bigy-y, bigxcnt+bigycnt);
		
		Arrays.sort(v);
		
		for(int i=0;i<4;i++) {
			if(v[i].possible()) {
				isPossible = true;
				result = v[i].toString();
				return;
			}
		}
		isPossible=false;
		return;
	}

	private void printResult(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("Case #" + i + ": ");
		
		if(isPossible)
			sb.append(result);
		else
			sb.append("IMPOSSIBLE");
		
		out.println(sb.toString());
		
	}

	public static void main(String[] args) {
		new Solution(System.in, System.out).run();
	}

	public void run() {
		int T = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= T; i++) {
			readTest();
			calculate();
			printResult(i);
		}
	}

}