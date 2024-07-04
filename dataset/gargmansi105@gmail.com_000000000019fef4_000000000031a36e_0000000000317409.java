import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int t=1;t<=test;t++ ) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			String M=sc.next();
			
			int ans=-1;
			int dist=Math.abs(x)+Math.abs(y);
			if(dist<=0) {
				ans=0;
			}
			for(int i=0;i<M.length();i++) {
				char ch=M.charAt(i);
				if(ch=='N') {
					y++;
				}else if(ch=='S') {
					y--;
				}else if(ch=='W') {
					x--;
				}else if(ch=='E') {
					x++;
				}
				dist=Math.abs(x)+Math.abs(y);
				if(dist<=i+1) {
					ans=i+1;
					break;
				}
				
			}
			if(ans==-1) {
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}else {
				System.out.println("Case #"+t+": "+ans);
			}
		}
	}

}