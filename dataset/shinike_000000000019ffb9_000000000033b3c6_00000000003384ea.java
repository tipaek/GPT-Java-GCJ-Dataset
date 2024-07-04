import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			long left = sc.nextLong();
			long right = sc.nextLong();
			
			boolean rev = left < right;
			if (rev) {
				long tmp = right;
				right = left;
				left = tmp;
			}
			
			long min = 0;
			long max = Integer.MAX_VALUE/2;
			while (max-min>1) {
				long mid = min + (max-min)/2;
				if (left - right >= mid * (mid+1) /2) {
					min = mid;
				} else {
					max = mid;
				}
			}
			
			long count = min;
			left -= min * (min+1) /2;
			
			if (rev) {
				long tmp = right;
				right = left;
				left = tmp;
			}
			
			MyData data = new MyData(left, right, count+1);
			while (true) {
				data = solve(data);
				if (data.left<data.num && data.right < data.num) {
					break;
				}
			}
			
			
			System.out.println("Case #"+i+": "+(data.num-1)+" "+data.left+" "+data.right);
		}
	}
	
	public static MyData solve(MyData data) {
		long left = data.left;
		long right = data.right;
		long start = data.num;
		
		boolean rev = left < right;
		if (rev) {
			long tmp = right;
			right = left;
			left = tmp;
		}
		
		long min = -1;
		long max = Integer.MAX_VALUE/2;
		while (max-min>1) {
			long mid = min + (max-min+1)/2;
			if (left - right + 2 * mid >= start + 2 * mid) {
				max = mid;
			} else {
				min = mid;
			}
		}
		
		
		
		if (right >= start * max + max * max) {
			right -= (start * max + max * max);
			left -= (start * (max+1) + max * (max-1));
			if (rev) {
				long tmp = right;
				right = left;
				left = tmp;
			}
			return new MyData(left, right, start + max * 2 +1);
		} else {
			min = 0;
			max = Integer.MAX_VALUE/2;
			while (max-min>1) {
				long mid = min + (max-min)/2;
				if (right >= start * mid + mid * mid) {
					min = mid;
				} else {
					max = mid;
				}
			}
			
			right -= (start * min + min * min);
			left -= (start * min + min * (min-1));
			long count = start + min * 2;
			if (left >= start + min * 2) {
				left -= (start + min * 2);
				count ++ ;
			}
			if (rev) {
				long tmp = right;
				right = left;
				left = tmp;
			}
			return new MyData(left, right, count);
		}

		

	}
	
	
}
	
class MyData{
	long left;
	long right;
	long num;
	
	MyData (long left, long right, long num) {
		this.left=left;
		this.right=right;
		this.num=num;
	}
}