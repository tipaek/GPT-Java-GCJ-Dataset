import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File ("problem.in"));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			String tp=in.next();
			int [] nums=new int [tp.length()];
			int [] copy=new int [tp.length()];
			String [] open=new String [tp.length()];
			String [] close=new String [tp.length()];
			for (int j=0; j<tp.length(); j++) {
				nums[j]=Integer.parseInt(String.valueOf(tp.charAt(j)));
				copy[j]=nums[j];
				open[j]="";
				close[j]="";
			}
			split (nums, open, close, 0, tp.length()-1);
			StringBuilder sb=new StringBuilder ();
			for (int k=0; k<tp.length(); k++) {
				sb.append (open[k]);
				sb.append (String.valueOf (copy[k]));
				sb.append (close[k]);
			}
			System.out.println("Case #" + i + ": " + sb.toString());
		}
	}
	public static void split (int [] nums, String [] open, String []close, int l, int r) {
		if (l<0||r<0||r>nums.length-1||l>nums.length-1) return;
		if (check (nums, l, r)) {
			return;
		}
		int idx=lowest(nums, l, r);
		for (int i=0; i<nums[idx]; i++) {
			open[l]+="(";
			close[r]+=")";
		}
		boolean rep=false;
		int subtract=nums[idx];
		for (int i=l; i<=r; i++) {
			nums[i]-=subtract;
			if (nums[i]!=0) rep=true;
		}
		if (idx==l&&rep) {
			split (nums, open, close, l+1, r);
		}
		else if (idx==r&&rep) {
			split (nums, open, close, l, r-1);
		}
		else if (rep) {
			split (nums, open, close, l, idx-1);
			split (nums, open, close, idx+1, r);
		}
		return;
	}
	public static boolean check (int [] nums, int l, int r) {
		for (int i=l; i<=r; i++) {
			if (nums[i]!=0) return false;
		}
		return true;
	}
	public static int lowest (int [] nums, int l, int r) {
		int lowest=Integer.MAX_VALUE;
		int index=-1;
		for (int i=l; i<=r; i++) {
			if (nums[i]<lowest) {
				lowest=nums[i];
				index=i;
			}
		}
		return index;
	}
}