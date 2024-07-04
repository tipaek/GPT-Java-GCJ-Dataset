import java.util.Scanner;

public class Solution {
	public static String addp2(String s) {
		String r = "";
		int count = 0;
        for(int i=0;i<s.length();i++) {
        	if(Integer.parseInt(s.charAt(i)+"")<count && Integer.parseInt(s.charAt(i)+"")!=0) {
        		r = r.substring(0,r.length()-Integer.parseInt(s.charAt(i)+"")) + s.charAt(i) + r.substring(r.length()-Integer.parseInt(s.charAt(i)+""),r.length());
        	}
        	else {
        		if(Integer.parseInt(s.charAt(i)+"")==count && Integer.parseInt(s.charAt(i)+"")!=0) {
        			r = r.substring(0,r.length()-Integer.parseInt(s.charAt(i)+"")-1) + s.charAt(i) + r.substring(r.length()-Integer.parseInt(s.charAt(i)+"")-1,r.length());
        		}
        		else {
        		for(int j=0;j<Integer.parseInt(s.charAt(i)+"");j++) {
        			r += "(";
        		}
        		r+=s.charAt(i);
        		for(int j=0;j<Integer.parseInt(s.charAt(i)+"");j++) {
        			r += ")";
        		}
        		count = Integer.parseInt(s.charAt(i)+"");
        		}
        	}
        	count = Integer.parseInt(s.charAt(i)+"");
        }
		
		return r;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			String s = sc.next();
			s = addp2(s);
			System.out.println("Case #"+(i+1)+": "+s);
		}
	}
}
