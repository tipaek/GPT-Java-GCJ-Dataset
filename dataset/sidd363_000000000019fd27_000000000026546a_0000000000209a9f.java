
import java.util.Scanner;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int test = 1;
		while(t>0) {
			String  s = sc.next();
			compute(s,  test);
			test++;
			t--;
		}
	}

	private static void compute(String s, int test) {
		// TODO Auto-generated method stub
		int active = 0;
		StringBuilder sb = new StringBuilder("");
		int prev = 0;
		// 0((2)1)  (((3))1(2))
		for(int i =0;i<s.length();i++) {
			int curr = Integer.valueOf(s.charAt(i)+"");
			if(i!=0) {
				if(prev!=curr) {
					if(prev>curr) {
						// close the brackets that are in excess
						int tcurr = prev - curr;
						active = curr;
						while((tcurr)>0){
							sb.append(")");
							tcurr--;
						}
					}else {
						// increase the brackets that are less
						int tcurr = curr - prev;
						active = curr;
						while((tcurr)>0){
							sb.append("(");
							tcurr--;
						}
					}
				}
			}else {
				active = curr;
				int tcurr= curr;
				while(tcurr>0) {
					sb.append("(");
					tcurr--;
				}
				
				
			}
			sb.append(s.charAt(i));
			prev = curr;
			
		}
		
		while(active>0) {
			sb.append(")");
			active--;
		}
		System.out.println("Case #"+test+": "+sb.toString());
	}

}
