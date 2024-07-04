import java.util.Scanner;

class Solution{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int tc=1;tc<=t;tc++ ) {
			String str=sc.next();
			String res="";
			int len=str.length();
			int bal=0;
			for(int i=len-1;i>=0;i--) {
				int num=Integer.parseInt(str.substring(i,i+1));
				while(bal<num) {
					res=")"+res;
					bal++;
				}
				while(bal>num) {
					res="("+res;
					bal--;
				}
				res=num+res;
			}
			while(bal>0) {
				res="("+res;
				bal--;
			}
			System.out.println("Case #"+tc+" "+res);
		}
		
	}
}