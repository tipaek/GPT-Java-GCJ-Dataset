import java.util.*;
public class Solution{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int cas=1;
		while(n>0) {
			int xpos=0,ypos=0;
			int x=sc.nextInt();
			int y=sc.nextInt();
			int flag=0;
			String str=sc.nextLine();
			for(int i=0;i<str.length();i++) {

				int time=i+1;
				if(str.charAt(i)=='N') {
					y=y+1;
				}else if(str.charAt(i)=='S') {
					y=y-1;
				}else if(str.charAt(i)=='E') {
					x++;
				}else if(str.charAt(i)=='W'){
					x--;
				}

				//System.out.println(x+","+y);
				int t1=Math.abs(x-xpos);
				int t2=Math.abs(y-ypos);
				if(t1+t2<=i) {
					flag=1;
//					System.out.println(x+"-"+y);
					System.out.println("Case #"+cas+": "+i);
					
					break;
					
				}
			}
			if(flag==0) {
				System.out.println("Case #"+cas+": "+"IMPOSSIBLE");
			}
			cas++;
			n--;
		}
	}
}
