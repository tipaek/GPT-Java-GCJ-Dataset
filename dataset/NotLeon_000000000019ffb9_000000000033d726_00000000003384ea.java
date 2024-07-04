import java.util.*;
import java.io.*;

public class Solution {
	static Scanner sc;
	// static BufferedReader br;
	public static void main(String[] args)throws IOException {
//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; ++i) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}
	static void solve() {
		long l = sc.nextLong(), r = sc.nextLong();
		int i = bs1((long)Math.abs(r-l));
		long mus = sq(i);
		if(r > l)r -= mus;
		else l -= mus;
		int n1 = 0, n2=0, m = (i+1)%2;
		if(l < r){
			n1 = bs2(m, r, i);
			n2 = bs2(i%2, l, i);
			if(m==0){
				r -= esq(n1)-esq(i);
				l -= osq(n2)-osq(i);
			}else {
				r -= osq(n1)-osq(i);
				l-=esq(n2)-esq(i);
			}
		}else{
			n1 = bs2(m, l, i);
			n2 = bs2(i%2, r, i);
			if(m==0){
				l -= esq(n1)-esq(i);
				r -= osq(n2)-osq(i);
			}else{
				l -= osq(n1)-osq(i);
				r -= esq(n2)-esq(i);
			}
		}
		System.out.println(Math.min(n1, n2)+" "+l+" "+r);
	}
	static int bs1(long tar){
		int l = 0, r = (int)1e9;
		while(true){
			int mid = (l+r)/2;
			long v = sq(mid);
			if(v <= tar && sq(mid+1) > tar){
				return mid;
			}else if(v < tar){
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}
	}
	static int bs2(int m2, long tar, int i){
		int l = i, r = (int)1e9;
		int mid = 0;
		while(l<=r){
			mid = (l+r)/2;
			long v = 0, nx = 0;
			if(m2 == 0){
				v = esq(mid)-esq(i);
				nx = esq(mid+1)-esq(i);
			}else{
				v = osq(mid)-osq(i);
				nx = osq(mid+1)-osq(i);
			}
			if(v <= tar && nx > tar){
				return mid;
			}else if(v <= tar){
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}
		return mid;
	}
	static long sq(long i){
		return i*(i+1)/2;
	}
	static long esq(long i){
		i/=2;
		return 2*sq(i);
	}
	static long osq(long i){
		if(i==0)return 0;
		i+=1;
		i/=2;
		return i*i;
	}
}
