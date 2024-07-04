import java.util.Scanner;
public class Main {
		public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0; i<n;++i) {
			String s=sc.next();
			String r=""; boolean sw=true;
			if(s.charAt(0)=='1') r+="("+s.charAt(0);
			for(int j=1; j<s.length();++j) {
				if(s.charAt(j)=='1' && s.charAt(j-1)=='0') {
					r+="("+s.charAt(j);
				}else if(s.charAt(j)=='1' && s.charAt(j-1)=='1') {
					r+=s.charAt(j);
				}else if(s.charAt(j)=='0' && s.charAt(j-1)=='1') {
					r+=")"+s.charAt(j);
				}else {
					r+=s.charAt(j);
				}
			}
			if(s.charAt(s.length()-1)=='1') r+=")";
			System.out.println("Case #"+(i+1)+": "+r);
		}
	}

}
