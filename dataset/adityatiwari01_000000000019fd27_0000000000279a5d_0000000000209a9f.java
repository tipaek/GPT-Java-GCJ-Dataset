import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()){
		    int T = sc.nextInt();
		    
		    for(int k=0;k<T;k++){
		       String s = sc.next();
		       StringBuilder str = new StringBuilder();
        		int i1 = Character.getNumericValue(s.charAt(0));
        		for(int i=0;i<i1;i++)
        			str.append('(');
        		str.append(i1);
        		
        		int l =s.length();
        		for(int i=1;i<l;i++) {
        			int next = Character.getNumericValue(s.charAt(i));
        			if(next>i1) {
        				for(int j=i1;j<next;j++) {
        					str.append('(');
        				}
        				str.append(next);
        			}
        			if(next<i1) {
        				for(int j=i1;j>next;j--) {
        					str.append(')');
        				}
        				str.append(next);
        			}
        			if(next==i1) {
        				str.append(next);
        			}
        			i1=next;
        		}
        		while(i1!=0) {
        			str.append(')');
        			i1--;
        		}
        		String res = str.toString();
        		System.out.println("Case #"+(k+1)+": "+res);
		    }
		}
	}
}