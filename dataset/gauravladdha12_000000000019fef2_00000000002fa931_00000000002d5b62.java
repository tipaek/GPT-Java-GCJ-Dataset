import java.util.*;
class Solution{
	public static int check(int x){
		int u=(int)(Math.log(x)/Math.log(2));
		if(Math.pow(2,u)==x)
			return u;
		return u+1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int r=1;
		while(t-->0){
			String ans="";
			int x=sc.nextInt();
			int y=sc.nextInt();
			int x1=Math.abs(x);
			int y1=Math.abs(y);
			int u=0;
			int f=(int)(Math.log(x1+y1+1)/Math.log(2));
			//System.out.println(f);
			if(Math.pow(2,f)==x1+y1+1)
				u=f;
			else if(x1>y1){
				u=check(x1);
				u=(int)Math.pow(2,u);
			}
			else{
				u=check(y1);
				u=(int)Math.pow(2,u);
			}
			
			//System.out.println(u);
			while(u>0){
					if(Math.abs(x)>Math.abs(y))
					{
					if(x>0){
						x=x-u;
						u=u/2;
						ans=ans+"E";
					}
					else{
						x=x+u;
						u=u/2;
						ans=ans+"W";
					}
				}
				else{
					if(y>0){
						y=y-u;
						u=u/2;
						ans=ans+"S";
						//System.out.println("yoooo"+" "+y+" "+u);
					}
					else{
						y=y+u;
						u=u/2;
						ans=ans+"N";
					}
				}
				//System.out.println(x+" "+y);
				}
				if(x==0&&y==0)
					System.out.println("Case #"+r+": "+ans);
				else
					System.out.println("Case #"+r+": IMPOSSIBLE");
				r++;
		}
	}
}