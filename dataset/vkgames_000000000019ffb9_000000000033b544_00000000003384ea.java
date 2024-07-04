import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int c =0;
		while(t>0) {
			t--;
			c++;
			boolean swap = false;
			long l = sc.nextLong();
			long r = sc.nextLong();
			//find initiial i.
			long temp = l;
			if(l>r) {
				l = r;
				r = temp;
				swap = true;
			}
			//binary search??
			int i=0;
			if(l!=r) {
				i= binarySearch(0,Integer.MAX_VALUE-3,(long) r-l);
			}
			
//			System.out.println(i);			
			long sub = (long) i*(i+1);
			sub/=2;
			r-=sub;
			if(r<0) {
				r+=i;
				i--;
			}
			
//			System.out.println(l + " " + r);
			if(l<=i && r<=i) {
				if(swap) {
					System.out.println("Case #"+c+": "+i + " " + r + " " +l);
				}
				else {
					System.out.println("Case #"+c+": "+i + " " + l + " " +r);
				}
				continue;
			}
			int a = binarySearchl(1,Integer.MAX_VALUE-3,i,l);
			int b = binarySearchr(1,Integer.MAX_VALUE-3,i,r);
//			System.out.println(a + " " + b + " "+ i);
			sub = (long) (i+a)*(a);
			l-=sub;
			sub = (long) (i+b+1)*(b);
			r-=sub;
			a = 2*a-1;
			b = 2*b;
			a+=i;
			b+=i;
			int ans = Math.min(a+1,b+1);
			if(swap) {
				System.out.println("Case #"+c+": "+ans + " " + r + " " +l);
			}
			else {
				System.out.println("Case #"+c+": "+ans + " " + l + " " +r);
			}
			//now l>=r
			//probably 2x steps from here, l reduced first
			//i+1+...+i+2x-1 <= l
			//i+2+...+i+2x <= r can add one mb
			
			
		}
	}
	static int binarySearchl(int lo,int hi,int start,long l) {
		int mid = (lo+hi)/2;
		if(satisfiesl(mid,start,l)) {
			if(!satisfiesl(mid+1,start,l)) {
				return mid;
			}
			return binarySearchl(mid+1,hi,start,l);
		}
		else {
			if(satisfiesl(mid-1,start,l)) {
				return mid-1;
			}
			return binarySearchl(lo,mid-1,start,l);
		}
	}
	static boolean satisfiesl(int mid,int start,long l) {
		long x = (long) (mid+start)*(mid);
		return x<=l;
	}
	static int binarySearchr(int lo,int hi,int start,long r) {
		int mid = (lo+hi)/2;
		if(satisfiesr(mid,start,r)) {
			if(!satisfiesr(mid+1,start,r)) {
				return mid;
			}
			return binarySearchr(mid+1,hi,start,r);
		}
		else {
			if(satisfiesr(mid-1,start,r)) {
				return mid-1;
			}
			return binarySearchr(lo,mid-1,start,r);
		}
	}
	static boolean satisfiesr(int mid,int start,long r) {
		long x = (long) (mid+start+1)*(mid);
		return x<=r;
	}
	
	static int binarySearch(int lo,int hi,long dif) {
		int mid = (lo+hi)/2;
		if(satisfies(mid,dif)) {
			if(!satisfies(mid-1,dif)) {
				return mid;
			}
			return binarySearch(lo,mid-1,dif);
		}
		else {
			if(satisfies(mid+1,dif)) {
				return mid+1;
			}
			return binarySearch(mid+1,hi,dif);
		}
	}
	static boolean satisfies(int mid, long dif) {
		long x = (long) (mid)*(mid+1);
		x/=2;
		return x>=dif;
		
	}
}
