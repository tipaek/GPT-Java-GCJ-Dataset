
import java.util.Scanner;
import java.util.Vector;

/**
 * @author shrey
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t;
		t=sc.nextInt();
		for(int k=1;k<=t;k++) {
			String s;
			s=sc.next();
			int [] a = new int[s.length()];
			char p=')',n='(';
			int diff=0;
			for(int i=0;i<s.length();i++) {
				a[i]=Character.getNumericValue(s.charAt(i));
			}
			Vector<Character> v = new Vector<Character>();
			for(int i=0;i<s.length();i++) {
				if(i==0) {
					if(a[i]>0) {
						for(int j=0;j<a[i];j++) v.add(n);
					}
				}
				
				v.add(s.charAt(i));
				
				if(i+1<s.length()) {
					diff=a[i]-a[i+1];
					if(diff>0) {
						for(int j=0;j<diff;j++) v.add(p);
					}
					else if(diff<0) {
						for(int j=0;j<Math.abs(diff);j++) v.add(n);
					}
					else {
						
					}
				}
				
				if(i==s.length()-1) {
					if(a[i]>0) {
						for(int j=0;j<a[i];j++) v.add(p);
					}
				}
			}
			System.out.print("Case #"+k+": ");
			for(int i=0;i<v.size();i++) {
				System.out.print(v.get(i));
			}
			System.out.println();
		}
	}

}
