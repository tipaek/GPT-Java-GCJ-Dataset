import java.util.*;
import java.math.*;

// public class A{
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		char[] a;
		StringBuffer o;
		for(int t = 0, cases = sc.nextInt(); t < cases; t++){
			a = sc.next().toCharArray();
			
			o = new StringBuffer();
			repeat('(', a[0] - '0', o);
			o.append(a[0]);
			for(int i = 1, d; i < a.length; i++){
				d = a[i] - a[i - 1];
				if(d < 0)
					repeat(')', -d, o);
				else if(d > 0)
					repeat('(', d, o);
				
				o.append(a[i]);
			}
			repeat(')', a[a.length - 1] - '0', o);
			
			System.out.println("Case #" + (t + 1) + ": " + o);
		}
		
		sc.close();
	}
	
	private static void repeat(char c, int n, StringBuffer sb){
		for(int i = 0; i < n; i++)
			sb.append(c);
	}
}