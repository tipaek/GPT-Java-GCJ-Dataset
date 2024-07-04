import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		String s="*";
		for(int t=0;t<T;t++) {
			s="*";
			int N=scanner.nextInt();
			for(int n=0;n<N;n++) {
				String ss=scanner.next();
				int x=Math.min(ss.length(),s.length());
				//System.out.println(s.substring(s.length()-x+1)+"  "+ss.substring(ss.length()-x+1));
				if(ss.equals("*"));
				else if(s.substring(s.length()-x+1).equals(ss.substring(ss.length()-x+1))) {
					if(ss.length()>s.length())s=ss;
				}
				else {
					s="**";
					break;
				}
			}
			
			System.out.println("Case #"+(t+1)+": "+s.substring(1));
		}
	}

}
