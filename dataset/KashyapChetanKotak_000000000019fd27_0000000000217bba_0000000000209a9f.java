import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tcn=Integer.parseInt(sc.nextLine());
		for(int tc=0; tc<tcn; tc++) {
			String n=sc.next();
			char[] num=n.toCharArray();
			StringBuilder ns=new StringBuilder(n);
			int parenCount=0;
			for(int i=0;i<ns.length();i++) {
				int currInt=Character.getNumericValue(ns.charAt(i));
				int parenCountloop=parenCount;
				if(currInt>parenCount) {
					for(int j=0;j<currInt-parenCountloop;j++) {
//						System.out.println("inserting for:"+currInt);
						ns=ns.insert(i, '(');
						parenCount++;
						i++;
					}
				}
				if(currInt<parenCount) {
					for(int j=0;j<parenCountloop-currInt;j++) {
//						System.out.println("inserting for:"+currInt);
						ns=ns.insert(i, ')');
						parenCount--;
						i++;
					}
				}
			}
			for(int j=0;j<parenCount;j++) {
				ns=ns.insert(ns.length(), ')');
			}
			System.out.println("Case #"+(tc+1)+": "+ns);
		}
	}
}
